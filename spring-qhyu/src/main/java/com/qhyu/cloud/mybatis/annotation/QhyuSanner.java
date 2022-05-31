package com.qhyu.cloud.mybatis.annotation;

import com.qhyu.cloud.mybatis.config.QhyuImportBeanDefinitionRegist;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuSanner <br>
 * Package：com.qhyu.cloud.mybatis.annotation <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:21 <br>
 * @version v1.0 <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(QhyuImportBeanDefinitionRegist.class)
public @interface QhyuSanner {

	// 定义一个扫描接口，为了扫描我定义的接口，同时接口上有我的特殊注解
	@AliasFor("path")
	String value() default "";

	@AliasFor("value")
	String path() default "";
}
