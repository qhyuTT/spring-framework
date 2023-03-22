package com.qhyu.cloud.aop.targetSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.ProxyFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：UserAccessControlInterceptor <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:44 <br>
 * @version v1.0 <br>
 */
public class UserAccessControlInterceptor implements MethodInterceptor {
	private final List<String> allowedRoles;

	public UserAccessControlInterceptor(List<String> allowedRoles) {
		this.allowedRoles = allowedRoles;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		TargetSource targetSource = new UserAccessControlTargetSource(invocation.getThis(), allowedRoles);
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTargetSource(targetSource);
		Object proxy = proxyFactory.getProxy();

		return invocation.getMethod().invoke(proxy, invocation.getArguments());
	}

}
