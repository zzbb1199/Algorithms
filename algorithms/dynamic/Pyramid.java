package algorithms.dynamic;

import java.util.Scanner;

public class Pyramid {

	/**
	 * @param args
	 */
	static Stone[] cost ;
	static final int NaN = -1;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		cost = new Stone[n+1];
		for(int i = 0;i<n+1;i++){
			cost[i] = new Stone(1000,"");
		}
		cost[0].value = NaN;
		cost[1].value = NaN;
		for(int i = 2;i<=n;i++){
			form(i);
		}
		System.out.println(cost[n]);
	}
	private static void form(int k) {
		//是否能形成高金子塔
		int sum = 0;
		int i = 1;
		while(sum < k){
			sum+=i*i;
			i++;
		}
		if(sum == k){
			cost[k].value = 1;
			cost[k].result = (i-1)+"H";
			return;
		}
		//是否能形成低金字塔
		sum = 0;
		i = 1;
		while(sum < k){
			sum+=i*i;
			i+=2;
		}
		if(sum == k){
			cost[k].value = 1;
			cost[k].result = (i-2)+"L";
			return;
		}
		//动态规划
		for(i = 1;i<k;i++){
			if(cost[k-i].value == NaN || cost[i].value == NaN){
				continue;
			}
			if(cost[k].value > cost[k-i].value + cost[i].value){
				cost[k].value = cost[k-i].value + cost[i].value;
				cost[k].result = cost[k-i].result+" "+cost[i].result;
			}
		}
		if(cost[k].value != 1000){
			return;
		}
		cost[k].value = NaN;
		return;
	}
	static class Stone{
		int value;
		String result;
		public Stone(int value, String result) {
			this.value = value;
			this.result = result;
		}
		@Override
		public String toString() {
			if(value == NaN){
				return "impossible";
			}
			return  result;
		}
		
	}
}
