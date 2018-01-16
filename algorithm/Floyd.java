package algorithm;

import java.util.Arrays;

public class Floyd {

	/**
	 * Floyd算法，动态规划的一种，用来计算全局拓扑的最短路径
	 * @param args
	 */
	private static final int INF = 1000;
	private static int[][] D = { { 0, 6, 1, 5, INF, INF }, { 6, 0, 5, INF, 3, INF }, { 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 }, { INF, 3, 6, INF, 0, 6 }, { INF, INF, 4, 2, 6, 0 }};
	public static void main(String[] args) {
		//输出原始邻接矩阵
		outPut(D);
		for(int k = 0;k<D.length;k++) {
			for (int i = 0; i < D.length; i++) {
				for (int j = 0; j < D.length; j++) {
					if(D[i][k] + D[k][j] < D[i][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}
		System.out.println();
		//输入计算后的全局最短路径矩阵
		outPut(D);
	}
	private static void outPut(int[][] D) {
		for (int[] is : D) {
			System.out.println(Arrays.toString(is));
		}
	}
}
