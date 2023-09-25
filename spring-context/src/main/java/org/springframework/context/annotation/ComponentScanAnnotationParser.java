/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.filter.AbstractTypeHierarchyTraversingFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

/**
 * Parser for the @{@link ComponentScan} annotation.
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 3.1
 * @see ClassPathBeanDefinitionScanner#scan(String...)
 * @see ComponentScanBeanDefinitionParser
 */
class ComponentScanAnnotationParser {

	private final Environment environment;

	private final ResourceLoader resourceLoader;

	private final BeanNameGenerator beanNameGenerator;

	private final BeanDefinitionRegistry registry;


	public ComponentScanAnnotationParser(Environment environment, ResourceLoader resourceLoader,
			BeanNameGenerator beanNameGenerator, BeanDefinitionRegistry registry) {

		this.environment = environment;
		this.resourceLoader = resourceLoader;
		this.beanNameGenerator = beanNameGenerator;
		this.registry = registry;
	}


	public Set<BeanDefinitionHolder> parse(AnnotationAttributes componentScan, String declaringClass) {
		// 创建ClassPathBeanDefinitionScanner对象，通过componentScan参数中的属性构建了一个对象
		// useDefaultFilters default true
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(this.registry,
				componentScan.getBoolean("useDefaultFilters"), this.environment, this.resourceLoader);
		// 设置Bean名称生成器
		// 从componentScan属性中获取Bean名称生成器的类，并根据需要创建实例。
		// 如果没有指定Bean名称生成器，将使用默认的Bean名称生成器
		Class<? extends BeanNameGenerator> generatorClass = componentScan.getClass("nameGenerator");
		boolean useInheritedGenerator = (BeanNameGenerator.class == generatorClass);
		// 这里利用反射可以生成出来你自定义的，AnnotationBeanNameGenerator，用于生成bean名称的
		scanner.setBeanNameGenerator(useInheritedGenerator ? this.beanNameGenerator :
				BeanUtils.instantiateClass(generatorClass));
		// 设置Scoped proxy模式
		// 从属性中获取Scoped proxy模式，将其设置未扫描器的Scoped proxy模式
		ScopedProxyMode scopedProxyMode = componentScan.getEnum("scopedProxy");
		if (scopedProxyMode != ScopedProxyMode.DEFAULT) {
			scanner.setScopedProxyMode(scopedProxyMode);
		}
		else {
			// AnnotationScopeMetadataResolver
			Class<? extends ScopeMetadataResolver> resolverClass = componentScan.getClass("scopeResolver");
			scanner.setScopeMetadataResolver(BeanUtils.instantiateClass(resolverClass));
		}

		// 设置资源模式，从属性中获取资源模式，并将其设置为扫描器的资源模式,扫描路径下的所有文件
		// **/**.class
		scanner.setResourcePattern(componentScan.getString("resourcePattern"));

		// 添加包含过滤器和排除过滤器：
		// 遍历componentScan属性中的包含过滤器和排除过滤器，并将它们添加到扫描器中。
		// 这些过滤器用于确定哪些类会被扫描并注册为Bean定义，哪些类会被排除。
		// 这里默认就是没有
		for (AnnotationAttributes includeFilterAttributes : componentScan.getAnnotationArray("includeFilters")) {
			List<TypeFilter> typeFilters = TypeFilterUtils.createTypeFiltersFor(includeFilterAttributes, this.environment,
					this.resourceLoader, this.registry);
			for (TypeFilter typeFilter : typeFilters) {
				scanner.addIncludeFilter(typeFilter);
			}
		}
		// 默认没有
		for (AnnotationAttributes excludeFilterAttributes : componentScan.getAnnotationArray("excludeFilters")) {
			List<TypeFilter> typeFilters = TypeFilterUtils.createTypeFiltersFor(excludeFilterAttributes, this.environment,
				this.resourceLoader, this.registry);
			for (TypeFilter typeFilter : typeFilters) {
				scanner.addExcludeFilter(typeFilter);
			}
		}

		// 设置Lazy Initialization（懒加载）：
		// 从componentScan属性中获取懒加载的配置，并根据需要将其设置为Bean定义的默认值。
		boolean lazyInit = componentScan.getBoolean("lazyInit");
		if (lazyInit) {
			scanner.getBeanDefinitionDefaults().setLazyInit(true);
		}
		// 解析基础包路径：
		//从componentScan属性中获取基础包路径的配置。
		//如果未指定基础包路径，将使用declaringClass的包路径作为默认值。
		Set<String> basePackages = new LinkedHashSet<>();
		String[] basePackagesArray = componentScan.getStringArray("basePackages");
		for (String pkg : basePackagesArray) {
			String[] tokenized = StringUtils.tokenizeToStringArray(this.environment.resolvePlaceholders(pkg),
					ConfigurableApplicationContext.CONFIG_LOCATION_DELIMITERS);
			Collections.addAll(basePackages, tokenized);
		}
		for (Class<?> clazz : componentScan.getClassArray("basePackageClasses")) {
			basePackages.add(ClassUtils.getPackageName(clazz));
		}
		// 如果没有写，将使用declaringClass，也就是AopConfig这个类的路径。这也是spring里面不写basePackages的原因，直接约定大于配置。
		if (basePackages.isEmpty()) {
			basePackages.add(ClassUtils.getPackageName(declaringClass));
		}

		// 添加排除过滤器：
		//添加一个排除过滤器，该过滤器用于排除与declaringClass相同的类，以避免将其注册为Bean定义。
		scanner.addExcludeFilter(new AbstractTypeHierarchyTraversingFilter(false, false) {
			@Override
			protected boolean matchClassName(String className) {
				return declaringClass.equals(className);
			}
		});
		// 实际做事的地方就是去doScan
		// 最终，调用scanner.doScan方法来扫描指定的基础包路径，并返回扫描结果作为Set<BeanDefinitionHolder>。
		return scanner.doScan(StringUtils.toStringArray(basePackages));
	}

}
