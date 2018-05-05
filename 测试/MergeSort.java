package 测试;

import java.util.Arrays;

public class MergeSort {
	public static void main(String[] args) {
		int[] data = { 1, 5, 4, 3, 2, 0 ,321,412,41,13,132,45,15,6,13,124};
		mergeSort(0, data.length - 1, data);
		System.out.println(Arrays.toString(data));
	}

	public static void mergeSort(int start, int end, int[] data) {
		if (start == end) {
			return;
		}
		// 拆分
		mergeSort(start, (start + end) / 2, data);
		mergeSort((start + end) / 2 + 1, end, data);
		// 融合
		merge(start,(start+end)/2,(start+end)/2+1,end,data);
	}

	public static void merge(int s1,int e1,int s2,int e2,int[] data) {
		int len = e1-s1+e2-s2+2;
		int[] bk = new int[len];
		int i = s1;
		int j = s2;
		int k = 0;
		while(i<= e1 && j<=e2){
			if(data[i] <= data[j]){
				bk[k++] = data[i++];
 			}else{
 				bk[k++] = data[j++];
 			}
		}
		while(i<= e1){
			bk[k++] = data[i++];
		}
		while(j<=e2){
			bk[k++] = data[j++];
		}
		k = 0;
		for(i = s1;i<=e2;i++){
			data[i] = bk[k++];
		}
	}
}
