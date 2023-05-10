package com.qhyu.cloud.circlarRefrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：A <br>
 * Package：com.qhyu.cloud.circleRefrence <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 10月17日 11:27 <br>
 * @version v1.0 <br>
 */
@Repository
//@EnableTransactionManagement(proxyTargetClass = true)
public class A implements Ainterface{

	// 基于jdk的动态代理
	@Autowired
	private B b;

	//@Transactional(rollbackFor = Exception.class)
	@Override
	public void methodA() {
	}
}
