package com.qhyu.cloud.circlarRefrence;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：C <br>
 * Package：com.qhyu.cloud.circlarRefrence <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 05月09日 14:13 <br>
 * @version v1.0 <br>
 */
@Service
@Lazy
public class C {

	public C(){
		System.out.println("C instantiate");
	}
	public void test(){
		System.out.println("lazy。。。。");
	}
}
