package com.qhyu.cloud.aop.service.impl;

import com.qhyu.cloud.aop.service.QhyuAspectService;
import org.springframework.stereotype.Component;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuAspectService <br>
 * Package：com.qhyu.cloud.aop.service.impl <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 06月23日 14:24 <br>
 * @version v1.0 <br>
 */
@Component
public class QhyuAspectServiceImpl implements QhyuAspectService {

	@Override
	public void test() {
		System.out.println("执行我的方法");
	}
}
