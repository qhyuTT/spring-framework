package com.qhyu.cloud.expand.targetsource;

import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TargetSourceConfig <br>
 * Package：com.qhyu.cloud.expand.targetsource <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月12日 11:36 <br>
 * @version v1.0 <br>
 */
@Configuration
@SuppressWarnings("serial")
public class TargetSourceConfig extends AbstractAdvisorAutoProxyCreator {

	public TargetSourceConfig(CloudTargetSourceCreator cloudTargetSource) {
		super.setCustomTargetSourceCreators(cloudTargetSource);
	}

}
