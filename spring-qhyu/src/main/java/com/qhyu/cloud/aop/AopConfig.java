package com.qhyu.cloud.aop;

import com.qhyu.cloud.mybatis.annotation.QhyuSanner;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：AopConfig <br>
 * Package：com.qhyu.cloud.aop <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月22日 16:21 <br>
 * @version v1.0 <br>
 */
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.qhyu.cloud.**"})
public class AopConfig {

	/**
	 * AOP:Aspect-Oriented Programing 面向切面编程，全程
	 * AspectJ,Spring AOP
	 * AOP要实现的是在我们原来写的代码的基础上，进行一定的包装，如在方法执行前后、方法抛出异常后等地方进行一定的拦截处理，或者叫增强处理。
	 * 作为java开发者，我们都很熟悉AspectJ这个词，甚至于我们提到AOP的时候就享到了AspectJ。首先我们对比下这两者：
	 * spring AOP：
	 * - 它基于动态代理来实现。如果使用接口，用JDK的动态代理实现，如果没有接口使用CGLIB实现。
	 * - 如果你是web开发者，有的时候，可能需要的是filter或者Interceptor，而不一定是AOP
	 * - 很多人会对比springAOP和AspectJ的性能，SpringAOP是基于代理实现的，在容器启动的时候需要生成代理实例，在方法调用上也会增加栈的深度，使得springAOP的性能不如AspectJ
	 *
	 * AspectJ：
	 * - 出身名门，Eclipse基金会。
	 * - 属于静态织入，它是通过修改代码来实现的，它有三个不同的织入时机
	 * - Compile-time weaving：编译器织入
	 * - Post-compile weaving:也就是生成了.class文件或者已经打成jar包了，这种情况需要增强的话，需要用道编译后织入
	 * - Load-time weaving：指的是在加载类的时候进行织入，要实现这个时期的织入，有几种常见的方法1、自定义类加载器来干这个。2、在JVM启动的时候指定AspectJ提供的agent（这个可以后续了解一下）
	 *
	 * AspectJ是AOP的完美解决方案。SpringAOP致力于解决的是企业级开发中最普遍的AOP需求。
	 * Spring AOP 的原理很简单，就是动态代理，它和 AspectJ 不一样，AspectJ 是直接修改掉你的字节码。
	 */

	@Bean
	public MessageSource messageSource(){
		// 国际化
		ResourceBundleMessageSource delegateMessageSource = new ResourceBundleMessageSource();
		delegateMessageSource.setBasename("format"); // 设置委派消息源的基本名称
		DelegatingMessageSource delegatingMessageSource = new DelegatingMessageSource();
		delegatingMessageSource.setParentMessageSource(delegateMessageSource);
		return delegatingMessageSource;
	}
}
