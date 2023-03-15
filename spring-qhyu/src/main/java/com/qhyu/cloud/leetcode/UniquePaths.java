package com.qhyu.cloud.leetcode;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：UniquePaths <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月15日 10:47 <br>
 * @version v1.0 <br>
 */
public class UniquePaths {

	// https://leetcode.cn/problems/unique-paths/?favorite=2cktkvj
	// 直接开始动态规划
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = m-1; i >=0 ; i--) {
			for (int j = n-1; j >=0 ; j--) {
				if (i== m-1 || j==n-1){
					dp[i][j] = 1;
				}else{
					dp[i][j] = dp[i+1][j]+dp[i][j+1];
				}
			}
		}
		return dp[0][0];
	}

	// 使用滚动数据和递推的方式进行优化
	public static int process(int m, int n) {
		int[] dp = new int[n];
		for (int i = m-1; i >=0 ; i--) {
			for (int j = n-1; j >=0 ; j--) {
				if (i== m-1 || j==n-1){
					dp[j] = 1;
				}else{
					dp[j] = dp[j]+dp[j+1];
				}
			}
		}
		return dp[0];
	}
	public static void main(String[] args) {
		System.out.println(process(3,7));
	}

}
