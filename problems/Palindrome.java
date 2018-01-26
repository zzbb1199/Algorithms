package problems;

import java.util.Scanner;

/**
 * 回文判断
 * 
 * @author zxr
 *
 */
public class Palindrome {

	static int n;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		input.close();
//		所有5位数
		for(int i = 10000;i<=99999;i++) {
			if(sumAll(i,5)) {
				System.out.println(i);
			}
		}
		//所有6位数
		for(int i = 100000;i<=999999;i++) {
			if(sumAll(i,6)) {
				System.out.println(i);
			}
		}
	}

	private static boolean sumAll(int num,int length) {
		String str = String.valueOf(num);
		int sum = 0;
		for(int i = 0;i<length/2;i++) {
			if(str.charAt(i) != str.charAt(length-i-1)) {
				return false;
			}
			sum+=(str.charAt(i) - '0');
		}
		
		for(int i = length/2;i<length;i++) {
			sum+=(str.charAt(i) - '0');
		}
		if(sum == n) {
			return true;
		}
		return false;
	}

}
