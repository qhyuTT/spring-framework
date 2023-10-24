package com.qhyu.cloud.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ThamNotVeryUsefulAspect <br>
 * Package：com.qhyu.cloud.aop.aspect <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 14:49 <br>
 * @version v1.0 <br>
 */
@Component
@Aspect
//@Order(98)
public class ThamNotVeryUsefulAspect {
	@Pointcut("execution(* com.qhyu.cloud.aop.service.QhyuAspectService.*(..))") // the pointcut expression
	private void thamAnyOldTransfer() {} // the pointcut signature

	@Before("thamAnyOldTransfer()")
	public void before(){
		System.out.println("tham Before 方法调用前");
	}

	@After("thamAnyOldTransfer()")
	public void after(){
		System.out.println("tham After 方法调用前");
	}
	
	@AfterReturning("thamAnyOldTransfer()")
	public void afterReturning(){
		System.out.println("tham afterReturning");
	}
	
	@AfterThrowing("thamAnyOldTransfer()")
	public void afterThrowing(){
		System.out.println("tham AfterThrowing");
	}
	
	@Around("thamAnyOldTransfer()")
	public Object  around(ProceedingJoinPoint pjp) throws Throwable{
		// start stopwatch
		System.out.println("tham around before");
		Object retVal = pjp.proceed();
		// stop stopwatch
		System.out.println("tham around after");
		return retVal;
	}
}
