package com.qhyu.cloud;

import com.qhyu.cloud.tx.TxConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class QhyuApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(TxConfig.class);
	}
}
