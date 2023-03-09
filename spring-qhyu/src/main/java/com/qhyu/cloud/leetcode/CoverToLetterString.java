package com.qhyu.cloud.leetcode;


/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：CoverToLetterString <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月09日 14:41 <br>
 * @version v1.0 <br>
 */
public class CoverToLetterString {
	// 1对应A 2对应B 3对应C ，有字符串111 则可以转换为AAA AK KA三种 求有集中返回随意输入一个字符串

	public static Integer way1(String str) {
		return process(str.toCharArray(), 0);
	}

	private static Integer process(char[] chars, int index) {
		// basecase
		int str_length = chars.length;
		if (index == str_length) {
			return 1;
		}
		if (chars[index] == '0') {
			return 0;
		}
		// 我有两种方法，p1和p2
		int p1 = process(chars, index + 1);
		if (index + 1 < str_length && (chars[index]-'0') * 10 + (chars[index+1]-'0') <= 26) {
			p1 += process(chars, index + 2);
		}
		return p1;
	}

	public static Integer way2(String str) {
		return process2(str.toCharArray(), 0);
	}

	private static Integer process2(char[] chars, int index) {
		// 傻缓存方法
		int N = chars.length;
		int[] dp = new int[N+1];
		dp[N]=1;
		for (int i =N-1; i >=0 ; i--) {
			if (chars[i]=='0'){
				continue;
			}
			int p1 = dp[i+1];
			if (i+1<N && (chars[i]-'0') * 10 + (chars[i+1]-'0') <= 26){
				p1 += dp[i+2];
			}
			dp[i]=p1;
		}
		return  dp[index];
	}

	public static void main(String[] args) {
		System.out.println(way1("11111"));
		System.out.println(way2("11111"));
	}

}
