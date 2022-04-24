package com.qhyu.cloud.aop.factory;

import com.qhyu.cloud.aop.annotation.PrintlnAnnotation;
import com.qhyu.cloud.aop.dynamic.Target;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.io.IOException;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TargetFactory <br>
 * Package：com.qhyu.cloud.aop.factory <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月24日 9:46 <br>
 * @version v1.0 <br>
 */
// 创建一个工厂，用来获取特定路径下的目标类
// 我要实现applicationContextAware这种方式来获取注解的话，没法定义为static
public class TargetFactory{

	@SuppressWarnings({"rawtypes","unchecked"})
	public static Target createTarget(){
		//  获取指定路径下的所有类，我们可以获取com.qhyu.cloud.service下的所有
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();

		// 参考@Component的实现 org.springframework.context.annotation.ClassPathBeanDefinitionScanner
		// doScan方法--》findCandidateComponents(basePackage)-->scanCandidateComponents(basePackage)
		String allAnnotationInterfacePath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+ClassUtils.convertClassNameToResourcePath(
				"com.qhyu.cloud")+"/**/*.class";
		Class object = null;
		try {
			MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(resourcePatternResolver);
			Resource[] resources = resourcePatternResolver.getResources(allAnnotationInterfacePath);
			for (Resource resource : resources) {
				MetadataReader metadataReader = readerFactory.getMetadataReader(resource);
				String className = metadataReader.getClassMetadata().getClassName();
				Class<?> aClass = Class.forName(className);
				if (aClass.isAnnotationPresent(PrintlnAnnotation.class)){
					object =aClass;
					break;
				}
			}
		} catch (IOException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return new Target(object);
	}


}
