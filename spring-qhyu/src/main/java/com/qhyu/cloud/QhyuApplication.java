package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.aop.service.QhyuAspectService;
import com.qhyu.cloud.aop.spring_aop.service.OrderService;
import com.qhyu.cloud.aop.targetSource.UserService;
import com.qhyu.cloud.circlarRefrence.C;
import com.qhyu.cloud.circlarRefrence.TestA;
import com.qhyu.cloud.datasource.service.TransactionService;
import com.qhyu.cloud.springEvent.EmailService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
		//test(annotationConfigApplicationContext);
		//aspectTest(annotationConfigApplicationContext);
		//eventTest(annotationConfigApplicationContext);
		transactionTest(annotationConfigApplicationContext);
		//targetSource(annotationConfigApplicationContext);

		//circularDependency(annotationConfigApplicationContext);

	}

	/**
	 * Title: 测试Bean的实例化过程
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void test(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		OrderService bean = annotationConfigApplicationContext.getBean(OrderService.class);
		bean.queryOrder("qhyu");
	}

	/**
	 * Title: 测试targetSource的使用
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void targetSource(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		UserService bean = annotationConfigApplicationContext.getBean(UserService.class);
		bean.getUsers();
	}

	/**
	 * Title: AOP-Aspect的使用
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void aspectTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		QhyuAspectService bean1 = annotationConfigApplicationContext.getBean(QhyuAspectService.class);
		bean1.test();
	}

	/**
	 * Title: Spring event
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void eventTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		EmailService bean = annotationConfigApplicationContext.getBean(EmailService.class);
		bean.sendEmail("192.168.1.1","confirm");
	}

	/**
	 * Title: 事务和AOP的排序导致的问题
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void transactionTest(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		// 事务回滚了吗，测试事务和aop的时候使用
		TransactionService bean2 = annotationConfigApplicationContext.getBean(TransactionService.class);
		bean2.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		bean2.doUpdate("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
		bean2.doQuery("0008cce0-3c92-45ea-957f-4f6dd568a3e2");
	}

	/**
	 * Title: 测试循环依赖@Lazy的使用
	 * @author  candidate
	 * @date  2023/10/27 14:34
	 * @since  2023/10/27
	 * @param annotationConfigApplicationContext AnnotationConfigApplicationContext
	 */
	private static void circularDependency(AnnotationConfigApplicationContext annotationConfigApplicationContext) {
		// 事务回滚了吗，测试事务和aop的时候使用
		TestA bean2 = annotationConfigApplicationContext.getBean(TestA.class);
		bean2.testA();
	}
}
