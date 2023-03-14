package com.qhyu.cloud.leetcode;

public class MinPathSum {
	public static int minPathSum(int[][] grid) {
		return process(grid, 0, 0);
	}

	public static int process(int[][] grid, int down, int right) {
		// 从0，0开始到N-1，N-1结束
		int N = grid.length;
		if (down > N || right > N) {
			return 0;
		}else if (down == right && down == N - 1 && right == N - 1) {
			return grid[down][right];
		}

		int p1 = grid[down][right] + process(grid, down + 1, right);
		int p2 = grid[down][right] + process(grid, down, right + 1);
		return Math.min(p1, p2);
	}

	public static void main(String[] args) {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(minPathSum(grid));
	}
}
