package zhenti2017;

import java.util.Scanner;

/**
 * 标题： k倍区间
 * 
 * 给定一个长度为N的数列，A1, A2, ... AN，如果其中一段连续的子序列Ai, Ai+1, ... Aj(i <=
 * j)之和是K的倍数，我们就称这个区间[i, j]是K倍区间。
 * 
 * 你能求出数列中总共有多少个K倍区间吗？
 * 
 * 输入 ----- 第一行包含两个整数N和K。(1 <= N, K <= 100000) 以下N行每行包含一个整数Ai。(1 <= Ai <=
 * 100000)
 * 
 * 输出 ----- 输出一个整数，代表K倍区间的数目。
 * 
 * @author zxr
 *
 */
public class Problem10 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int k = input.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = input.nextInt();
		}
		a[0] = a[0] % k;
		for (int i = 1; i < n; i++) {
			a[i] = (a[i] + a[i - 1]) % k;
		}
		// 计算
		long sum = 0;
		int[] save = new int[k];
		for(int i = 0;i<n;i++) {
			save[a[i]]++;
		}
		for(int i = 0;i<k;i++) {
			sum+=save[i];
		}
		System.out.println(sum+(save[0]*(save[0]-1)/2));
	}
}
