package com.qhyu.cloud.expand;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CloudBeanFactoryPostProcessor <br>
 * Package：com.qhyu.cloud.expand <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月10日 11:57 <br>
 * @version v1.0 <br>
 */
@Component
public class CloudBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
