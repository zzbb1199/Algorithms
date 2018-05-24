package 国赛恢复训练.算法复习;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 树形dp
 * @author 张兴锐
 * 没有上司的舞会
 */
public class Problem18 {
	static Set<Integer>[] sets ;
	Problem18[] o = new Problem18[1];
	static int[][] dp;
	static int N;
	static int[] parent ;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		dp = new int[N][2];
		sets = new HashSet[N];
		parent = new int[N];
		
		//初始化parent
		for(int i = 0;i<N;i++) {
			parent[i] = i;
		}
		for(int i = 0;i<N;i++) {
			dp[i][1] = input.nextInt();
		}
		//建树
		for(int i = 0;i<N-1;i++) {
			int son = input.nextInt()-1;
			int father = input.nextInt()-1;
			parent[son] = father;
			if(sets[father] == null) {
				sets[father] = new HashSet<Integer>();
			}
			sets[father].add(son);
		}
		//找到root
		int c = parent[0];
		while(c != parent[c]) {
			c =parent[c];
		}
		//dp
		dfs(c);
		System.out.println(Math.max(dp[c][0], dp[c][1]));
	}
	public static void dfs(int c) {
		if(sets[c] == null) {
			//根节点
			return;
		}
		for(int i : sets[c]) {
			dfs(i);
			//dp
			dp[c][0] += Math.max(dp[i][0], dp[i][1]);
			dp[c][1] += dp[i][0];
		}
	}
	static class Node{
		Set<Integer> set = new HashSet<Integer>();
		public void add(int i) {
			set.add(i);
		}
		
	}
}
