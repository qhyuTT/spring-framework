package com.qhyu.cloud.mybatis.service;

import com.qhyu.cloud.mybatis.mapper.GetUserNameMapper;
import com.qhyu.cloud.mybatis.mapper.QhyuTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：Qhyu <br>
 * Package：com.qhyu.cloud.mybatis.service <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:32 <br>
 * @version v1.0 <br>
 */
@Component
public class Qhyu {

	/** 需要注入qhyuTestMapper的代理对象 */
	@Autowired(required = false)
	QhyuTestMapper qhyuTestMapper;

	@Autowired(required = false)
	GetUserNameMapper getUserNameMapper;

	public String testMapper(){
		return qhyuTestMapper.getMessage();
	}

	public String testName(){
		return getUserNameMapper.getNameInfo();
	}
}
