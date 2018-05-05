package 蓝桥杯官方.国赛.真题2015;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {
	static int[][] D;
	static boolean[][] V;
	static int N;
	static int A = -2;
	static int B = 2;
	static int dx, dy;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		D = new int[N][N];
		V = new boolean[N][N];
		min = N*N;
		int sx = 0, sy = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char c = input.next().charAt(0);
				switch (c) {
				case 'A':
					D[i][j] = A;
					sx = i;
					sy = j;
					break;
				case 'B':
					D[i][j] = B;
					dx = i;
					dy = j;
					break;
				case '+':
					D[i][j] = 1;
					break;
				case '-':
					D[i][j] = 0;
					break;
				default:
					break;
				}
			}
		}
		try {
			V[sx][sy] = true;
			f(sx, sy, 0);
			System.out.println(min);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	static int min ;
	public static void f(int cx, int cy, int count) throws Exception {
		if (cx == dx && cy == dy) {
			if(min > count)
			min = count;
//			throw new Exception(count + "");// 直接抛出
			return;
		}
		// 上
		if ((cx - 1 >= 0) && !V[cx-1][cy] && ((D[cx - 1][cy]!=D[cx][cy]) || D[cx][cy] == A)) {
			V[cx-1][cy] = true;
			f(cx - 1, cy, count + 1);
			V[cx-1][cy] = false;
		}
		// 左
		if (cy - 1 >= 0 && !V[cx][cy-1] &&((D[cx][cy - 1] != D[cx][cy]) || D[cx][cy] == A)) {
			V[cx][cy-1] = true;
			f(cx, cy - 1, count + 1);
			V[cx][cy-1] = false;
		}
		// 下
		if (cx + 1 < N && !V[cx+1][cy] && ((D[cx + 1][cy] != D[cx][cy]) || D[cx][cy] == A)) {
			V[cx+1][cy] = true;
			f(cx + 1, cy, count + 1);
			V[cx+1][cy] = false;
		}
		// 右
		if (cy + 1 < N && !V[cx][cy+1] && ((D[cx][cy + 1] != D[cx][cy])  || D[cx][cy] == A)) {
			V[cx][cy+1] = true;
			f(cx, cy + 1, count + 1);
			V[cx][cy+1] = false;
		}
	}

	public static void outPut() {
		// 输出常识
		for (int[] string : D) {
			System.out.println(Arrays.toString(string));
		}
	}
}
