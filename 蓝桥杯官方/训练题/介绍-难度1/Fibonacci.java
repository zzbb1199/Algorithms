package problems.Introduction;

import java.util.Scanner;

/**
 * 问题描述: Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * @author zxr
 *
 */
public class Fibonacci {

	static long n;
	static int a1;
	static int a2;
	static int temp;

	public static void main(String[] args) {
		a1 = 1;
		a2 = 1;
		Scanner input = new Scanner(System.in);
		n = input.nextLong();
		input.close();
		for (int i = 3; i <= n; i++) {
			temp = a2;
			a2 = (a1 + a2) % 10007;
			a1 = temp;
		}
		System.out.println(a2);
	}

}
