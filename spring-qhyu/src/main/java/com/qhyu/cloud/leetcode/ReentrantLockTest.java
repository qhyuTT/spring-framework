package com.qhyu.cloud.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ReentrantLockTest <br>
 * Package：com.qhyu.cloud.leetcode <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 06月12日 11:29 <br>
 * @version v1.0 <br>
 */
public class ReentrantLockTest {
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();

	public void await(){
		lock.lock();
		try {
			System.out.println("等待开始时间"+System.currentTimeMillis());
			condition.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}

	public void signal(){
		lock.lock();
		System.out.println("等待结束时间"+System.currentTimeMillis());
		condition.signal();
		lock.unlock();
	}

	public static void main(String[] args) throws InterruptedException {
		ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
		new Thread(()->{
			reentrantLockTest.await();
			System.out.println("逻辑执行时间"+System.currentTimeMillis());
		},"A").start();
		Thread.sleep(2000);
		reentrantLockTest.signal();
	}
}