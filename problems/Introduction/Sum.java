package problems.Introduction;

import java.util.Scanner;

public class Sum {
	/**
	 * 求和
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		long n = input.nextLong();
		input.close();
		//利用求和公式
		System.out.println((1+n)*n/2);
	}
}
