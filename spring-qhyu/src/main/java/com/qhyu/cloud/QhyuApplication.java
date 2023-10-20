package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.aop.service.QhyuAspectService;
import com.qhyu.cloud.aop.spring_aop.service.OrderService;
import com.qhyu.cloud.circlarRefrence.C;
import com.qhyu.cloud.datasource.service.TransactionService;
import com.qhyu.cloud.springEvent.EmailService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		//test(annotationConfigApplicationContext);

		aspectTest(annotationConfigApplicationContext);
		//eventTest(annotationConfigApplicationContext);
		//transactionTest(annotationConfigApplicationContext);

	}

	private static void test(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		OrderService bean = annotationConfigApplicationContext.getBean(OrderService.class);
		bean.queryOrder("qhyu");
	}

	private static void aspectTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		QhyuAspectService bean1 = annotationConfigApplicationContext.getBean(QhyuAspectService.class);
		bean1.test();
	}

	private static void eventTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		EmailService bean = annotationConfigApplicationContext.getBean(EmailService.class);
		bean.sendEmail("192.168.1.1","confirm");
	}

	private static void transactionTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		// 事务回滚了吗，测试事务和aop的时候使用
		TransactionService bean2 = annotationConfigApplicationContext.getBean(TransactionService.class);
		bean2.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		bean2.doUpdate("0008cce0-3c92-45ea-957f-4f6dd568a3e2",1);
	}
}
