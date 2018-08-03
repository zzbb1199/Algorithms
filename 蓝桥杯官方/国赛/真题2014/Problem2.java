package 蓝桥杯官方.国赛.真题2014;

import java.util.Arrays;

/**
 * 连续奇数和
 * @author Raven
 *
 */
public class Problem2 {
	static int N = 12322/2;
	static int[] odd = new int[N];
	static int[] record = new int[N];
	static int target = 111*111;
	public static void main(String[] args) {
		//初始话odd
		odd[0] = 1;
		for(int i = 1;i<N;i++) {
			odd[i] = odd[i-1]+2;
		}
		f(0,0,0);
	}
	public static void f(int ri,int oi,int cs) {
		if(oi == N) {
			return;
		}
		if(cs == target) {
			System.out.println(Arrays.toString(record));
			return;
		}
		for(int i = oi;i<N;i++) {
			if(cs+odd[i] > target) {
				return;
			}
			record[ri] = odd[i];
			f(ri+1,i+1,cs+odd[i]);
			record[ri] = 0;
		}
		
	}

}
