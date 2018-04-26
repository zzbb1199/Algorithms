package zhenti2016;

import java.util.Scanner;

public class Problem9 {
	static int[] use = new int[3];
	static int[] start = new int[5];
	static int min= 10000;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		for (int i = 0; i < use.length; i++) {
			use[i] = input.nextInt();
			if(min > use[i]) {
				min = use[i];
			}
		}
		for (int i = 0; i < start.length; i++) {
			start[i] = input.nextInt();
		}
		input.close();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < start.length; i++) {
			int t = f(start[i], 0,0,0);
			if (t == 1) {
				str.append("+" + " ");
			} else if (t == 0) {
				str.append("0" + " ");
			} else if (t == -1) {
				str.append("-" + " ");
			}
		}
		System.out.println(str.substring(0, str.length() - 1));
	}

	/**
	 * 1 + 0 -1 - x 0 先 1 后
	 */
	/**
	 * 本函数针对先走
	 */
	static int f(int num, int x, int first, int second) {
		if (num < min) {
			if (first % 2 != 0 && second % 2 == 0) {
				return x == 0 ? 1 : -1;
			} else if (first % 2 != 0 && second % 2 != 0) {
				return 0;
			} else if (first % 2 == 0 && second % 2 != 0) {
				return x == 0 ? -1 : 1;
			} else if (first % 2 == 0 && second % 2 == 0) {//都是偶数？？？
				return 0;
			}
		}
		int tag = -1;
		for (int i = 0; i < 3; i++) {
			if (num - use[i] >= 0) {
				int t;
				if (x == 0) {
					t = f(num - use[i], x ^ 1,first+use[i],second);
				} else {
					t = f(num - use[i], x ^ 1,first,second+use[i]);
				}
				if (t == 1) {
					continue;
				} else if (t == 0) {
					tag = 0;
				} else if (t == -1) {
					tag = 1;
					return tag;
				}

			}
		}
		return tag;
	}
}
