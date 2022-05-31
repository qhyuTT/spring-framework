package com.qhyu.cloud.mybatis.mapper;

import com.qhyu.cloud.mybatis.annotation.QhyuSelect;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：GetUserNameMapper <br>
 * Package：com.qhyu.cloud.mybatis.mapper <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 17:51 <br>
 * @version v1.0 <br>
 */
public interface GetUserNameMapper {

	@QhyuSelect("Select 'qhyu'")
	String getNameInfo();
}
