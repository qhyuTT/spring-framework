package com.qhyu.cloud.leetcode;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CLHLock <br>
 * Package：com.qhyu.cloud.leetcode <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 06月06日 17:09 <br>
 * @version v1.0 <br>
 */
public class CLHLock {
	public static class CLHNode {
		private volatile boolean isLocked = true; // 默认是在等待锁
	}

	private volatile CLHNode tail ;
	private static final AtomicReferenceFieldUpdater<CLHLock, CLHNode> UPDATER = AtomicReferenceFieldUpdater
			. newUpdater(CLHLock.class, CLHNode .class , "tail" );

	public void lock(CLHNode currentThread) {
		CLHNode preNode = UPDATER.getAndSet( this, currentThread);
		if(preNode != null) {//已有线程占用了锁，进入自旋
			while(preNode.isLocked ) {
			}
		}
	}

	public void unlock(CLHNode currentThread) {
		// 如果队列里只有当前线程，则释放对当前线程的引用（for GC）。
		if (!UPDATER .compareAndSet(this, currentThread, null)) {
			// 还有后续线程
			currentThread. isLocked = false ;// 改变状态，让后续线程结束自旋
		}
	}
}