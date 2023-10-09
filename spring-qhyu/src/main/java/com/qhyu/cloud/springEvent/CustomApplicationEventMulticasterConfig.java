package com.qhyu.cloud.springEvent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CustomApplicationEventMulticasterConfig <br>
 * Package：com.qhyu.cloud.springEvent <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author piano <br>
 * date 2023年 10月08日 14:16 <br>
 * @version v1.0 <br>
 */
//@Configuration
public class CustomApplicationEventMulticasterConfig {

	@Bean
	public ApplicationEventMulticaster applicationEventMulticaster(){
		SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
		return simpleApplicationEventMulticaster;
	}
}
