package com.qhyu.cloud.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
@Order(99)
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
}
