package com.qhyu.cloud.leetcode.sort;

import java.util.Arrays;

/**
 * All rights Reserved, Designed By http://xnky.travelsky.net/ <br>
 * Title：InsertionSort <br>
 * Package：com.qhyu.cloud.leetcode.sort <br>
 * Copyright © 2023 xnky.travelsky.net Inc. All rights reserved. <br>
 * Company：Aviation Cares Of Southwest Chen Du LTD  <br>
 *
 * @author 于琦海 <br>
 * date 2023年 09月18日 10:36 <br>
 * @version v1.0 <br>
 */
public class InsertionSort {
	// 插入排序算法，类似打扑克牌
	public static void main(String[] args) {
		int[] arrays = {5, 2, 4, 6, 1, 3};
		insertionSort(arrays);
		binaryInsertionSort(arrays);
	}

	public static void insertionSort(int[] arrays) {
		for (int i = 1; i < arrays.length; i++) {
			// 为了保证空间复杂度不变，我需要利用arrays这个数组
			int temp = arrays[i];
			int j;
			for (j = i - 1; j >= 0 && temp < arrays[j]; j--) {
				arrays[j + 1] = arrays[j];
			}
			arrays[j + 1] = temp;
		}
		System.out.println(Arrays.toString(arrays));
	}

	public static void binaryInsertionSort(int[] arrays) {

	}
}
