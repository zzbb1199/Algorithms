package problems;

import java.util.Scanner;

/*
 *问题描述
　　给定一个N阶矩阵A，输出A的M次幂（M是非负整数）
　　例如：
　　A =
　　1 2
　　3 4
　　A的2次幂
　　7 10
　　15 22
输入格式
　　第一行是一个正整数N、M（1<=N<=30, 0<=M<=5），表示矩阵A的阶数和要求的幂数
　　接下来N行，每行N个绝对值不超过10的非负整数，描述矩阵A的值
输出格式
　　输出共N行，每行N个整数，表示A的M次幂所对应的矩阵。相邻的数之间用一个空格隔开 
 */
public class MatrixMultiplication {
	static 	int N;
	static int M;
	static int[][] A ;
	static int[][] pre_A;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		M = input.nextInt(); 
		A = new int[N][N];
		pre_A = new int[N][N];
		int[][] base = new int[N][N];
		for(int i = 0;i<N;i++) {
			for(int j=0;j<N;j++) {
				base[i][j] = input.nextInt();
			}
		}
		input.close();
		if(M == 0) {
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					if(j == N-1) {
						if(i == j) {
							System.out.println(1);
						}else {
							System.out.println(0);
						}	
					}else if(i == j) {
						System.out.print(1+" ");
					}else {
						System.out.print(0+" ");
					}
				}
			}
			return;
		}
		//中间变量克隆
		for(int i = 0;i<N;i++) {
			A[i] = base[i].clone();
		}
		clone(A,pre_A);
		//开始计算
		int sum;
		for(int m = 1;m<M;m++) {
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<N;j++) {
					//取出pre_A的第i行和base的第j列
					int[] temp_row =  pre_A[i];
					int[] temp_col =  getcol(base,j);
					sum = 0;
					//计算相乘
					for(int k = 0;k<N;k++) {
						sum+=temp_row[k]*temp_col[k];
					}
					A[i][j] = sum;
				}
			}
			//计算完一次
			clone(A,pre_A);
		}
		//输出
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(j!= N-1) {
					System.out.print(A[i][j]+" ");
				}else {
					System.out.println(A[i][j]);
				}
				
			}
		}
	}
	private static int[] getcol(int[][] A,int col) {
		int[] result = new int[A.length];
		for(int i = 0;i<A.length;i++) {
			result[i] = A[i][col];
		}
		return result;
	}
	private static void clone(int[][] A,int[][] pre_A) {
		for(int i = 0;i<A.length;i++) {
			pre_A[i] = A[i].clone();
		}
	}

}
