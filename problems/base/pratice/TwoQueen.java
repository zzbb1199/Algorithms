package problems.base.pratice;
/**
 * 　　给定一个n*n的棋盘，棋盘中有一些位置不能放皇后。现在要向棋盘中放入n个黑皇后和n个白皇后，使任意的两个黑皇后都不在同一行、同一列或同一条对角线上，任意的两个白皇后都不在同一行、同一列或同一条对角线上。问总共有多少种放法？n小于等于8。
输入格式
　　输入的第一行为一个整数n，表示棋盘的大小。
　　接下来n行，每行n个0或1的整数，如果一个整数为1，表示对应的位置可以放皇后，如果一个整数为0，表示对应的位置不可以放皇后。
输出格式
　　输出一个整数，表示总共有多少种放法。
样例输入
4
1 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
样例输出
2
 * @author zxr
 *
 */

import java.util.Scanner;

public class TwoQueen {
	static int n;
	/**
	 * 棋盘
	 * 规定:
	 * 0 代表无法占用
	 * 1 代表可以占用
	 * 2 代表黑棋占用
	 * 3 代表白棋占用	
	 */
	static int[][] A;	
	static int count;	//记录
	public static void main(String[] args) {
		//输入
		Scanner input = new Scanner(System.in);
		n  = input.nextInt();
		A = new int[n][n];
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				A[i][j] = input.nextInt();
			}
		}
		input.close();
		back(0,2);
		System.out.println(count);
	}
	/**
	 * 规定棋子按照列进行防止
	 * @param i	 第i列防止规则
	 * @param type	2代表黑棋，3代表白棋
	 */
	public static void back(int i,int type) {
		if(i == n) {
			if(type == 2) {
				//还要放置白棋
				back(0,3);
				return;
			}else {
				//两个棋子都已经放置完成，统计
				count++;
				return;
			}
		}
		for(int row = 0;row<n;row++) {
			if(A[row][i] == 1 && check(row,i,type)) {//可放置
				A[row][i] = type;
				back(i+1,type);
				A[row][i] = 1;
			}
		}
	}
	
	public static boolean check(int row,int col,int type) {
		//step 1 行检查
		int[] hang = A[row];
		for(int value : hang) {
			if(value == type) {
				return false;
			}
		}
		//step2 主对角线检查
		int goal = col - row;
		for(int j = 0;j<col;j++) {
			for(int i = 0;i<n-1;i++) {//最后一行不用检查，所用只有n-1
				if(A[i][j] == type && j - i == goal) {
					return false;
				}
			}
		}
		//step3 副对角线检查
		goal = col+row;
		for(int j = 0;j<col;j++) {
			for(int i = 1;i<n;i++) {
				if(A[i][j] == type && i+j == goal) {
					return false;
				}
			}
		}
		return true;
	}
}
