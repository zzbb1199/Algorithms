package 蓝桥杯官方.国赛.真题2015;

public class Problem2 {
	static int count = 0;

	public static void main(String[] args) {
		int[] data = { 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 };
		f(0, data);
		System.out.println(count / 5);
	}

	public static void f(int index, int[] data) {
		if (index == data.length) {
			// 判定
			if (check(data)) {
				count++;
			}
			return;
		}
		for (int i = index; i < data.length; i++) {
			int t = data[index];
			data[index] = data[i];
			data[i] = t;
			f(index + 1, data);
			t = data[index];
			data[index] = data[i];
			data[i] = t;
		}
	}

	private static boolean check(int[] data) {
		int t1 = data[0] + data[2] + data[5] + data[8];
		int t2 = data[0] + data[3] + data[6] + data[9];
		int t3 = data[1] + data[2] + data[3] + data[4];
		int t4 = data[1] + data[5] + data[7] + data[9];
		int t5 = data[4] + data[6] + data[7] + data[8];
		if (t1 == t2 && t2 == t3 && t3 == t4 && t4 == t5) {
			return true;
		}
		return false;
	}
}
