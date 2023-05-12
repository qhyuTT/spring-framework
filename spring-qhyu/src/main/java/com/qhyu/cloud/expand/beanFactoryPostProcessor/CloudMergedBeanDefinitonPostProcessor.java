package com.qhyu.cloud.expand.beanFactoryPostProcessor;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CloudMergedBeanDefinitonPostProcessor <br>
 * Package：com.qhyu.cloud.expand.beanFactoryPostProcessor <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月12日 14:38 <br>
 * @version v1.0 <br>
 */
@Component
public class CloudMergedBeanDefinitonPostProcessor implements MergedBeanDefinitionPostProcessor {
	@Override
	public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType,
												String beanName) {
		// 实现MergedBeanDefinitionPostProcessor接口,加上Component注解,被spring管理
		// 至于是什么时机放入BeanPostProcessorCache中我没有深究了

	}
}
