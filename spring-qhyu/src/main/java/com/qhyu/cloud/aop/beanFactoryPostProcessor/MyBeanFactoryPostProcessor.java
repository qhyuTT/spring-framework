package com.qhyu.cloud.aop.beanFactoryPostProcessor;

import org.springframework.aop.framework.autoproxy.InfrastructureAdvisorAutoProxyCreator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MyBeanFactoryPostProcessor <br>
 * Package：com.qhyu.cloud.aop.beanFactoryPostProcessor <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月21日 16:21 <br>
 * @version v1.0 <br>
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// 创建Advisor
		BeanDefinitionBuilder advisorBuilder = BeanDefinitionBuilder.genericBeanDefinition(MyAdvisor.class);
		beanFactory.registerSingleton("myAdvisor", advisorBuilder.getBeanDefinition());

		// 创建InfrastructureAdvisorAutoProxyCreator
		BeanDefinitionBuilder creatorBuilder = BeanDefinitionBuilder.genericBeanDefinition(InfrastructureAdvisorAutoProxyCreator.class);
		creatorBuilder.addPropertyValue("advisorBeanNames", "myAdvisor");
		beanFactory.registerSingleton(InfrastructureAdvisorAutoProxyCreator.class.getName(),creatorBuilder.getBeanDefinition());
	}
}
