package com.qhyu.cloud.mybatis.config;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Set;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuConfigSanner <br>
 * Package：com.qhyu.cloud.mybatis.config <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 11:00 <br>
 * @version v1.0 <br>
 */
public class QhyuConfigSanner extends ClassPathBeanDefinitionScanner {

	public QhyuConfigSanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	/** Spring ClassPath扫描器扫描不包含接口，因为无法生成bean 所以我们这里进行判断修改*/
	@Override
	protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
		return beanDefinition.getMetadata().isInterface();
	}

	/** 修改doSacn方法 */
	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		Set<BeanDefinitionHolder> beanDefinitionHolders = super.doScan(basePackages);
		for (BeanDefinitionHolder beanDefinitionHolder : beanDefinitionHolders) {
			// 修改beanDefinition中的BeanClass属性
			BeanDefinition  beanDefinition = beanDefinitionHolder.getBeanDefinition();
			// 拿到beanDeifinition之后需要设置构造函数
			beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(beanDefinition.getBeanClassName());

			//beanDefinition.getPropertyValues().addPropertyValue("target",beanDefinition.getBeanClassName());
			beanDefinition.setBeanClassName(MapperFactoryBean.class.getName());
		}
		return beanDefinitionHolders;
	}
}
