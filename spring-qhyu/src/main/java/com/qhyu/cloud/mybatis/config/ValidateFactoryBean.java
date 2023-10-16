package com.qhyu.cloud.mybatis.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By https://umd.edu/ <br>
 * Title：ValidateFactoryBean <br>
 * Package：com.qhyu.cloud.mybatis.config <br>
 * Copyright © 2023 umd.edu. All rights reserved. <br>
 * Company：The University of Maryland  <br>
 *
 * @author candidate <br>
 * @date 2023年 10月12日 15:49 <br>
 */
@Component
public class ValidateFactoryBean<T> implements FactoryBean<T> {
	@Override
	public T getObject() throws Exception {
		return null;
	}

	@Override
	public Class<?> getObjectType() {
		return null;
	}
}
