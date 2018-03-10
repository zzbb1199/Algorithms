package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kursal {
	/**
	 * Kursal 最小生成树 使用并查集
	 */
	/**
	 * 0 6 1 5 INF INF 6 0 5 INF 3 INF 1 5 0 5 6 4 5 INF 5 0 INF 2 INF 3 6 INF 0 6 INF INF 4 2
	 * 6 0
	 */
	private static final int INF = 1000;
	private static int[][] D = { { 0, 6, 1, 5, INF, INF }, { 6, 0, 5, INF, 3, INF }, { 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 }, { INF, 3, 6, INF, 0, 6 }, { INF, INF, 4, 2, 6, 0 }};
	private static int[] P;

	public static void main(String[] args) {
		int num = D.length;
		//初始化并查集--最开始各自为一个集合
		P = new int[num];
		for(int i = 0;i<P.length;i++) {
			P[i] = i;
		}
		//以下为Kursal算法
		//step1 根据邻接矩阵转为List
		List<Edge> edges = new ArrayList<Edge>();
		for(int i = 0;i<num;i++) {
			for(int j = i+1;j<num;j++) {
				if(D[i][j] != 0) {
					edges.add(new Edge(i,j,D[i][j]));
				}
			}
		}
		Collections.sort(edges);
		//stp2 根据Kursal算法生成最小生成树
		List<Edge> tree = new ArrayList<Edge>();
		int i = 0;
		int sum = 0;
		while(tree.size() != num -1 ) {
		 Edge currentEdge = edges.get(i);
		 if(!isSame(currentEdge.start,currentEdge.end)) {
			 merge(currentEdge.start,currentEdge.end);
			 tree.add(currentEdge);
			 sum += currentEdge.weight;
		 }
		 i++;
		}
		//输出
		System.out.println("加入顺序:");
		for (Edge edge : tree) {
			System.out.println(edge);
		}
		System.out.println(sum);
	}
	private static class Edge implements Comparable<Edge>{ 
		int start;
		int end;
		int weight;
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
	}

	/**
	 * 以下为并查集 -- 使用数组实现 数组索引代表该点，数组索引所对应的值代表该点的父节点 并查集功能： 1.查找本集合父节点--find 2.融合两个集合
	 * -- merge 3.判断是否为同一集合 -- isSame
	 */
	private static int find(int x) {
		int r = x;
		while (r != P[r]) {
			r = P[r];
		}
		// 路径压缩,避免多次迭代查找本集合的根节点
		int i = x;
		int j;
		while (i != r) {
			j = P[i];
			P[i] = r;
			i = j;
		}
		return r;
	}

	private static void merge(int x, int y) {
		int x_root = find(x);
		int y_root = find(y);

		// 如果不是一个集合，则融合
		P[y_root] = x_root;
	}

	private static boolean isSame(int x, int y) {
		if (find(x) != find(y)) {
			return false;
		}
		return true;
	}
}
