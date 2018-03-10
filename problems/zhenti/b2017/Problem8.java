package problems.zhenti.b2017;

import java.util.Arrays;
import java.util.Scanner;

public class Problem8 {
	
	/**
	 * @param args
	 */
	static int inf;
	static int count = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] v = new int[n];
		for(int i = 0;i<v.length;i++){
			v[i] = input.nextInt();
		}
		//排序
		Arrays.sort(v);
		//求解最大公约数
		int m = v[0];
		for(int i = 1;i<v.length;i++){
			m = g(m,v[i]);
		}
		if(m != 1){
			System.out.println("INF");
			return;
		}
		int range = 10000000;
		inf = range+1;
		int[] cost = new int[range+1];
		cost[0] = 0;
		for(int i  = 1;i<=range;i++){
			cost[i] = inf;
			for(int j = 0;j < n;j++){
				if(i - v[j] >= 0 && cost[i-v[j]]+1 < cost[i]){
					cost[i] = cost[i-v[j]]+1;
				}
			}
			if(cost[i]== inf){
				//说明没有凑数成功
				count++;
			}
		}
		System.out.println(count);
	}
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int g(int a,int b){
		if(b == 0){
			return a;
		}
		return g(b,a %  b);
	}

}
