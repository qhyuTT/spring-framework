package com.qhyu.cloud.aop.targetSource;

import java.util.List;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：UserServiceImpl <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:41 <br>
 * @version v1.0 <br>
 */
public class UserServiceImpl implements UserService{
	@Override
	public void addUser(User user) {
		System.out.println("新增一个User"+user.toString());
	}

	@Override
	public void deleteUser(int userId) {
		System.out.println("删除一个User"+userId);
	}

	@Override
	public List<User> getUsers() {
		return null;
	}
}
