package com.qhyu.cloud.leetcode;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：MaximalRectangle <br>
 * Package：com.qhyu.cloud.leetcode <br> 
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 * @author 于琦海 <br>
 * date 2023年 03月16日 9:35 <br>
 * @version v1.0 <br>
 */
public class MaximalRectangle {

	public static int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length ==0){
			return 0;
		}
		return process(matrix, 0, 0);
	}

	public static int process(char[][] matrix, int y, int x) {
		int N = matrix.length;
		int M = matrix[0].length;
		if (matrix[y][x] == '0'){
			return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		char[][] matrix = {{'1', '0', '1', '0', '0',}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
		System.out.println(maximalRectangle(matrix));
	}
}
