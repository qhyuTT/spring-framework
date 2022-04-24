package com.qhyu.cloud.aop.handler;

import java.util.stream.Stream;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：DefaultMethodHander <br>
 * Package：com.qhyu.cloud.aop.handler <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:36 <br>
 * @version v1.0 <br>
 */
public class DefaultMethodHander implements MethodHandler{

	@Override
	public String invoke(Object[] args) throws Throwable {
		Stream.of(args).sequential().forEach(System.out::println);
		return "我直接返回数据库查询的数据";
	}
}
