package problems.base.pratice;

import java.util.Scanner;

/**
 * 楊輝三角形
 * @author 张兴锐
 *
 */
public class YangHuiTriangle {
	static int n ;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		input.close();
		int[][] tri = new int[n][n];
		
		for(int i = 0;i<n;i++) {
			tri[i][0] = 1;
		}
		for(int i = 1;i<n;i++) {
			for(int j = 1;j<=i;j++) {
				tri[i][j] = tri[i-1][j-1] + tri[i-1][j];
			}
		}
		//outPut
		outPut(tri,0);
	}

	private static void outPut(int[][] tri, int k) {
		if(k == n) {
			return;
		}
		for(int i = 0;i<k;i++) {
			System.out.print(tri[k][i]+" ");
		}
		System.out.println(tri[k][k]);
		outPut(tri,k+1);
	}
}
