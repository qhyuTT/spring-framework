package com.qhyu.cloud.aop.dynamic;

import com.qhyu.cloud.aop.handler.MethodHandler;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：PrintMethodArgsHandler <br>
 * Package：com.qhyu.cloud.aop.dynamic <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:36 <br>
 * @version v1.0 <br>
 */
// jdk的动态代理,要代理一个接口，实现类似mybattis plus中的@mapper接口
@Component
public class PrintMethodArgsHandler implements InvocationHandler {

	private Map<Method, MethodHandler> dispatch;

	public PrintMethodArgsHandler(Map<Method, MethodHandler> dispatch) {
		this.dispatch = dispatch;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("开始打印增强!");
		return dispatch.get(method).invoke(args);
	}
}
