package com.qhyu.cloud.aop.targetSource;

import java.util.List;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：UserService <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:40 <br>
 * @version v1.0 <br>
 */
public interface UserService {
	void addUser(User user);

	void deleteUser(int userId);
	List<User> getUsers();
}
