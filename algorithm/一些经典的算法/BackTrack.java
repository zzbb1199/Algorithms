package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BackTrack {

	/**
	 * 回溯法-这里以N皇后问题为例
	 */
	private static int N;
	//放置结果
	private static int[][] P;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("输入N值:");
		N = input.nextInt();
		input.close();
		P = new int[N][N]; 
		//进行求解
		back(0);
	}
	/**
	 * 回溯
	 * 在本算法中，所有棋子按照列进行放置
	 * col 列
	 */
	private static int sum = 0;//保存共有多少组解
	private static void back(int col) {
		if(col == N) {
			sum+=1;
			System.out.println("第"+sum+"组解:");
			//已经找到一个解，进行输出
			outPut(P);
			return;
		}
		for(int i = 0;i<P.length;i++) {
			if(check(i,col)) {
				P[i][col] = 1;
				back(col+1);
				//下一列已经访问完成，返回到本列，进行清空
				P[i][col] = 0;
			}
		}

	}
	/**
	 * 检查该位置是否能放置
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean check(int row,int col) {
		//step1 检查行
		for(int each : P[row]) {
			if(each == 1) {
				return false;
			}
		}
		//step2 检查主对角线
		int s = row - col;
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P.length; j++) {
				if(P[i][j] == 1&&i-j == s) {
					return false;
				}
			}
		}
		//step3 检查副对角线
		s = row+col;
		for (int i = 0; i < P.length; i++) {
			for (int j = 0; j < P.length; j++) {
				if(P[i][j] == 1 && i+j == s) {
					return false;
				}
			}
		}
		return true;
	}
	private static void outPut(int[][] D) {
		for (int[] is : D) {
			System.out.println(Arrays.toString(is));
		}
	}

}
