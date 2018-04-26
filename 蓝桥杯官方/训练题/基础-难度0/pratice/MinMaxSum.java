package problems.base.pratice;

import java.util.Scanner;

/**
 * 给出n个数，找出这n个数的最大值，最小值，和。
 * @author zxr
 *
 */
public class MinMaxSum {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = input.nextInt();
		}
		input.close();
		outPutResult(data);
	}

	private static void outPutResult(int[] data) {
		// TODO Auto-generated method stub
		int min = 10000;
		int max = -10000;
		int sum = 0;
		for (int i = 0; i < data.length; i++) {
			if(min > data[i]) {
				min = data[i];
			}
			if(max < data[i]) {
				max = data[i];
			}
			sum+=data[i];
		}
		System.out.println(max);
		System.out.println(min);
		System.out.println(sum);
	}
}
