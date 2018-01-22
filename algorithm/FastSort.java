package algorithm;

import java.util.Arrays;

public class FastSort {

	/**
	 * 快速排序，采用分治法解决，排序速度非常快，时间复杂度为nlogn
	 */
	private static int[] unSort = {
			1000545,251,4515,532,41,412,3,124,5,7,68,56,75
	};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(unSort));
		//排序
		fastSort(unSort,0,unSort.length-1);
		System.out.println(Arrays.toString(unSort));
	}
	
	/**
	 * 
	 * @param D,需要进行排序的数组
	 * @param start,开始
	 * @param end，结束
	 * start和end都需要注意下标是从0开始的
	 */
	private static void fastSort(int[] D,int start,int end) {
		//定义两个指针以及比较点
		int i = start+1;
		int j = end;
		int compare  = D[start];
		while(true) {
			while(i <= end && D[i] <= compare ) {
				i++;
			}
			while(j >= start && D[j] >= compare) {
				j--;
			}
			if(i >= j) {
				break;
			}
			//否则进行交换
			swap(D,i,j);
		}
		//进行分治递归
		if(j > start) {
			swap(D,start,j);//之所以放在这里交换，是为了防止j<=start时的溢出或交换到其他区间的元素
			fastSort(D,start,j-1);
		}
		if (i < end) {
			fastSort(D,i,end);
		}
	}
	private static void swap(int[] D,int i,int j) {
		int temp = D[i];
		D[i] = D[j];
		D[j] = temp;
	}

}
