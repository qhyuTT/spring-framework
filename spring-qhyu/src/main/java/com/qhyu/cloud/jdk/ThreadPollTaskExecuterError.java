package com.qhyu.cloud.jdk;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.locks.LockSupport;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ThreadPollTastExecuterError <br>
 * Package：com.qhyu.cloud.jdk <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 04月29日 11:38 <br>
 * @version v1.0 <br>
 */
@SuppressWarnings({"rawtypes","deprecation"})
public class ThreadPollTaskExecuterError {

	// 问题：每次执行一组任务，一组任务最多有15个。多线程执行，每个现场处理一个任务，每次执行完一组任务以后，再执行下一组，不存在上一组的任务和下一组一起执行
	// 设计：核心线程池14个，阻塞队列为1，最大线程池30，理论上14个核心线程+1个阻塞队列即可完成一组任务，非核心线程都无需使用
	public static void threadTask() {
		List<Future> futureList = new ArrayList<>(15);
		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
		threadPoolTaskExecutor.setCorePoolSize(14);
		threadPoolTaskExecutor.setMaxPoolSize(30);
		threadPoolTaskExecutor.setQueueCapacity(1);
		threadPoolTaskExecutor.setThreadNamePrefix("qhyu-pool-");
		threadPoolTaskExecutor.initialize();
		for (int j = 0; j < 10; j++) {
			for (int i = 0; i < 15; ++i) {
				Future future = threadPoolTaskExecutor.submit(() -> {
					// 随机睡 0-5 秒
					int sec = new Double(Math.random() * 5).intValue();
					// 业务逻辑模拟
					LockSupport.parkNanos(sec * 1000 * 1000 * 1000);
					System.out.println(Thread.currentThread().getName() + "  end");
				});
				futureList.add(future);
			}
			// 等待所有任务执行结束
			for (Future future : futureList) {
				try {
					future.get();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		threadTask();
	}
}
