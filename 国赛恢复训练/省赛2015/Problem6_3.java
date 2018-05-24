package 国赛恢复训练.省赛2015;

import java.util.Random;

/**
 * 随机算法求解
 * @author 张兴锐
 *
 */
public class Problem6_3 {
	static int[] a = new int[49];
	static int[] b = new int[48];
	public static void main(String[] args) {
		for(int i = 0;i<49;i++) {
			a[i] = i+1;
		}
		int index1 = 0;
		int index2 = 0;
		Random r = new Random();
		do 
		{
			b[index1] = 0;
			b[index2] = 0;
			index1 = r.nextInt(48);
			index2 = r.nextInt(48);
			if(Math.abs(index1 - index2) == 1) {
				continue;
			}
			b[index1] = 1;
			b[index2] = 1;
		}while(!check(index1,index2));
		System.out.println(index1>index2?index2:index1);
	}
	private static boolean check(int index1,int index2) {
		if(index1 < index2 ) {
			if(index1 == 9) {
				return false;
			}
		}else
			if(index2 == 9) {
				return false;
			}
		int sum = a[0];
		for(int i = 0;i<48;i++) {
			if(b[i] == 0) {
				sum+=a[i+1];
			}else {
				sum-=a[i];
				sum+=(a[i]*a[i+1]);
			}
			if(b[i] > 2015) {
				return false;
			}
		}
		return sum == 2015;
	}
}
