package com.qhyu.cloud;

import com.qhyu.cloud.aop.AopConfig;
import com.qhyu.cloud.tx.TxConfig;
import org.openjdk.jol.info.ClassLayout;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(AopConfig.class);
	}
}
