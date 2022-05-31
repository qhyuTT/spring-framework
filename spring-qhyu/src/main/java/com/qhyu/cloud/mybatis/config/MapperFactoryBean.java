package com.qhyu.cloud.mybatis.config;

import com.qhyu.cloud.mybatis.handler.MethodArgsHandler;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Proxy;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MapperFactoryBean <br>
 * Package：com.qhyu.cloud.mybatis.config <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:33 <br>
 * @version v1.0 <br>
 */
@Component
public class MapperFactoryBean<T> implements FactoryBean<T> {

	public MapperFactoryBean() {
	}

	private Class<T> target;

	public MapperFactoryBean(Class<T> target) {
		this.target = target;
	}

	@Override
	@SuppressWarnings({"unchecked","rawtypes"})
	public T getObject() throws Exception {
		// 在这里产生代理对象
		return (T) Proxy.newProxyInstance(target.getClassLoader(), new Class[]{getObjectType()}, new MethodArgsHandler());
	}

	/** 默认返回单例就行 */
	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public Class<T> getObjectType() {
		// 直接返回target的类型
		return target;
	}
	
}
