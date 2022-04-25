package com.qhyu.cloud.expand;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuAbstractApplicationContext <br>
 * Package：com.qhyu.cloud.expand <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月25日 10:20 <br>
 * @version v1.0 <br>
 */
public class QhyuAbstractApplicationContext extends AnnotationConfigApplicationContext {
	public QhyuAbstractApplicationContext(Class<?>... componentClasses) {
		super(componentClasses);
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		System.out.println(beanFactory.getSingletonCount());
	}
}
