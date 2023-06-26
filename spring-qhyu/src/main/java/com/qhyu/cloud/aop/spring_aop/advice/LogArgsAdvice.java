package com.qhyu.cloud.aop.spring_aop.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：LogArgsAdvice <br>
 * Package：com.qhyu.cloud.aop.spring_aop.advice <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 05月17日 10:43 <br>
 * @version v1.0 <br>
 */
public class LogArgsAdvice implements MethodBeforeAdvice {
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("准备执行方法: " + method.getName() + ", 参数列表：" + Arrays.toString(args));
	}
}
