package problems.base.pratice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FJ在沙盘上写了这样一些字符串：
　　A1 = “A”
　　A2 = “ABA”
　　A3 = “ABACABA”
　　A4 = “ABACABADABACABA”
 * @author zxr
 *
 */
public class FJString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		char[] result = back(n);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
		}
		System.out.println();
	}
	public static char[] back(int n) {
		if(n == 1) {
			return new char[]{'A'};
		}
		char[] pre_zimu = back(n-1);
		int size = pre_zimu.length*2+1;
		int half = size/2;
		char[] zimu = new char[size];
		for(int i = 0;i<size/2;i++) {
			zimu[i] = pre_zimu[i];
			zimu[half+1+i] = pre_zimu[i];
		}
		zimu[half] = (char)('A'+n-1);
		return zimu;
	}

}
