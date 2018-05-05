package 蓝桥杯官方.国赛.真题2016;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Problem4 {
	static int N;
	static int[] heng;
	static int[] shu;
	static int[] rheng;
	static int[] rshu;
	static boolean[][] visted;
	static List<Integer> ans = new ArrayList<Integer>();

	public static void main(String[] args) {
		// 初始化
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		heng = new int[N];
		shu = new int[N];
		rheng = new int[N];
		rshu = new int[N];
		visted = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			heng[i] = input.nextInt();
		}
		for (int i = 0; i < N; i++) {
			shu[i] = input.nextInt();
		}

		visted[0][0] = true;
		ans.add(0);
		try {
			f(0, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
	}

	public static void f(int x, int y) throws Exception {
		if (x == N - 1 && y == N - 1) {
			if (check()) {
				// 输出
				outPut();
				throw new Exception();
			}
			rheng = new int[N];
			rshu = new int[N];
			return;
		}
		// 上
		if (x - 1 >= 0 && !visted[x - 1][y]) {
			visted[x - 1][y] = true;
			put(x - 1, y);
			f(x - 1, y);
			remove();
			visted[x - 1][y] = false;
		}
		// 右
			if (y + 1 < N && !visted[x][y + 1]) {
			visted[x][y + 1] = true;
			put(x, y + 1);
			f(x, y + 1);
			visted[x][y + 1] = false;
			remove();
		}
		// 下
		if (x + 1 < N && !visted[x + 1][y]) {
			visted[x + 1][y] = true;
			put(x + 1, y);
			f(x + 1, y);
			remove();
			visted[x + 1][y] = false;
		}
		// 左
		if (y - 1 >= 0 && !visted[x][y - 1]) {
			visted[x][y - 1] = true;
			put(x, y - 1);
			f(x, y - 1);
			remove();
			visted[x][y - 1] = false;
		}
	}

	private static void put(int x, int y) {
		// TODO Auto-generated method stub
		ans.add(x * N + y);
	}

	private static void outPut() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ans.size() - 1; i++) {
			System.out.print(ans.get(i) + " ");
		}
		System.out.println(ans.get(ans.size() - 1));
	}

	private static boolean check() {
		for (int each : ans) {
			rshu[each / N] += 1;
			rheng[each % N] += 1;
		}
		for(int i = 0;i<N;i++){
			if(rheng[i] != heng[i] || rshu[i] != shu[i]){
				return false;
			}
		}
		return true;
	}

	public static void remove() {
		ans.remove(ans.size() - 1);
	}
}
