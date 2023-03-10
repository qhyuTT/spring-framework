package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：LongestPalindrome <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月09日 16:19 <br>
 * @version v1.0 <br>
 */
public class LongestPalindrome {

	public static Integer way1(String str, int index) {
		char[] chars = str.toCharArray();
		return process(str.toCharArray(), index, chars.length - 1);

	}

	private static Integer process(char[] chars, int left, int right) {
		if (chars.length <= 1 || left < 0 || right > Integer.MAX_VALUE) {
			return Integer.MIN_VALUE;
		}
		// 第一件事情，找边界，怎么结束
		if (left == right) {
			// 分为三种情况，left=0 right=chars.length -1 中间
			if (left == 0) {
				return Integer.MIN_VALUE;
			} else if (right == chars.length - 1) {
				return Integer.MIN_VALUE;
			} else {
				return 1;
			}
		} else if (left > right) {
			// 如果left大于right，也就是说曾经移动过
			if (chars[left] == chars[right]) {
				// 因为已经算过一次了，这里就不用return1了。
				return 0;
			}
			return Integer.MIN_VALUE;
		} else {
			// 要么left+1 要么right-1 要么left+1和right-1三种情况
			int p1 = process(chars, left + 1, right);
			int p2 = process(chars, left, right - 1);
			int p3 = chars[left] == chars[right] ? process(chars, left + 1, right - 1) + 2 : Integer.MIN_VALUE;
			return Math.max(p1, Math.max(p2, p3));
		}
	}


	private static Integer process3(char[] chars, int left, int right) {
		// 重新找边界值
		if (chars.length == 0) {
			return 0;
		}
		// 第一件事情，找边界，怎么结束
		if (left == right) {
			//
			// 分为三种情况，left=0 right=chars.length -1 中间
			return 1;
		} else if (left > right) {
			return 0;
		} else {
			StringBuffer str5 = new StringBuffer();
			for (char str : chars) {
				str5.append(str);
			}
			int p1 = 0;
			if (chars[left] == chars[right]) {
				String s1 = str5.substring(1, chars.length - 1);
				p1 = process3(s1.toCharArray(), 0, s1.length() - 1) + 2;
			}
			// 如果不相等，那么整理下这个chars，重新传
			String s2 = str5.substring(1, chars.length);
			int p2 = process3(s2.toCharArray(), 0, s2.length() - 1);

			String s3 = str5.substring(0, chars.length - 1);
			int p3 = process3(s3.toCharArray(), 0, s3.length() - 1);

			return Math.max(p1, Math.max(p2, p3));
		}
	}

	public static Integer way3(String str, int index) {
		char[] chars = str.toCharArray();
		return process3(str.toCharArray(), index, chars.length - 1);

	}


	public static Integer way4(String str, int index) {
		char[] chars = str.toCharArray();
		return process4(str.toCharArray(), 0,index, chars.length - 1);

	}

	// 我需要找到所有的basecase
	//
	private static Integer process4(char[] chars, int max, int left, int right) {
		StringBuffer str5 = new StringBuffer();
		for (char str : chars) {
			str5.append(str);
		}
		System.out.println(str5);
		if (chars.length == 0) {
			return max + 0;
		} else if (left == right) {
			return max + 1;
		} else if (left + 1 == right) {
			return max + 2;
		} else {
			int p1 = 0;
			String s1 = str5.substring(1, chars.length - 1);
			if (process4(s1.toCharArray(), max, 0, s1.length() - 1)>0){
				p1 = max+2;
			}else{
				return Integer.MIN_VALUE;
			}
			// 如果不相等，那么整理下这个chars，重新传
			String s2 = str5.substring(1, chars.length);
			int p2 = process4(s2.toCharArray(), 0, 0, s2.length() - 1);

			String s3 = str5.substring(0, chars.length - 1);
			int p3 = process4(s3.toCharArray(), 0, 0, s3.length() - 1);

			return Math.max(p1, Math.max(p2, p3));
		}
	}


	public static String way2(String str, int index) {
		char[] chars = str.toCharArray();
		return process2(str.toCharArray(), new StringBuilder(), index, chars.length - 1).toString();

	}

	public static void main(String[] args) {
		//System.out.println(way3("er12tewrteeeeeeeeeeenmhjyuk21yu", 0));
		System.out.println(way4("eweeeeweeeee", 0));
		//System.out.println(way2("babad", 0));
	}

	private static StringBuilder process2(char[] chars, StringBuilder result, int left, int right) {
		if (chars.length <= 1 || left < 0 || right > Integer.MAX_VALUE) {
			return new StringBuilder(result);
		}
		// 第一件事情，找边界，怎么结束
		if (left == right) {
			StringBuilder stringBuilder = new StringBuilder(result);
			StringBuilder reverse = stringBuilder.reverse();
			return stringBuilder.append(chars[left]).append(reverse);
		} else if (left > right) {
			// 如果left大于right，也就是说曾经移动过
			if (chars[left] == chars[right]) {
				// 因为已经算过一次了，这里就不用return1了。
				StringBuilder stringBuilder = new StringBuilder(result);
				return stringBuilder.append(stringBuilder.reverse());
			}
			return new StringBuilder(result);
		} else {
			StringBuilder sb1 = new StringBuilder(result);
			// 要么left+1 要么right-1 要么left+1和right-1三种情况
			StringBuilder p1 = process2(chars, sb1, left + 1, right);
			StringBuilder sb2 = new StringBuilder(result);
			StringBuilder p2 = process2(chars, sb2, left, right - 1);
			StringBuilder sb3 = new StringBuilder(result);
			StringBuilder p3 = chars[left] == chars[right] ? process2(chars, sb3.append(chars[left]), left + 1,
					right - 1) : new StringBuilder();
			if (p1.length() >= p2.length()) {
				if (p1.length() >= p3.length()) {
					return p1;
				} else {
					return p3;
				}
			} else {
				if (p2.length() >= p3.length()) {
					return p2;
				} else {
					return p3;
				}
			}
		}
	}


}
