package com.qhyu.cloud.aop.spring_aop.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：LogResultAdvice <br>
 * Package：com.qhyu.cloud.aop.spring_aop.advice <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 05月17日 10:45 <br>
 * @version v1.0 <br>
 */
public class LogResultAdvice implements AfterReturningAdvice{
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
			throws Throwable {
		// 会先执行方法 然后再执行这里面的内容
		System.out.println(method.getName() + "方法返回：" + returnValue);
	}
}
