package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：https://leetcode.cn/problems/longest-palindromic-subsequence/submissions/ <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月09日 16:19 <br>
 * @version v1.0 <br>
 */
public class LongestPalindrome {

	public static Integer longestPalindromeSubseq1(String str) {
		return process1(str.toCharArray(), 0, str.length() - 1);
	}

	private static Integer process1(char[] chars, int left, int right) {
		if (chars.length == 0) {
			return 0;
		}
		// 第一件事情，找边界，怎么结束
		if (left == right) {
			// 分为三种情况，left=0 right=chars.length -1 中间
			return 1;
		}
		if (left + 1 == right) {
			if (chars[left] == chars[right]) {
				return 2;
			}
			return 1;
		}
		// 要么left+1 要么right-1 要么left+1和right-1三种情况
		int p1 = process1(chars, left + 1, right);
		int p2 = process1(chars, left, right - 1);
		int p3 = chars[left] == chars[right] ? process1(chars, left + 1, right - 1) + 2 : Integer.MIN_VALUE;
		return Math.max(p1, Math.max(p2, p3));
	}


	/**
	 * 由递归改动态规划,建立空间感之后还可以继续优化
	 */
	public static Integer longestPalindromeSubseq2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int N = chars.length;
		int[][] dp = new int[N][N];
		// 建立了这个表之后 要怎么填充
		// 单独填写不需要判断
		dp[N - 1][N - 1] = 1;
		// 对角线都是1
		for (int i = 0; i < N - 1; i++) {
			dp[i][i] = 1;
			dp[i][i + 1] = chars[i] == chars[i + 1] ? 2 : 1;
		}
		for (int l = N - 3; l >= 0; l--) {
			for (int r = l + 2; r < N; r++) {
				/*int p1 = dp[l + 1][r];
				int p2 = dp[l][r - 1];
				int p3 = chars[l] == chars[r] ? dp[l + 1][r - 1] + 2 : 0;
				dp[l][r] = Math.max(p1, Math.max(p2, p3));*/
				dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
				if (chars[l] == chars[r]) {
					dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + 2);
				}
			}
		}
		return dp[0][N - 1];
	}

	/**
	 * 现在变化的参数有两个，一个left 一个right
	 * 动态规划啥缓存的话，需要定义一个dp，例如 int[][] dp = new int[][];
	 * left = 0~str.length()-1
	 * right = 0~str.length()-1
	 * https://leetcode.cn/problems/longest-palindromic-substring/?favorite=2cktkvj
	 */
	public String longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		return process4(s.toCharArray(), 0, chars.length - 1);
	}

	private static String process4(char[] chars, int left, int right) {
		//要返回最长子串，子串和子序列的区别，子串连续。
		// 定义basecase
		if (chars.length < 2){
			return chars.toString();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubseq1("a12b3c43def2ghi1kpm")); // 返回7
	}


}
