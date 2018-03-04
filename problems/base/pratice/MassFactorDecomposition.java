package problems.base.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
问题描述
　　求出区间[a,b]中所有整数的质因数分解。
输入格式
　　输入两个整数a，b。
输出格式
　　每行输出一个数的分解，形如k=a1*a2*a3...(a1<=a2<=a3...，k也是从小到大的)(具体可看样例)
样例输入
3 10
样例输出
3=3
4=2*2
5=5
6=2*3
7=7
8=2*2*2
9=3*3
10=2*5

 * @author zxr
 *
 */
public class MassFactorDecomposition {
	static List<Integer> A = new ArrayList<>();//存储所有质数 
	static List<Integer> answer = new ArrayList<>() ;	//存储每一个数字的结果
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		//step1所有素数
		A.add(2);
		findAll(b);
		//step2 求解
		for(int i = a;i<=b;i++) {
			answer.clear();
			System.out.print(i+"=");
			if(check(i)) {
				System.out.println(i);
			}else {
				rem(i);
			}
		}
	}
	/**
	 * 循环取余
	 * @param tv
	 */
	public static void rem(int tv) {
		int length = A.size();
		for(int i = 0;i<length;i++) {
			int value = A.get(i);
			while(tv % value == 0) {
				answer.add(value);
				tv/=value;
				if(tv < value) {
					break;
				}
			}
			if(tv == 1) {
				outPut();
				break;
			}
		}
	}
	/**
	 * 方式二递归，最开始想到的方法，内存耗费大，递归深度深，，容易溢出，不过也算是一种解法
	 * @param tv
	 * @param cv
	 * @param i
	 */
	public static void back(int tv,int cv,int i) {
		do {
			answer.add(A.get(i));
			cv*=A.get(i);
		}while(cv < tv);

		if(cv == tv) {
			outPut();
			return;
		}else {
			//
			cv/=answer.get(answer.size()-1);
			int last = answer.get(answer.size()-2);
			cv/=last;
			answer.remove(answer.size()-1);
			answer.remove(answer.size()-1);
			int lastIndex = A.indexOf(last);
			back(tv,cv,++lastIndex);
			return;
		}
	}
	public static void outPut() {
		//输出
		StringBuilder str = new StringBuilder();
		for (Integer integer : answer) {
			str.append(integer+"*");
		}
		System.out.println(str.toString().substring(0,str.length()-1));
		return;
	}
	
	/**
	 * 求一定范围内的所有质数
	 * @param a
	 * @param b
	 */
	public static void findAll(int b){
		for(int i = 3;i<=b;i++) {
			if(check(i)) {
				A.add(i);
			}
		}
	}
	public static boolean check(int m) {
		for(int j = 2;j<=Math.sqrt(m);j++) {
			if(m % j == 0) {
				return false;
			}
		}
		return true;
	}

}
