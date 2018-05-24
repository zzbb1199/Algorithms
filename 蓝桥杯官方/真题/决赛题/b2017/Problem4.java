package 蓝桥杯官方.真题.决赛题.b2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Problem4 {
	static int[][] D;
	static boolean[] v;
	static boolean[] is;
	static int N;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		D = new int[N][N];
		is = new boolean[N];
		for(int i = 0;i<N;i++) {
			int row = input.nextInt() -1;
			int col = input.nextInt() -1;
			D[row][col] = 1;
			D[col][row] = 1;
		}
		//dfs找环
		for(int i = 0;i<N;i++) {
			v = new boolean[N];
			if(!is[i]) {
				v[i] = true;
				dfs(i,i,-1);
			}
		}
		Collections.sort(list);
		StringBuilder ans = new StringBuilder();
		for (int i : list) {
			ans.append((i+1)+" ");
		}
		System.out.println(ans.toString().trim());
	}
	static List<Integer> list = new ArrayList<Integer>();
	public static void dfs(int c,int from,int pre) {
		boolean no = true;
		for(int i = 0;i<N;i++) {
			if(!v[i] && D[c][i] == 1) {
				no = false;
				v[i] = true;
				dfs(i,from,c);
			}
		}
		if(no && D[c][from] == 1 && pre != from) {
			list.add(from);
			list.add(c);
			is[c] = true;
			is[from] =true;
		}
	}
}
