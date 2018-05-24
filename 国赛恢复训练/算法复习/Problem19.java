package 国赛恢复训练.算法复习;
/**
 * 树形dp，生命之树
 * @author 张兴锐
 *
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Problem19 {
	static ArrayList<Integer>[] list;
	static int N;
	static int[] value ;
	static int[][] dp;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		list = new ArrayList[N];
		value = new int[N];
		dp = new int[N][2];
		for(int i = 0;i<N;i++) {
			dp[i][1] = input.nextInt();
		}
		for(int i = 0;i<N-1;i++) {
			int a = input.nextInt() -1 ;
			int b = input.nextInt() -1;
			if(list[a] == null) {
				list[a] = new ArrayList<Integer>();
			}
			if(list[b] == null) {
				list[b] = new ArrayList<Integer>();
			}
			list[a].add(b);
			list[b].add(a);
		}
		//树形dp
		dfs(1,-1);
		//找到最大的
		int max = -Integer.MAX_VALUE;
		for(int i = 0;i<N;i++) {
			if(max < dp[i][0]) {
				max = dp[i][0];
			}
			if(max < dp[i][1]) {
				max = dp[i][1];
			}
		}
		System.out.println(max);
	}
	public static void dfs(int c,int pre) {
		for(int i:list[c]) {
			if(i == pre) {
				//说明是叶子节点
				dp[i][0] = 0;
			}else {
				dfs(i,c);
				dp[c][1] += dp[i][1]>0 ?dp[i][1]: 0;
				dp[c][0] = Math.max(dp[c][0], dp[i][1]);
			}
		}
	}
}
