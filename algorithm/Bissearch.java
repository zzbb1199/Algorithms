package algorithm;

import java.util.Arrays;

public class Bissearch {

	/**
	 * 折半查找-减治法中的减半情况
	 * 查找成功的时间复杂度：(theta为量度）
	 * 最优 1
	 * 最差 logn
	 * 平均 logn
	 * 查找失败的时间复杂度:(theta为量度）
	 * 三种情况都为 logn
	 */
	private static int[] D = {
			302,123,41,1,34,5,61,10
	};
	public static void main(String[] args) {
		//输出原数组
		System.out.println(Arrays.toString(D));
		//首先对数组进行排序，因为折半查找是基于有序数组
		Arrays.sort(D);
		//输出以排序数组
		System.out.println(Arrays.toString(D));
		//查找键值
		int k = 10;
		System.out.println(bisSearch(D,k));
	}
	private static int bisSearch(int[] D,int k) {
		int l = 0;
		int r = D.length-1;
		int m = (l+r)/2;
		while(l <= r) {
			if (k == D[m]) {
				return m;
			}else if(k < D[m]) {
				r = m-1;
			}else {
				l = m+1;
			}
			m = (l+r)/2;
		}
		return -1;
	}

}
