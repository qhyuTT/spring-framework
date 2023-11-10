package com.qhyu.cloud.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：NotVeryUsefulAspect <br>
 * Package：com.qhyu.cloud.aop.aspect <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月23日 14:19 <br>
 * @version v1.0 <br>
 */
//@Component
@Aspect
@Order(99)
public class NotVeryUsefulAspect {

	@Pointcut("execution(* com.qhyu.cloud.aop.service.QhyuAspectService.*(..))") // the pointcut expression
	private void anyOldTransfer() {} // the pointcut signature

	@Before("anyOldTransfer()")
	public void before(){
		System.out.println("not Before 方法调用前");
	}

	@After("anyOldTransfer()")
	public void after(){
		System.out.println("not After 方法调用前");
	}

	@AfterReturning("anyOldTransfer()")
	public void afterReturning(){
		System.out.println("not afterReturning");
	}

	@AfterThrowing("anyOldTransfer()")
	public void afterThrowing(){
		System.out.println("not AfterThrowing");
	}

	@Around("anyOldTransfer()")
	public Object  around(ProceedingJoinPoint pjp) throws Throwable{
		// start stopwatch
		System.out.println("not around before");
		Object retVal = pjp.proceed();
		// stop stopwatch
		System.out.println("not around after");
		return retVal;
	}
}
