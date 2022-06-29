package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.aop.service.QhyuAspectService;
import com.qhyu.cloud.aop.service.impl.QhyuAspectServiceImpl;
import com.qhyu.cloud.datasource.service.TransactionService;
import com.qhyu.cloud.tx.TxConfig;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		TransactionService bean = annotationConfigApplicationContext.getBean(TransactionService.class);
		// 事务回滚了吗
		bean.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		//bean.doUpdate("0008cce0-3c92-45ea-957f-4f6dd568a3e2",1);
	}
}
