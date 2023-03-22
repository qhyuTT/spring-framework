package com.qhyu.cloud.aop.targetSource;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：User <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:41 <br>
 * @version v1.0 <br>
 */
public class User {
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				'}';
	}
}
