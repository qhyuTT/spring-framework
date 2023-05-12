package com.qhyu.cloud.expand.targetsource;

import org.springframework.aop.TargetSource;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TargetSourcePO <br>
 * Package：com.qhyu.cloud.circlarRefrence <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月12日 10:46 <br>
 * @version v1.0 <br>
 */
public class CloudTargetSource implements TargetSource {


	@Override
	public Class<?> getTargetClass() {
		return null;
	}


	// 如果targetSource是静态的,它始终返回相同的目标target
	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public Object getTarget() throws Exception {
		return null;
	}

	@Override
	public void releaseTarget(Object target) throws Exception {

	}
}
