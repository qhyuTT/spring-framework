package com.qhyu.cloud.datasource.service.impl;

import com.qhyu.cloud.datasource.dao.TransactionDao;
import com.qhyu.cloud.datasource.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：TransactionServiceImpl <br>
 * Package：com.qhyu.cloud.datasource.service.impl <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月28日 10:26 <br>
 * @version v1.0 <br>
 */
@Component
public class TransactionServiceImpl implements TransactionService {

	@Autowired
	TransactionDao transactionDao;
	@Override
	public void doQuery(String id) {
		System.out.println(transactionDao.UserQuery(id));
	}

	//@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	@Override
	public void doUpdate(String id,int flag) {
		int i = transactionDao.UserUpdate(id, flag);
		System.out.println("更新用户表信息"+i+"条");
	}
}
