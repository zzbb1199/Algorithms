package problems;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 阶乘问题
 * 　n!可能很大，而计算机能表示的整数范围有限，需要使用高精度计算的方法。使用一个数组A来表示一个大整数a，A[0]表示a的个位，A[1]表示a的十位，依次类推。
　　将a乘以一个整数k变为将数组A的每一个元素都乘以k，请注意处理相应的进位。
　　首先将a设为1，然后乘2，乘3，当乘到n时，即得到了n!的值。
 * @author zxr
 *
 */
/**
 * 最高位采用标志max_index标志位标志
 */
public class Factorial {
	static int n;
	static int[] A;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
//		n = input.nextInt();
		input.close();
		n = 1000;
		int length = 2590;	//给一个尽量大的空间,考虑动态空间会不会更好？？？？
		A = new int[length];
		A[0] = 1;
		int max_index = 0;//初始化当前最高位
		for(int i = 1;i<=n;i++) {//外层循环控制乘的次数
			for(int j = 0;j<=max_index;j++) {
				A[j]*=i;
			}
			int temp_max_index = max_index;
			//更新数组
			for(int j = 0;j<=max_index;j++) {
				String temp = Integer.toString(A[j]);
				int per_length = temp.length();
				int gewei = temp.charAt(per_length-1) - '0';
				int k;
				for(k = 1;k<per_length;k++) {
					A[j+k] += (temp.charAt(per_length-1-k) - '0');	//后部分为提位操作
				}
				A[j] = gewei;	//恢复
				temp_max_index = j+k-1;
				if (temp_max_index > max_index) {
					max_index = temp_max_index;
				}
			}
		}
		StringBuilder result = new StringBuilder();
		for(int i = 0;i<=max_index;i++) {
			result.append(A[i]);
		}
		System.out.println(result.reverse());
		BigInteger big = new BigInteger("2");
		for(int i = 1;i<=n;i++) {
			big = big.multiply(new BigInteger(""+i));
		}
		System.out.println(big);
	}
	
}
