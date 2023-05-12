package com.qhyu.cloud.expand.targetsource;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.TargetSourceCreator;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CloudTargetSource <br>
 * Package：com.qhyu.cloud.expand <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月12日 10:31 <br>
 * @version v1.0 <br>
 */
@Component
public class CloudTargetSourceCreator implements TargetSourceCreator {

	@Override
	public TargetSource getTargetSource(Class<?> beanClass, String beanName) {
		// 这里面可以自定义一个TargetSource,但是我可以指定某些bean使用自定义的targetSource
		return null;
	}
}
