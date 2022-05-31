package com.qhyu.cloud.mybatis;

import com.qhyu.cloud.mybatis.service.Qhyu;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MyBatisAppliction <br>
 * Package：com.qhyu.cloud.mybatis <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 11:15 <br>
 * @version v1.0 <br>
 */
public class MyBatisAppliction {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =
				new AnnotationConfigApplicationContext(MybatisConfig.class);
		Qhyu bean = annotationConfigApplicationContext.getBean(Qhyu.class);
		bean.testMapper();
		bean.testName();
	}
}
