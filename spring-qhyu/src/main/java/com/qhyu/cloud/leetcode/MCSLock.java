package com.qhyu.cloud.leetcode;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MCSLock <br>
 * Package：com.qhyu.cloud.leetcode <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 06月06日 16:33 <br>
 * @version v1.0 <br>
 */
public class MCSLock {
	public static class MCSNode {
		volatile MCSNode next;
		volatile boolean isBlock = true; // 默认是在等待锁
	}

	volatile MCSNode queue;// 指向最后一个申请锁的MCSNode
	private static final AtomicReferenceFieldUpdater<MCSLock, MCSNode> UPDATER = AtomicReferenceFieldUpdater
			.newUpdater(MCSLock.class, MCSNode.class, "queue");

	@SuppressWarnings("cast")
	public void lock(MCSNode currentThread) {
		// 这里拿的应该是最后一个申请锁的MCSNode
		// 返回newValue，这里应该就是替换queue的值
		MCSNode predecessor = (MCSNode) UPDATER.getAndSet(this, currentThread);// step 1
		if (predecessor != null) {
			predecessor.next = currentThread;// step 2
			while (currentThread.isBlock) {// step 3
			}
		}else { // 只有一个线程在使用锁，没有前驱来通知它，所以得自己标记自己为非阻塞
			// 这里也能算是初始化第一个节点
			currentThread. isBlock = false;
		}
	}

	public void unlock(MCSNode currentThread) {
		if (currentThread.isBlock) {// 锁拥有者进行释放锁才有意义
			return;
		}

		if (currentThread.next == null) {// 检查是否有人排在自己后面
			if (UPDATER.compareAndSet(this, currentThread, null)) {// step 4
				// compareAndSet返回true表示确实没有人排在自己后面
				return;
			} else {
				// 突然有人排在自己后面了，可能还不知道是谁，下面是等待后续者
				// 这里之所以要忙等是因为：step 1执行完后，step 2可能还没执行完
				while (currentThread.next == null) { // step 5
				}
			}
		}
		currentThread.next.isBlock = false;
		currentThread.next = null;// for GC
	}
}