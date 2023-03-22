package com.qhyu.cloud.aop.targetSource;

import org.springframework.aop.TargetSource;

import java.util.List;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：UserAccessControlTargetSource <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:43 <br>
 * @version v1.0 <br>
 */
public class UserAccessControlTargetSource implements TargetSource {
	private final Object target;
	private final List<String> allowedRoles;

	public UserAccessControlTargetSource(Object target, List<String> allowedRoles) {
		this.target = target;
		this.allowedRoles = allowedRoles;
	}

	@Override
	public Class<?> getTargetClass() {
		// 根据权限来控制具体使用什么class
		return target.getClass();
	}

	@Override
	public boolean isStatic() {
		return false;
	}

	@Override
	public Object getTarget() {
		if (isAuthorized()) {
			return target;
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public void releaseTarget(Object target) {
		// 释放目标对象
	}

	private boolean isAuthorized() {
		// 检查当前用户是否具有访问目标对象的权限
		return true;
	}
}
