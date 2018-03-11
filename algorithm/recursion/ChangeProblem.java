package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ChangeProblem {

	static List<int[]> answer = new ArrayList<>();
	static List<float[]> A = new ArrayList<>();
	static int[] current ;
	static boolean[] visted;
	static int range;
	static int m;
	static int n;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		input.close();
		range = m;	//区间为0-m
		current = new int[n];
		visted = new boolean[range+1];
		deep(0);
		//生成新解
		float[] a = new float[2*m+1];
		for(int i = 0;i<m;i++) {
			a[i*2] = 0;
			a[i*2+1] = 0.5f;
		}
		//插入
		for(int i = 0;i<answer.size();i++) {
			int[] tempi = answer.get(i);
			for (int j : tempi) {
				a[j*2] = 1;
			}
			//添加
			float[] copya = a.clone();
			float[] tempa = new float[m+n];
			int index = 0;
			for (float f : copya) {
				if(f != 0) {
					tempa[index] = f;
					index++;
				}
			}
			A.add(tempa);
			//还原
			for (int j : tempi) {
				a[j*2] = 0;
			}
		}
		//最后检验符合规则的结果
		int count = 0;
		for (float[] f : A) {
			float sum = 0f;
			int index = 0;
			for (;index<f.length;index++) {
				if(f[index] ==  0.5) {
					sum+=0.5;
				}else {
					sum-=0.5;
				}
				if(sum<0) {
					break;
				}
			}
			//正常退出
			if(index == f.length) {
				count++;
				System.out.println(Arrays.toString(f));
			}
		}
		System.out.println(count);
	}
	public static void deep(int i) {
		if(i == n) {
			//产生了一个解，但是需要判定是否为重复解
			int[] temp = current.clone();
			Arrays.sort(temp);
			//检查是否会相同
			boolean not = false;
			for(int k = 0;k<answer.size();k++) {
				int[] a = answer.get(k);
				int j = 0;
				for (; j < a.length; j++) {
					if(a[j] != temp[j]) {
						break;
					}
				}
				if(j == a.length) {
					//正常退出
					not = true;
					break;
				}
			}
			if(!not) {
				answer.add(temp);
			}
			return;
		}
		for(int j = 0;j<=range;j++) {
			if(!visted[j]) {
				visted[j] = true;
				current[i] = j;
				deep(i+1);
				visted[j] = false;
			}
		}
		
	}

}
