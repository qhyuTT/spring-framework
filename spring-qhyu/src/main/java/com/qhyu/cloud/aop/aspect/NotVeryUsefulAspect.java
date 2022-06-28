package com.qhyu.cloud.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
@Component
@Aspect
public class NotVeryUsefulAspect {

	@Pointcut("execution(* com.qhyu.cloud.aop.service.QhyuAspectService.*(..))") // the pointcut expression
	private void anyOldTransfer() {} // the pointcut signature

	@Before("anyOldTransfer()")
	public void before(){
		System.out.println("Before 方法调用前");
	}

	@After("anyOldTransfer()")
	public void after(){
		System.out.println("After 方法调用前");
	}
}
