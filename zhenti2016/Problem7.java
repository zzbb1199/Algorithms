package zhenti2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem7 {
	static int[] a = new int[12];
	static int[] c = new int[12];
	static int[] index = new int[5];

	public static void main(String[] args) {
		// 排列组合做
		// for (int i = 0; i < 12; i++) {
		// a[i] = 1;
		// }
		//
		// f(0);
		// System.out.println(count);
		// 循环做
		for (int a1 = 1; a1 <= 12; a1++) {
			for (int a2 = a1 + 1; a2 <= 12; a2++) {
				for (int a3 = a2 + 1; a3 <= 12; a3++) {
					for (int a4 = a3 + 1; a4 <= 12; a4++) {
						for (int a5 = a4 + 1; a5 <= 12; a5++) {
							index[0] = a1;
							index[1] = a2;
							index[2] = a3;
							index[3] = a4;
							index[4] = a5;
							visted[0] = true;
							dfs(0);
							if (hasAllVisted()) {
								// System.out.println(Arrays.toString(index));
								count++;
							}
							visted = new boolean[5];
						}
					}
				}
			}
		}
		System.out.println(count);

	}

	static int count;
	static boolean[] visted = new boolean[5];

	static void dfs(int in) {
		if (hasAllVisted()) {
			return;
		}
		List<Integer> next = find_next(in);
		if (next == null) {
			return;
		} else {
			for (int j : next) {
				visted[j] = true;
				dfs(j);
			}
		}
	}

	private static List<Integer> find_next(int current) {
		List<Integer> next = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			if (i != current && !visted[i]) {
				if ((index[i] + 1 == index[current] && index[i] != 4 && index[i] != 8 && index[i] != 12)
						|| (index[i] - 1 == index[current] && index[i] != 1 && index[i] != 5 && index[i] != 9)
						|| index[i] - 4 == index[current] || index[i] + 4 == index[current]) {
					next.add(i);
				}

			}
		}
		return next.isEmpty() ? null : next;
	}

	private static boolean hasAllVisted() {
		return visted[0] && visted[1] && visted[2] && visted[3] && visted[4];
	}


	static void f(int in) {
		if (sum(c) == 5) {
			// 检验
			System.out.println(Arrays.toString(c));
			set(c);
			visted[0] = true;
			dfs(0);
			if (hasAllVisted()) {
				// System.out.println(Arrays.toString(index));
				count++;
			}
			visted = new boolean[5];
			return;
		}
		if (in == 12) {
			return;
		}
		for (int i = 0; i <= a[in]; i++) {
			c[in] = i;
			f(in + 1);
		}

	}

	static void set(int[] c) {
		int k = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] == 1) {
				index[k++] = i + 1;
			}
		}
	}

	static int sum(int[] c) {
		int sum = 0;
		for (int i : c) {
			sum += i;
		}
		return sum;
	}
}
