package algorithm;

import java.util.Arrays;

public class WarShall {
	/**
	 * WarSWhall算法，动态规划算法的一种，传递闭包
	 * 简单说来，即是判定一个网络图中任意两点之间是否通过经过中间点（当然也可不通过）而连同
	 */
	
	//0代表两点不连通，1代表两点之间连通
	private static int[][] D ={
			{0,1,0,1,0,0},
			{1,0,1,0,0,0},
			{0,1,0,0,0,0},
			{1,0,0,0,1,0},
			{0,0,0,1,0,0},
			{0,0,0,0,0,0}
	};  
	public static void main(String[] args) {
		outPut(D);
		//用S表示连通结果
		//二维数组的深度拷贝，java提供的各个拷贝方法如clone，arrayCopy等，对基本数据类型是一进行拷贝，但是对于非基本数据的数组
		//都是拷贝的引用，即是一种浅拷贝，所以这里用循环来进行拷贝
		int[][] S = new int[D.length][D.length];
		for(int i = 0;i<D.length;i++) {
			S[i] = D[i].clone();
		}
		for(int k = 0;k<S.length;k++) {
			for(int i = 0;i<S.length;i++) {
				for(int j = 0;j<S.length;j++) {
					if(S[k][j] == 1 && S[i][k] == 1) {
						S[i][j] = 1;
					}
				}
			}
		}
		//输出
		//1.原邻接矩阵
		System.out.println("原邻接矩阵");
		outPut(D);
		//2.连通矩阵
		System.out.println("连通矩阵:");
		outPut(S);
	}
	private static void outPut(int[][] D) {
		for (int[] is : D) {
			System.out.println(Arrays.toString(is));
		}
	}
}
