package problems.zhenti.b2017;

import java.util.Arrays;
import java.util.Scanner;

public class Problem9 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		Cake[] cakes = new Cake[N];
		for(int i =0; i< N;i++){
			cakes[i] = new Cake(input.nextInt(),input.nextInt());
		}
		//找到所有边长中，最小的边
		int max = 0;
		for (Cake cake : cakes) {
			if(max < cake.w){
				max=cake.w;
			}
			if(max < cake.h){
				max = cake.h;
			}
		}
		int[] ed = new int[max];
		for(int i = 0;i<ed.length;i++){
			ed[i] = i+1;
		}
		Arrays.sort(ed);
		//二分法
		int l = 0;
		int h = ed.length-1;
		int m = (l+h)/2;
		int best = 0;
		while(l <= h){
			if(check(ed[m],cakes,K)  == -1){
				//少了
				h = m-1;
				m = (l+h)/2;
			}else{
				//多了或者刚好
				//保存当前边长
				best = ed[m];
				l = m+1;
				m = (l+h)/2;
			}
		}
		System.out.println(best);
	
	}
	/**
	 * -1 代表小于
	 * 1 代表大于
	 * @return
	 */
	private static int check(int m,Cake[] c,int K){
		int sum = 0;
		for(int i =0;i<c.length;i++){
			sum+=c[i].cut(m);
			if(sum >= K){
				return 1;
			}
		}
		if(sum >= K){
			return 1;
		}else{
			return -1;
		}
	}
	
	static class Cake{
		int w,h;
		int[][] a;
		public Cake(int w, int h) {
			super();
			this.w = w;
			this.h = h;
		}
		
		/**
		 * 边长base能够分解为多少块
		 * @param base
		 * @return
		 */
		public int cut(int base){
			int count1 = 0;
			a = new int[w][h];
			//w*h矩阵分解
			int start_row = 0;
			int start_col = 0;
			for(int i = 0;i<w;i++){
				boolean iscut = false;
				for(int j = 0;j<h;j++){
					if(a[i][j] == 0){
						start_row = i;
						start_col = j;
						if(h - start_col >= base && w - start_row >= base){
							//可再分解
							iscut = true;
							set(start_row,start_row+base-1,start_col,start_col+base-1,-1);
							count1++;
							j= j+base-1;//
						}
					}
				}
				if(iscut){
					i= i+base-1;
				}
			}
//			int count2 = 0;
//			a = new int[h][w];
//			//h*w矩阵分解
//			start_row = 0;
//			start_col = 0;
//			for(int i = 0;i<h;i++){
//				boolean iscut = false;
//				for(int j = 0;j<w;j++){
//					if(a[i][j] == 0){
//						start_row = i;
//						start_col = j;
//						if(w - start_col >= base && h - start_row >= base){
//							//可再分解
//							iscut = true;
//							set(start_row,start_row+base-1,start_col,start_col+base-1,-1);
//							count2++;
//							j= j+base-1;//
//						}
//					}
//				}
//				if(iscut){
//					i= i+base-1;
//				}
//			}
//			return count1<count2?count2:count1;
			return count1;
		}
		/**
		 * 
		 * @param row_from
		 * @param row_to
		 * @param col_from
		 * @param col_to
		 * @param value 0 代表可分解，-1代表不可分解
		 */
		private void set(int row_from,int row_to,int col_from,int col_to,int value){
			for(int i = row_from;i<=row_to;i++){
				for(int j = col_from;j<=col_to;j++){
					a[i][j] = value;
				}
			}
		}
	}
}
