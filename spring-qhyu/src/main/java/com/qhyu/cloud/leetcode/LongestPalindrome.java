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

	public static String way1(String str, int index) {
		char[] chars = str.toCharArray();
		String text1 = "";
		String text2 = "";
		return process(str.toCharArray(), text1,text2,index, chars.length);
	}

	private static String process(char[] chars, String text1,String text2 ,int left, int right) {
		// 第一件事情，找边界，怎么结束
		if(left == right ){
			// 结束
			return text1+chars[left]+text2;
		}else if (left > right){
			return  text1+text2;
		}else{
			// 要么left+1 要么right-1 要么left+1和right-1三种情况
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
