package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {
	/**
	 * Dijkstra算法，利用了贪婪算法思想，是一种单源最短路径算法
	 * 注意D算法所得到的结果是一棵树
	 */
	private static final int INF = 1000;
	private static int[][] D = { 
			{ 0, 6, 1, 5, INF, INF },
			{ 6, 0, 5, INF, 3, INF },
			{ 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 }, 
			{ INF, 3, 6, INF, 0, 6 }, 
			{ INF, INF, 4, 2, 6, 0 }
			};
	public static void main(String[] args) {
		System.out.println("输入起点：");
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		//cost用于保存该节点到其他点的最短路径
		int[] cost = new int[D.length];
		for (int i = 0; i < cost.length; i++) {
			cost[i] = D[start][i];
		}
		//以下为D算法
		boolean[] visted = new boolean[D.length];
		visted[start] = true;
		int current = start;
		//tree，保存路径
		int[] tree = new int[cost.length];
		for(int i = 0;i<tree.length;i++) {
			tree[i] = start;
		}
		while(!hasAllVisted(visted)) {
			for(int i = 0;i<D.length;i++) {
				if(visted[i]) {
					continue;
				}
				if(cost[i] > cost[current] + D[current][i]) {
					cost[i] =  cost[current] + D[current][i];
					tree[i] = current;
				}
			}
			//选择本轮中最小权值的点
			current = chooseMinIndex(cost, visted);
			visted[current] = true;
		}
		//输出
		System.out.println("到各点距离为:");
		System.out.println(Arrays.toString(cost));
		//到达终点所经路径
		System.out.println("输入终点:");
		int backPoint = input.nextInt();
		input.close();
		String path ="" + backPoint;
		while(backPoint != start) {
			backPoint = tree[backPoint];
			path += ","+ backPoint;
		}
		//反转路径
		char[] pathChars = path.toCharArray();
		int length = pathChars.length;
		for (int i = 0; i <=length/2; i++) {
			char temp = pathChars[i];
			pathChars[i] = pathChars[length-1-i];
			pathChars[length-1-i] = temp;
		}
		//输出
		System.out.println("经过点有:");
		for (char c : pathChars) {
			System.out.print(c);
		}
	}
	private static int chooseMinIndex(int[] cost,boolean[] visted) {
		int min = INF;
		int minIndex = -1;
		for(int i = 0;i<cost.length;i++) {
			if(!visted[i] && min > cost[i]) {//注意不能选择visted的点
				min = cost[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	private static boolean hasAllVisted(boolean[] visted) {
		for (boolean b : visted) {
			if(!b) {
				return false;
			}
		}
		return true;
	}
	

}
