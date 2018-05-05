package 蓝桥杯官方.国赛.真题2016;

import java.util.HashSet;
import java.util.Set;

/**
 * 3阶反幻方
 * 
 * @author zxr
 * 
 */
public class Problem2 {
	static int[] data = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	public static void main(String[] args) {
		f(0);
		System.out.println(count / 6);
	}

	static int count = 0;

	public static void f(int index) {
		if (index == data.length) {
			if (check()) {
				count++;
			}
			return;
		}
		for (int i = index; i < data.length; i++) {
			int t = data[index];
			data[index] = data[i];
			data[i] = t;
			f(index + 1);
			t = data[index];
			data[index] = data[i];
			data[i] = t;
		}

	}

	private static boolean check() {
		int[][] tempdata = new int[3][3];
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				tempdata[row][col] = data[row * 3 + col];
			}
		}
		// 每行
		Set<Integer> sets = new HashSet<Integer>();
		int nowsum = 0;
		for (int row = 1; row < 3; row++) {
			for (int col = 0; col < 3; col++) {
				nowsum += tempdata[row][col];
			}
			if (sets.contains(nowsum)) {
				return false;
			}
			sets.add(nowsum);
			nowsum = 0;
		}
		// 每列
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				nowsum += tempdata[row][col];
			}
			if (sets.contains(nowsum)) {
				return false;
			}
			sets.add(nowsum);
			nowsum = 0;
		}
		//两个对脚
		nowsum = tempdata[0][0] + tempdata[1][1] + tempdata[2][2];
		if (sets.contains(nowsum)) {
			return false;
		}
		sets.add(nowsum);
		nowsum = 0;
		nowsum = tempdata[0][2]+tempdata[1][1]+tempdata[2][0];
		if(sets.contains(nowsum)){
			return false;
		}
		return true;
	}
}
