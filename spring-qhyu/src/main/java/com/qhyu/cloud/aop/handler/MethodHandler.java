package com.qhyu.cloud.aop.handler;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MethodHandler <br>
 * Package：com.qhyu.cloud.aop.handler <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:35 <br>
 * @version v1.0 <br>
 */
public interface MethodHandler {
	String invoke(Object[] args) throws Throwable;
}
