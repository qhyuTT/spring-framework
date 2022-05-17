package com.qhyu.cloud.jdk;

import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ReentrantLockUnFairLock <br>
 * Package：com.qhyu.cloud.jdk <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月27日 14:36 <br>
 * @version v1.0 <br>
 */
public class ReentrantLockUnFairLock {
	public static void main(String[] args) {
		// 默认就是非公平锁
		ReentrantLock reentrantLock = new ReentrantLock();
		reentrantLock.lock();
		try{
			System.out.println("qhyu");
		}finally {
			reentrantLock.unlock();
		}
	}
}
