package zhenti2016;

import java.util.Arrays;

public class Problem6 {
	static int[][] m = new int[5][6];
	static int[] can = {0,1,2,3,4,5,6,7,8,9};
	public static void main(String[] args) {
		init();
		f(0);
		System.out.println(count);
	}
	static int count;
	static void f(int index) {
		if(index == can.length) {
			//检查
			if(test(can)) {
				count++;
			}
			return;
		}
		for(int i = index;i<can.length;i++) {
			int c = can[i];can[i] = can[index];can[index] = c;
			f(index+1);
			c = can[i];can[i] = can[index];can[index] = c;
		}
	}
	private static boolean test(int[] can2) {
		for(int row = 1;row<=3;row++) {
			for(int col = 1;col<=4;col++) {
				if(Math.abs(m[row][col]-m[row][col+1]) == 1||
						Math.abs(m[row][col]-m[row-1][col]) == 1||
						Math.abs(m[row][col]-m[row][col-1]) == 1||
						Math.abs(m[row][col]-m[row+1][col]) == 1||
						Math.abs(m[row][col]-m[row+1][col+1]) == 1||
						Math.abs(m[row][col]-m[row+1][col-1]) == 1||
						Math.abs(m[row][col]-m[row-1][col+1]) == 1||
						Math.abs(m[row][col]-m[row-1][col-1]) == 1) {
					return false;
				}
			}
		}
		return true;
	}
	static void init() {
		for(int i = 0;i<6;i++) {
			m[0][i] = -10;
			m[4][i] = -10;
		}
		for(int i = 0;i<5;i++) {
			m[i][0] = -10;
			m[i][5] = -10;
		}
		m[1][1] = -8;
		m[3][4] = -8;
	}
	static void outPut(int[][] m) {
		for (int[] is : m) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
