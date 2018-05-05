package 测试;

import java.util.Scanner;

public class Dijkstra {
	//最短路径算法
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
		int N = D.length;
		//D算法，采用贪心思想
		int [] cost = new int[N];
		boolean[] visted = new boolean[N];
		//初始化参数
		for(int i = 0;i<N;i++){
			cost[i] = INF;
		}
		Scanner input = new Scanner(System.in);
		int start = input.nextInt();
		int end = input.nextInt();
		cost[start] = 0;
		visted[start] = true;
		int current = start;
		int[] pathTree = new int[N];
		pathTree[start] = start;
		while(!hasVistAll(visted)){
			for(int i = 0;i<N;i++){
				if(!visted[i]){
					if(cost[current]+D[current][i] < cost[i]){
						cost[i] = cost[current]+D[current][i];
						pathTree[i] = current;
					}
				}
			}
			//一次判定后，查找最小的权重点
			int minIndex = -1;
			int minValue = INF;
			for(int i = 0;i<N;i++){
				if(!visted[i] && cost[i] < minValue){
					minValue = cost[i];
					minIndex = i;
				}
			}
			//更新
			current = minIndex;
			visted[current] = true;
		}
	
		//输出
		//查找路径
		StringBuilder path = new StringBuilder();
		path.append(end+",");
		int temp = pathTree[end];
		path.append(temp+",");
		while(temp != start){
			temp = pathTree[temp];
			path.append(temp+",");
		}
		System.out.println(path.reverse().substring(1));
		System.out.println(cost[end]);
	}
	public static boolean hasVistAll(boolean[] b){
		for (boolean c : b) {
			if(!c){
				return false;
			}
		}
		return true;
	}
	
	
}
