package com.qhyu.cloud.aop.dynamic;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：Target <br>
 * Package：com.qhyu.cloud.aop.dynamic <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月24日 9:43 <br>
 * @version v1.0 <br>
 */
// 定义一个目标类，因为我们不清楚我们要代理的是什么接口，所以要使用范型，并且包含一个该范型的class属性type
public class Target<T> {

	private Class<T> type;

	public Class<T> getType() {
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public Target(Class<T> type) {
		this.type = type;
	}
}
