package com.qhyu.cloud.jdk;

import java.util.concurrent.*;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ThreadPollConsider <br>
 * Package：com.qhyu.cloud.jdk <br> 
 * Copyright © 2022 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2022年 11月11日 10:53 <br>
 * @version v1.0 <br>
 */
public class ThreadPollConsider {
	/** 线程池源码分析 */
	public static void main(String[] args) {

		// 建议使用executors工具类来创建线程池
		//ExecutorService executorService = Executors.newFixedThreadPool(1);
		int corePoolSize =5;
		int maximumPoolSize =10;
		long keepAliveTime =20;
		// 默认的拒绝策略AbortPolicy
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
		threadPoolExecutor.execute(()->{

		});
	}
}
