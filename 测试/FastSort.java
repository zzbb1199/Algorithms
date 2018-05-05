package 测试;

import java.util.Arrays;

public class FastSort {
	public static void main(String[] args) {
		int[] data = { 1, 5, 4, 3, 2, 0 ,100,23,123,4,12,3};
		fastSort(0,data.length-1,data);
		System.out.println(Arrays.toString(data));
	}
	public static void fastSort(int start,int end,int[] data){
		if(start == end){
			return;
		}
		int p = data[start];
		int i = start+1;
		int j = end;
		while(true){
			while(data[i]<=p) i++;
			try{
				while(data[j]>=p) j--;
			}catch(Exception e){
				e.printStackTrace();
			}
			
			if(i<j){
				swap(i,j,data);
				i++;
				j--;
			}else{
				break;
			}
		}
		if(j>start){
			swap(start,j,data);
		}
		//分治
		if(j>start){
			fastSort(start,j-1,data);
		}
		if(i<end){
			fastSort(i,end,data);
		}
	}
	
	public static void swap(int i,int j,int[] data){
		int t = data[i];
		data[i] = data[j];
		data[j] = t;
	}
}
