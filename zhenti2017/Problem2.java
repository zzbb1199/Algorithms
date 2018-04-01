package zhenti2017;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
	static List<Integer> restore = new ArrayList<>();
	static int N = 1000 * 100;
	static int[] origin = new int[N];

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			origin[i] = i + 2;// 2~N+1
		}
		for (int i = 0; i < N; i++) {
			if (origin[i] == 0) {
				continue;
			}
			for (int j = i + 1; j < N; j++) {
				if (origin[j] == 0) {
					continue;
				} else {
					if (origin[j] % origin[i] == 0) {
						origin[j] = 0;
					}
				}
			}
		}
		// 填充
		for (int i = 0; i < N; i++) {
			if (origin[i] != 0) {
				restore.add(origin[i]);
			}
		}
	
		// 判定
		for (int i = 0; i < restore.size() - 1; i++) {
			for (int d = 1; d <= 300; d++) {
				int current = restore.get(i);
				int count = 1;
				for (int num = 1; num <= 10; num++) {
					current += d;
					if (restore.contains(current)) {
						count++;
						if (count == 10) {
							break;
						}
					} else {
						break;
					}
				}
				if (count == 10) {
					System.out.println(d);
					return;
				}
			}
		}
	}
}
