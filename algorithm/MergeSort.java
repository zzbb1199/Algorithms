package algorithm;

import java.util.Arrays;

/**
 * 归并排序-分治法思想
 * 分治法：将原问题拆分为很多个具有相同形式的子问题，子问题之间没有重叠
 * 最后融合子问题
 * @author zxr
 */
public class MergeSort {

	private static int[] unSort = {
			1,2,4,532,41,412,3,124,5,7,68,56,75
	};
	public static void main(String[] args) {
		//输出原数据
		System.out.println(Arrays.toString(unSort));
		//进行排序
		mergeSort(unSort,0,unSort.length-1);
		System.out.println(Arrays.toString(unSort));
	}
	/**
	 * 归并排序算法
	 */
	private static void mergeSort(int[] A,int start,int end) {
		if(end <= start) {
			//如果只剩一个元素，返回
			return;
		}
		int half = (start+end)/2;
		mergeSort(A,start,half);
		mergeSort(A,half+1,end);
		//最后要融合，这是分治法特点之一
		merge(A,start,end);
	}
	/**
	 * 融合
	 */
	private static void merge(int[] A,int start,int end) {
		//定义两个指针用于移动
		int i = start;
		int half = (start+end)/2;
		int j = half+1;
		//在定义一个主指针
		int index = 0;
		int[] B = new int[end-start+1];
		while(i <= half && j <= end) {
			if(A[i]>A[j]) {
				B[index++] = A[j++];
			}else {
				B[index++] = A[i++];
			}
		}
		//某个指针还未走完
		while(i<=half) {
			B[index++] = A[i++];
		}
		while(j<=end) {
			B[index++] = A[j++];
		}
		//将B复制到A的相应区段
		for(int k = start;k<=end;k++) {
			A[k] = B[k-start];
		}
	}

}
