package problems.Introduction;

import java.util.Scanner;

public class Sort {

	/**
	 * 
	 * 问题描述 给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200 
	 * 输入格式 第一行为一个整数n。第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
	 * 输出格式 输出一行，按从小到大的顺序输出排序后的数列。 样例输入 5 8 3 6 4
	 * 9 样例输出 3 4 6 8 9
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] unsort = new int[n];
		for (int i = 0; i < unsort.length; i++) {
			unsort[i] =input.nextInt(); 
		}
		input.close();
		//要求不高采用最简单的选择排序即可
		for(int i = 0;i<n-1;i++) {
			for(int j = i+1;j<n;j++) {
				if(unsort[i] > unsort[j]) {
					swap(unsort,i,j);
				}
			}
		}
		//输出
		String outPut = "";
		for (int i : unsort) {
			outPut += i+ " ";
		}
		System.out.println(outPut.trim());
	
	}
	public static void swap(int[] data,int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

}
