package algorithm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 问题描述
　　一组人要担任在一个特定城市举办的比赛的评委，他们需要找到最便宜的租车方式使得每个人都到达目标城市。他们观察发现，如果几个人在旅途的某一段坐同一辆租的车，就可以减少总费用。你的任务就是找出这些人应该采取的路线使得租车的总费用最小。
　　我们假定：
　　1. 租一辆车的费用与它行驶的距离成正比，没有燃油、保险、乘客人数多于一个等产生的额外费用。
　　2. 所有车的费用与行驶距离的比例相同。
　　3. 一辆车可以容纳任意数量的乘客。
　　4. 任意一对城市之间最多只有一条道路直接相连，每条道路都是双向的且长度大于0。
　　5. 每个人的起始城市到目标城市都至少有一种路线。
　　6. 若多个人的路线中经过同一城市，则这些人从该城市到目标城市必乘同一辆车。
　　7. 一个人可以乘一辆车到某个城市，再乘另一辆车离开该城市。
输入格式
　　第一行包含三个整数nc, dc和nr，表示地图上的城市个数，目标城市的编号和地图上的道路条数。
　　接下来nr行每行包含三个整数c1, c2和dist，表示一条长度为dist的双向道路(c1, c2)。
　　接下来一行包含一个整数nj，表示人数。
　　接下来一行包含nj个整数，表示每个人的起始城市。
输出格式
　　第一行包含“distance = ”和一个整数，表示所租的车行驶的最小总距离。
　　接下来nj行每行包含一个人的访问路线，城市按访问顺序给出并用“-”连接。
　　存在多种方案时，选择需要访问到的城市集合元素最少的一种；仍然存在多种方案时，选择集合元素升序排列后字典序最小的一种。
样例输入
5 3 5
1 2 1
2 3 2
3 4 3
4 5 1
2 4 2
2
5 1
样例输出
distance = 6
5-4-2-3
1-2-3
 * @author zxr
 *
 */
public class TheTravelingJudgesProblem {
	static final int INF = 200;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int nc = input.nextInt();
		int dc = input.nextInt()-1;
		int nr = input.nextInt();
		//初始化邻接矩阵
		int[][] D = new int[nc][nc];
		for(int i = 0;i<nc;i++) {
			for(int j = 0;j<nc;j++) {
				D[i][j] = INF;
			}
		}
		//输入各边
		for(int i = 0;i<nr;i++) {
			int m = input.nextInt()-1;
			int n = input.nextInt()-1;
			int value = input.nextInt();
			D[m][n] = value;
			D[n][m] = value;
		}
		//采用Prim算法生成最小生成树
		List<Edge> edges = new ArrayList<>();
		Prim(edges,nc,D);
		//重新生成矩阵
		D = new int[nc][nc];
		for(int i = 0;i<nc;i++) {
			for(int j = 0;j<nc;j++) {
				D[i][j] = INF;
			}
		}
		for (Edge edge : edges) {
			D[edge.start][edge.end] = edge.vlaue;
			D[edge.end][edge.start] = edge.vlaue;
		}
		//输入人的位置
		int num = input.nextInt();
		int[] loc = new int[num];
		for(int i = 0;i<loc.length;i++) {
			loc[i] = input.nextInt()-1;
		}
		//每个人的单独路径
		StringBuilder[] paths = new StringBuilder[num];
		for(int i = 0;i<num;i++) {
			int start = loc[i];
			paths[i] = getPath(start,dc,nc,D);
		}
		//找到最大公共子串
		
	}
	//采用D算法思路获取路径
	public static StringBuilder getPath(int start,int end,int nc,int[][] D) {
		int[] tree = new int[nc];
		int[] cost = new int[nc];
		tree[start] = start;
		for(int i = 0;i<nc;i++) {
			cost[i] = INF;
		}
		cost[start] = 0;
		boolean[] visted = new boolean[nc];
		visted[start] = true;
		int current = start;
		while(!check(visted)) {
			for(int i = 0;i<nc;i++) {
				if(!visted[i]) {
					if(D[start][i] >= cost[current]+D[current][i]) {
						cost[i] = cost[current]+D[current][i];
						tree[i] = current;
					}
				}
			}
			//选择本次最小
			current = findMinIndex(visted,cost);
			visted[current] = true;
		}
		//生成路径
		StringBuilder path = new StringBuilder();
		int temp = end;
		while(temp != start) {
			path.append(temp);
			temp = tree[temp];
		}
		path.append(start);
		path.reverse();
		return path;
	}
	public static int findMinIndex(boolean[] v,int[] cost) {
		int min = INF;
		int minIndex =-1;
		for(int i = 0;i<cost.length;i++) {
			if(!v[i] && cost[i] < min) {
				min = cost[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	public static boolean check(boolean[] visted) {
		for (boolean b : visted) {
			if(!b) {
				return false;
			}
		}
		return true;
	}
	public static void Prim(List<Edge> edges,int nc,int[][] D) {
		boolean[] visted = new boolean[nc];
		int pre = 0;
		int current = 0;	//从第0个点开始遍历
		int minValue ;
		visted[current] = true;
		while(edges.size() != nc-1) {
			minValue = INF;
			for(int i = 0;i<nc;i++) {
				if(!visted[i]) {
					for(int j = 0;j<nc;j++) {
						if(visted[j]) {
							if(D[i][j] < minValue) {
								pre = j;
								current = i;
								minValue = D[i][j];
							}
						}
					}
				}
			}
			//完成一个点的确定
			visted[current] = true;
			edges.add(new Edge(pre, current, D[pre][current]));
			pre = current;
		}
	}
	
	static class Edge{
		int start;
		int end;
		int vlaue;
		public Edge(int start, int end, int vlaue) {
			super();
			this.start = start;
			this.end = end;
			this.vlaue = vlaue;
		}
		
	}
}
