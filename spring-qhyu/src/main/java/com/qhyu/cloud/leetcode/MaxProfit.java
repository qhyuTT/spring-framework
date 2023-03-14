package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MaxProfit <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月14日 10:36 <br>
 * @version v1.0 <br>
 */
public class MaxProfit {
	// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?favorite=2cktkvj
	// [7,1,5,3,6,4] 第二天买入 第五天卖 赚钱6-1=5，买卖股票的最佳时机
	public int maxProfit(int[] prices) {
		return process(prices, 0, prices.length - 1);
	}

	public static int process(int[] prices, int left, int right) {
		if (left == right || left > right) {
			return 0;
		}
		int i = prices[right] - prices[left];
		int p1 = process(prices, left + 1, right);
		int p2 = process(prices, left, right - 1);
		return Math.max(Math.max(i, p1), p2);
		// 三种情况
	}


	public static int process2(int[] prices) {
		int N = prices.length;
		int[][] dp = new int[N][N];
		// 默认就都是0
		for (int R = 1; R <N ; R++) {
			for (int L = R-1; L>=0; L--) {
				int x = prices[R] - prices[L];
				dp[L][R] = Math.max(x, Math.max(dp[L][R-1], dp[L+1][R]));
			}
		}
		return dp[0][N - 1];
	}
	public static int process3(int[] prices) {
		int n = prices.length;
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			if (prices[i] < minPrice) {
				minPrice = prices[i];
			} else if (prices[i] - minPrice > maxProfit) {
				maxProfit = prices[i] - minPrice;
			}
		}
		return maxProfit;
	}

	public static void main(String[] args) {
		int[] prices = new int[]{7, 1, 5, 3, 6, 4};
		System.out.println(process2(prices));
	}
}
