package com.qhyu.cloud.mybatis.handler;

import com.qhyu.cloud.mybatis.annotation.QhyuSelect;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MethodArgsHandler <br>
 * Package：com.qhyu.cloud.mybatis.handler <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:41 <br>
 * @version v1.0 <br>
 */
@Component
public class MethodArgsHandler implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (Object.class.equals(method.getDeclaringClass())) {
			return method.invoke(this,args);
		}
		QhyuSelect annotation = method.getAnnotation(QhyuSelect.class);
		// 这里我直接返回，实际上的操作是通过sql进行查询
		System.out.println(annotation.value());
		return annotation.value();
	}
}
