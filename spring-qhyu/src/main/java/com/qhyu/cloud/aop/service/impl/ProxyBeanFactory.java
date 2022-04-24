package com.qhyu.cloud.aop.service.impl;

import com.qhyu.cloud.aop.dynamic.PrintMethodArgsHandler;
import com.qhyu.cloud.aop.dynamic.Target;
import com.qhyu.cloud.aop.factory.TargetFactory;
import com.qhyu.cloud.aop.handler.DefaultMethodHander;
import com.qhyu.cloud.aop.handler.MethodHandler;
import com.qhyu.cloud.aop.service.PrintlnMethodArgs;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ProxyBeanFactory <br>
 * Package：com.qhyu.cloud.aop.service.impl <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月24日 15:38 <br>
 * @version v1.0 <br>
 */
public class ProxyBeanFactory implements FactoryBean<PrintlnMethodArgs> {


	public ProxyBeanFactory(Class<PrintlnMethodArgs> interfaceType) {
		this.interfaceType = interfaceType;
	}


	private Class<PrintlnMethodArgs> interfaceType;

	public Class<PrintlnMethodArgs> getInterfaceType() {
		return interfaceType;
	}

	public void setInterfaceType(Class<PrintlnMethodArgs> interfaceType) {
		this.interfaceType = interfaceType;
	}

	@Override
	@SuppressWarnings({"rawtypes", "unchecked"})
	public PrintlnMethodArgs getObject() throws Exception {
		Target target = TargetFactory.createTarget();
		Map<Method, MethodHandler> methodMethodHandler = new HashMap<>(2);
		methodMethodHandler.put(target.getType().getMethods()[0],new DefaultMethodHander());
		PrintMethodArgsHandler printMethodArgsHandler = new PrintMethodArgsHandler(methodMethodHandler);
		return (PrintlnMethodArgs) Proxy.newProxyInstance(target.getType().getClassLoader(),new Class []{target.getType()},printMethodArgsHandler);
	}

	@Override
	public Class<?> getObjectType() {
		return interfaceType;
	}
}
