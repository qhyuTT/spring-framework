package com.qhyu.cloud.aop.targetSource;

import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：AppConfig <br>
 * Package：com.qhyu.cloud.aop.targetSource <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 03月22日 11:45 <br>
 * @version v1.0 <br>
 */
@Configuration
public class AppConfig {
	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public UserAccessControlInterceptor userAccessControlInterceptor() {
		// 用户权限控制的拦截器
		return new UserAccessControlInterceptor(Arrays.asList("admin", "manager"));
	}

	/*@Bean
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
		return new DefaultAdvisorAutoProxyCreator();
	}*/

	@Bean
	public Advisor userAccessControlAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(* com.qhyu.cloud.aop.targetSource.UserService.*(..))");
		return new DefaultPointcutAdvisor(pointcut, userAccessControlInterceptor());
	}
}
