package problems;

import java.util.Arrays;

/**
 * 0-1背包问题，使用动态规划求解
 * 动态规划求解非递归法-浪费空间
 * 动态规划求解递归法-稍微节约空间，但采用了递归的方式，所以不要期望这样的方式会节约时间
 *
 */
public class KnapsackD {
	private static int[] w = {0,2, 2, 6, 5, 4};
	private static int[] v = {0,6, 3, 5, 4, 6};
	private static int c = 10;
	private static int N = w.length;
	/**
	 * S说明：S用于保存每步生成的最优解结果
	 * row:每行代表放置前row个物品
	 * col：每列代表当前还剩余的重量
	 * 例：row=1,col=1,表示放置前1个物品，当前空间还剩一个单位
	 */
	private static int[][] S = new int[N][c+1];
	private static int[] x = new int[N];
	public static void main(String[] args) {
		solveNR();
		x = new int[N];
		System.out.println("最大价值："+solveR(N-1,c));
		System.out.println("最优解:"+Arrays.toString(x));
	}	
	/**
	 * 方式一-非递归结构
	 * 自上而下
	 */
	private static void solveNR() {
		//从第1行开始填（注意是有第0行的），java的初始化已经把所有S的空间置为0了
		for(int i = 1;i<N;i++) {
			for(int j = 1;j<c+1;j++) {
				if(w[i]<j) {
					//能放置第i个物品
					S[i][j] = Math.max(S[i-1][j], S[i-1][j-w[i]]+v[i]);
				}else {
					//放不下
					S[i][j] = S[i-1][j];
				}
			}
		}
		//输出最优解
		System.out.println("最大价值为:"+S[N-1][c]);
		//现在回溯看哪些物品被加入
		int row = N-1;
		int col = c;
		while(row != 0) {
			if(S[row][col] != S[row-1][col]) {
				//和上一行不同，说明放置了第row个物品
				x[row] = 1;
				col -= w[row];
			}else {
				//和上一行相同，说明未放置第row个物品
				x[row] = 0;//其实这里也可也不写，java初始化默认为0
			}
			row -= 1;
		}
		//输出解
		System.out.println("最优解:"+Arrays.toString(x));
	}
	/**
	 * 方式二-递归结构
	 * 自下而上
	 */
	private static int solveR(int row,int col) {
		if(row == 0) {
			return 0;
		}
		if(col == 0) {
			return 0;
		}
		int value1 = solveR(row-1,col);
		if(col >= w[row]) {
			int value2 = solveR(row-1,col-w[row])+v[row];
			if(value1 > value2) {
				x[row] = 0;
				return value1;
			}else {
				x[row] = 1;
				return value2;
			}
		}else {
			return value1;
		}
	}
	
}
