package com.qhyu.cloud.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TransactionAspect <br>
 * Package：com.qhyu.cloud.aop.aspect <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月28日 11:27 <br>
 * @version v1.0 <br>
 */
@Aspect
@Component
//@Order(value = Ordered.HIGHEST_PRECEDENCE+1)
// 用来测试事务和aop同时存在的异常情况
public class TransactionAspect {

	@Pointcut("execution(* com.qhyu.cloud.datasource.service.TransactionService.*(..))") // the pointcut expression
	private void transactionLogInfo() {} // the pointcut signature


	/**
	 * Title：around <br>
	 * Description：这个Around吃掉了异常 <br>
	 * 不太建议吃掉异常，出现这个问题的原因需要排查下为什么？
	 * author：于琦海 <br>
	 * date：2022/6/28 14:11 <br>
	 * @param
	 * @return
	 */
	@Around("transactionLogInfo()")
	public Object around(ProceedingJoinPoint pjp){
		Object proceed = null;
		System.out.println("调用目标方法前:@Around");
		try {
			// aop拦截器
			 proceed = pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("调用目标方法后:@Around");
		return proceed;
	}
}
