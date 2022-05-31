package com.qhyu.cloud.mybatis.mapper;

import com.qhyu.cloud.mybatis.annotation.QhyuSelect;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：QhyuTestMapper <br>
 * Package：com.qhyu.cloud.mybatis.mapper <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 05月30日 10:29 <br>
 * @version v1.0 <br>
 */
public interface QhyuTestMapper {
	
	/**
	 * Title：getMessage <br>
	 * Description：通过注解的方式调用方法并且返回 <br>
	 * author：于琦海 <br>
	 * date：2022/5/30 10:29 <br>
	 * @return String
	 */
	@QhyuSelect("Select 'User'")
	String getMessage();
}
