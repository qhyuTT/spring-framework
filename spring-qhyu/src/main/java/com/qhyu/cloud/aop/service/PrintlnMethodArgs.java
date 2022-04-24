package com.qhyu.cloud.aop.service;

import com.qhyu.cloud.aop.annotation.PrintlnAnnotation;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：PrintlnMethodArgs <br>
 * Package：com.qhyu.cloud.aop.service <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:34 <br>
 * @version v1.0 <br>
 */
@PrintlnAnnotation
public interface PrintlnMethodArgs {

	String getName(String id,String des);
}
