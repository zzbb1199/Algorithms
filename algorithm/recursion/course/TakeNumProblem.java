package algorithm.recursion.course;

import java.util.Arrays;

/**
 * "AABBC" 取三个数字，能够取多少种
 * @author zxr
 *
 */
public class TakeNumProblem {
	static int count = 0;
	public static void main(String[] args) {
		int[] data = {2,2,1};
		int[] x = new int[data.length];
		f(data,x,0,3);
		System.out.println(count);
	}
	public static void f(int[] data,int[] x,int index,int target) {
		if(sum(x) == target) {
			count++;
			System.out.println(Arrays.toString(x));
			return;
		}
		if(index == 3) {
			return;
		}
		for(int i = 0;i<=data[index];i++) {
			x[index] = i;
			f(data,x,index+1,target);
		}
	}
	private static int sum(int[] x) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i : x) {
			sum+=i;
		}
		return sum;
	}
}
