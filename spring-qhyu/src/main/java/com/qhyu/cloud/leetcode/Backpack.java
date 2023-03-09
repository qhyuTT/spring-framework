package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：Backpack <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月09日 9:53 <br>
 * @version v1.0 <br>
 */
public class Backpack {
	// 背包问题
	// 递归-傻缓存-动态规划的过程
	// 尝试函数
	// 定义basecase
	// 有数组weight【3，4，5，5，7】表示物体的重量
	// 有数组value[2，5，9，7，10]表示对应的价值，与weight对应，并且长度相同
	// capcity 10，包的容量为10

	public static Integer way1(int[] weight, int[] value, int capcity) {
		// 首先主函数调用的方法，需要传入什么参数
		// 递归函数
		return process1(weight, value, capcity, 0);
	}

	private static Integer process1(int[] weight, int[] value, int capcity, int ponit) {
		// basecase,如果容量小于0
		if (capcity < 0) {
			return -1;
		}
		if (ponit == weight.length) {
			return 0;
		}
		// 我有两种选择，选择要或者不要,p1要 p2 不要
		// 就是这里是核心内容，为什么这么写递归
		int p1 = 0;
		int next = process1(weight, value, capcity - weight[ponit], ponit + 1);
		if (next == -1) {
			return 0;
		} else {
			p1 = value[ponit] + next;
		}
		int p2 = process1(weight, value, capcity, ponit + 1);
		// 我选择p1 和p2 价值高得
		return Math.max(p1, p2);
	}

	// 写出递归算法之后，需要用傻缓存得方法来进行第一次优化
	// 先看暴力递归有没有重复调用
	// 递归函数得可变参数为captity和point，尝试使用这两个参数来进行建表缓存

	public static Integer way2(int[] weight, int[] value, int capcity) {
		return process2(weight, value, capcity, 0);
	}

	private static Integer process2(int[] weight, int[] value, int capcity, int i) {
		if (weight == null || value==null || weight.length ==0){
			return 0;
		}
		int N = weight.length;
		int[][] dp = new int[N + 1][capcity + 1];
		for (int index = N-1; index >= 0; index--) {
			for (int rest = 0; rest <= capcity; rest++) {

				int p1 = 0;
				int next = rest -weight[index] <0 ?-1:dp[index+1][rest-weight[index]];
				if (next !=-1){
					p1 = value[index]+next;
				}
				int p2 = dp[index+1][rest];
				dp[index][rest] = Math.max(p1,p2);
			}
		}
		return dp[0][capcity];

	}

	public static void main(String[] args) {
		// 测试使用
		int[] weight = new int[]{3, 4, 5, 5, 7};
		int[] value = new int[]{2, 5, 9, 7, 10};
		System.out.println(way1(weight, value, 10));
		System.out.println(way2(weight, value, 10));
	}
}
