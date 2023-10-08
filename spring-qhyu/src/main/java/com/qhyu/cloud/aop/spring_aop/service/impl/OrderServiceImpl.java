package com.qhyu.cloud.aop.spring_aop.service.impl;

import com.qhyu.cloud.aop.spring_aop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：OrderServiceImpl <br>
 * Package：com.qhyu.cloud.aop.spring_aop.service.impl <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 05月17日 10:54 <br>
 * @version v1.0 <br>
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	MessageSource messageSource;
	@Override
	public Object queryOrder(String name) {
		System.out.println("order名称为:"+name);
		System.out.println(messageSource.getMessage("greeting.message", null, Locale.getDefault()));
		return null;
	}
}
