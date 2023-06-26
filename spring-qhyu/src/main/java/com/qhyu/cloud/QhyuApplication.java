package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.aop.spring_aop.service.OrderService;
import com.qhyu.cloud.circlarRefrence.C;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		OrderService bean = annotationConfigApplicationContext.getBean(OrderService.class);
		bean.queryOrder("qhyu");
		//QhyuAspectService bean1 = annotationConfigApplicationContext.getBean(QhyuAspectService.class);
		//bean1.test();
		// 事务回滚了吗，测试事务和aop的时候使用
		/*TransactionService bean = annotationConfigApplicationContext.getBean(TransactionService.class);
		bean.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		bean.doUpdate("0008cce0-3c92-45ea-957f-4f6dd568a3e2",1);*/

	}
}
