package com.qhyu.cloud.leetcode;

public class MinPathSum {
	public static int minPathSum(int[][] grid) {
		return process2(grid, 0, 0);
	}

	public static int process(int[][] grid, int down, int right) {
		// 从0，0开始到N-1，N-1结束
		int X = grid[0].length;
		int Y = grid.length;
		if (down > Y || right > X) {
			return 0;
		}
		if (down == Y - 1 && right == X - 1) {
			return grid[down][right];
		}
		if (right == X - 1) {
			return grid[down][right] + process(grid, down + 1, right);
		}
		if (down == Y - 1) {
			return grid[down][right] + process(grid, down, right + 1);
		}
		int p1 = grid[down][right] + process(grid, down + 1, right);
		int p2 = grid[down][right] + process(grid, down, right + 1);
		return Math.min(p1, p2);
	}


	public static int process2(int[][] grid, int down, int right) {
		// 从0，0开始到N-1，N-1结束
		int X = grid[0].length;
		int Y = grid.length;
		// 建立dp表，找到填充规律
		int[][] dp = new int[Y][X];
		dp[Y - 1][X - 1] = grid[Y - 1][X - 1];
		// 填充最下面的一条 和最右边的一条，因为右边只能往下走，最下面只能往右走
		for (int i = X - 2; i >= 0; i--) {
			dp[Y - 1][i] = grid[Y - 1][i] + dp[Y - 1][i + 1];
		}
		for (int i = Y - 2; i >= 0; i--) {
			dp[i][X - 1] = grid[i][X - 1] + dp[i + 1][X - 1];
		}
		// 从dp[Y-2][X-2]开始遍历，从Y-2开始向上 然后到顶之后向左循环填充
		for (int y = Y-2; y >=0 ; y--) {
			for (int x = X-2; x >=0 ; x--) {
				dp[y][x] = grid[y][x]+Math.min(dp[y][x+1],dp[y+1][x]);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		int[][] grid1 = {{1, 2, 3}, {4, 5, 6}};
		System.out.println(minPathSum(grid));
		System.out.println(minPathSum(grid1));
	}
}
