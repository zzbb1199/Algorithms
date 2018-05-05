package 测试;

import java.util.Arrays;
import java.util.Scanner;

public class Floyd {
	/**
	 * Floyd算法
	 * 
	 * @param args
	 */
	private static final int INF = 1000;
	private static int[][] D = { { 0, 6, 1, 5, INF, INF },
			{ 6, 0, 5, INF, 3, INF }, { 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 }, { INF, 3, 6, INF, 0, 6 },
			{ INF, INF, 4, 2, 6, 0 } };

	public static void main(String[] args) {
		// 三层循环直接套用
		Scanner input = new Scanner(System.in);
		int N = D.length;
		for (int k = 0; k < N; k++) {
			for (int row = 0; row < N; row++) {
				for (int col = 0; col < N; col++) {
					if (D[row][k] + D[k][col] < D[row][col]) {
						D[row][col] = D[row][k] + D[k][col];
					}
				}
			}
		}
		// 输出
		for (int row = 0; row < N; row++) {
			System.out.println(Arrays.toString(D[row]));
		}
	}
}
