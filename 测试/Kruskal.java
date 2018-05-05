package 测试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kruskal {
	public static final int INF = 1000;
	public static int[][] D = { 
			{ 0, 6, 1, 5, INF, INF },
			{ 6, 0, 5, INF, 3, INF }, 
			{ 1, 5, 0, 5, 6, 4 },
			{ 5, INF, 5, 0, INF, 2 },
			{ INF, 3, 6, INF, 0, 6 },
			{ INF, INF, 4, 2, 6, 0 } };
	public static List<Edge> edges = new ArrayList<Edge>();
	public static void main(String[] args) {
		//根据邻接矩阵生成边集合
		int N = D.length;
		for(int i = 0;i<N-1;i++){
			for(int j = i+1;j<N;j++){
				if(D[i][j] != 0){
					edges.add(new Edge(i,D[i][j],j));
				}
			}
		}
		//将边集合排序
		Collections.sort(edges);
		//并查集空间申请
		int[] sets = new int[N];
		for(int i = 0;i<N;i++){
			sets[i] = i;	//各自为一个集合
		}
		//开始生成
		List<Edge> gets = new ArrayList<Kruskal.Edge>();
		while(gets.size()+1 != N){
			Edge edge = edges.get(0);
			if(!isSame(edge.start,edge.end, sets)){
				merge(edge.start,edge.end,sets);
				gets.add(edge);
			}
			edges.remove(0);
		}
		//输出
		for (Edge edge : gets) {
			System.out.println(edge);
		}
	}
	//并插集
	public static int find(int x,int[] sets){
		int r = x;
		while(r!=sets[r]){
			r = sets[r];
		}
		//更新节点
		int temp = x;
		while(temp!=sets[temp]){
			sets[x] = r;
			x = temp;
			temp = sets[temp];
		}
		return r;
	}
	//判断是否为一个节点
	public static boolean isSame(int x,int y,int[] sets){
		if(find(x,sets) == find(y,sets)){
			return true;
		}
		return false;
	}
	//融合
	public static void merge(int x,int y,int[] sets){
		sets[y] = find(x,sets);
	}
	
	
	
	private static class Edge implements Comparable<Edge>{//实现comparable接口
		int start;
		int end;
		int value;
		public Edge(int start, int value, int end) {
			super();
			this.start = start;
			this.value = value;
			this.end = end;
		}
		public int compareTo(Edge arg0) {
			// TODO Auto-generated method stub
			return this.value - arg0.value;
		}
		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", value=" + value
					+ "]";
		}
	
		
	}
}
