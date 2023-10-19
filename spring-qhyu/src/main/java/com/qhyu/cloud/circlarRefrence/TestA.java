package com.qhyu.cloud.circlarRefrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * All rights Reserved, Designed By https://umd.edu/ <br>
 * Title：TestA <br>
 * Package：com.qhyu.cloud.circlarRefrence <br>
 * Copyright © 2023 umd.edu. All rights reserved. <br>
 * Company：The University of Maryland  <br>
 *
 * @author candidate <br>
 * @date 2023年 10月19日 14:05 <br>
 */
//@Service
public class TestA {

	public TestA(TestB testB) {
		this.testB = testB;
	}

	TestB testB;
}
