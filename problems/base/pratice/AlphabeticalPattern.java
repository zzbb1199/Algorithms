package problems.base.pratice;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 问题描述
利用字母可以组成一些美丽的图形，下面给出了一个例子：

ABCDEFG

BABCDEF

CBABCDE

DCBABCD

EDCBABC

这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。

输入格式
输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
输出格式
输出n行，每个m个字符，为你的图形。
 * @author zxr
 *
 */
public class AlphabeticalPattern {
	static int n;	//行
	static int m;	//列
	static char[] ZM;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		input.close();
		//初始化字母表
		ZM = new char[26];
		for (int i = 0; i < ZM.length; i++) {
			ZM[i] = (char) ('A'+i);
		}
		//输出图形
		for(int i = 0;i<n;i++){
			for(int j = 0;j<m;j++) {
				System.out.print(ZM[Math.abs(i-j)]);		
			}
			System.out.println();
		}
	}

}
