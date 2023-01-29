package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.datasource.service.TransactionService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		// 事务回滚了吗，测试事务和aop的时候使用
		TransactionService bean = annotationConfigApplicationContext.getBean(TransactionService.class);
		//bean.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		bean.doUpdate("0008cce0-3c92-45ea-957f-4f6dd568a3e2",0);
	}
}
