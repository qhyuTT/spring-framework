package com.qhyu.cloud.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：PrintlnAnnotation <br>
 * Package：com.qhyu.cloud.aop.annotation <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:33 <br>
 * @version v1.0 <br>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PrintlnAnnotation {
}
