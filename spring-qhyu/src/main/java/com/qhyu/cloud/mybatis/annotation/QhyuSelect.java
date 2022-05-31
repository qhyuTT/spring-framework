package com.qhyu.cloud.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuSelect <br>
 * Package：com.qhyu.cloud.mybatis.annotation <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:30 <br>
 * @version v1.0 <br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface QhyuSelect {

	String value() default "";
}
