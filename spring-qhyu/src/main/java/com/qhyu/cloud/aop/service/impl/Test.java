package com.qhyu.cloud.aop.service.impl;

import com.qhyu.cloud.aop.service.PrintlnMethodArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Test {

	@Autowired
	PrintlnMethodArgs printlnMethodArgs;
	public Test() {
	//	System.out.println("test 开始我们的源码了");
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	public String opendynamic(){
		return printlnMethodArgs.getName("yuqihai", "真的猛");
	}


}
