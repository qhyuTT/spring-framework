package com.qhyu.cloud.aop.service.impl;

import com.qhyu.cloud.aop.dynamic.Target;
import com.qhyu.cloud.aop.factory.TargetFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：DynamicProxyServiceBeanRegister <br>
 * Package：com.qhyu.cloud.aop.service.impl <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月24日 16:02 <br>
 * @version v1.0 <br>
 */
//干预BeanDefinition
@Component
public class DynamicProxyServiceBeanRegister implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
	@SuppressWarnings({"rawtypes"})
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 获取我们的目标类，当前是个接口
		Target target = TargetFactory.createTarget();
		// 根据接口生成一个bean的建造者
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(target.getType());
		// 根据建造者获取bean的定义器，也就是BeanDefinition
		GenericBeanDefinition definition = (GenericBeanDefinition) builder.getRawBeanDefinition();
		// 拿到这个类的构造函数里面的参数信息，就是为了确认类型一致
		// 指定构造方法得参数
		definition.getConstructorArgumentValues().addGenericArgumentValue(target.getType());
		//定义@Autowired的装配方式，这里用默认装配方式即可
		// definition.setAutowireMode(GenericBeanDefinition.AUTOWIRE_BY_TYPE);
		//定义bean工厂中的动态代理代理的接口实例为bean的对象
		definition.setBeanClass(ProxyBeanFactory.class);
		// 将别名也就是bean的名称和definition绑定
		registry.registerBeanDefinition(target.getType().getSimpleName(), definition);
	}
}
