package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.aop.service.impl.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		Test bean = annotationConfigApplicationContext.getBean(Test.class);
		String opendynamic = bean.opendynamic();
		System.out.println(opendynamic);
	}
}
