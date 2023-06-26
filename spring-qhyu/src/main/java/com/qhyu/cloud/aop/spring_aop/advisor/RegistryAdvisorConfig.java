package com.qhyu.cloud.aop.spring_aop.advisor;

import com.qhyu.cloud.aop.spring_aop.advice.LogArgsAdvice;
import com.qhyu.cloud.aop.spring_aop.advice.LogResultAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：RegistryAdvisorConfig <br>
 * Package：com.qhyu.cloud.aop.spring_aop.advisor <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 05月17日 10:45 <br>
 * @version v1.0 <br>
 */
@Configuration
public class RegistryAdvisorConfig {

	@Bean
	public Advisor logArgsAdvisor(){
		return new RegexpMethodPointcutAdvisor("com.qhyu.cloud.aop.spring_aop.service..*",new LogArgsAdvice());
	}

	// 用这种方法可能更加灵活一些
	@Bean
	public Advisor logResultAdvisor(){
		return new RegexpMethodPointcutAdvisor("com.qhyu.cloud.aop.spring_aop.service..*",new LogResultAdvice());
	}
}
