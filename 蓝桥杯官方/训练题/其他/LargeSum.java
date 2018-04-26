package problems;

import java.util.Scanner;

/**
 *输入两个整数a和b，输出这两个整数的和。a和b都不超过100位。
 *这里用数组实现（用大整数更好的说，不过要求用数组就用数组咯）
 * @author zxr
 *
 */
public class LargeSum {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		String b = input.nextLine();
		input.close();
		int a_length = a.length();
		int b_length = b.length();
		if(a_length< b_length ){
			//始终保持a为长字符串，方便后面程序实现
			String c = a;
			a = b;
			b = c;
			int c_length = a_length;
			a_length = b_length;
			b_length = c_length;
		}
		//初始化
		int[] A = new int[a.length()];
		int[] B = new int[b.length()];
		for(int i = 0;i<A.length;i++) {
			A[i] = a.charAt(a_length-1-i) - '0';
		}
		for(int i = 0;i<B.length;i++) {
			B[i] = b.charAt(b_length-1-i) - '0';
		}
		int[] C = new int[a_length+1];	
		for(int i = 0;i<a_length;i++) {
			if (i < b_length) {
				C[i]+= A[i]+B[i];
			}else {
				C[i]+=A[i];
			}
			if(Integer.toString(C[i]).length() == 2) {
				C[i+1] += C[i]/10;
				C[i] = C[i]%10;
			}
		}
		//输出
		StringBuilder result = new StringBuilder();
		for(int i = 0;i<a_length+1;i++) {
			result.append(C[i]);
		}
		System.out.println(result.reverse().toString().replaceAll("^0*", ""));
	}
}
