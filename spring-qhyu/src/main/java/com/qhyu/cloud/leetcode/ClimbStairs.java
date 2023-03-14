package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：ClimbStairs <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月14日 9:55 <br>
 * @version v1.0 <br>
 */
public class ClimbStairs {
	//https://leetcode.cn/problems/climbing-stairs/?favorite=2cktkvj
	//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
	//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
	public static int climbStairs(int n) {

		return process(n);
	}

	public static int process(int n) {
		// 定义basecase
		if (n == 1) {
			// 楼梯只有一层，就只有一种方法
			return 1;
		}
		if (n == 2) {
			// 楼梯只有一层，就只有一种方法
			return 2;
		}
		// 当n=3时 我可以111 可以12 可以21 也就是三种，
		return process(n - 1) + process(n - 2);
	}

	// 上面的方法有个问题，递归耗时太长了，并且有重复调用的过程，可以分析出来
	//  n=5
	// }4 3
	//}3 2 2 1
	// 然后我们使用傻缓存法来以空间换时间
	// 我们建立一个一维数组，用来存放算过的值
	public static int process2(int n) {
		int[] result = new int[n + 1];
		for (int i = 1; i < n + 1; i++) {
			if (i == 1) {
				result[i] = 1;
			} else if (i == 2) {
				result[i] = 2;
			} else {
				result[i] = result[i - 1] + result[i - 2];
			}
		}
		return result[n];
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(3));
	}
}
