package 国赛恢复训练.省赛2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem9_2 {

	/**
	 * 暴力破解显然不够，选择DP求解 状态D(i,j) 表示第i层地面为j时可选择的方案数
	 * 
	 * @author 张兴锐
	 *
	 */
	static long count = 0;
	static int[] duimian = { 0, 4, 5, 6, 1, 2, 3 };
	static Map<Integer, List<Integer>> paichi = new HashMap<Integer, List<Integer>>();
	static int n;
	static int[][] D;
	static int rem = (int) (1E9 + 7);// java科学计数法生成的是double。求余操作把余数写出来

	public static void main(String[] args) {
		// 初始化
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		int m = input.nextInt();
		D = new int[n + 1][7];// 免得换算，空间一般都是够的。
		for (int i = 0; i < m; i++) {
			int m1 = input.nextInt();
			int m2 = input.nextInt();
			if (paichi.containsKey(m1)) {
				paichi.get(m1).add(m2);
			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(m2);
				paichi.put(m1, list);
			}
			if (paichi.containsKey(m2)) {
				paichi.get(m2).add(m1);

			} else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(m1);
				paichi.put(m2, list);
			}
		}
		input.close();
		// DP
		// 初始化
		for (int i = 1; i <= 6; i++) {
			D[1][i] = 1;
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= 6; j++) {
				List<Integer> list = init();
				// 得到禁忌表
				List<Integer> forbid = paichi.get(j);
				int sum = 0;
				if (forbid == null) {
					for (int k = 1; k <= 6; k++) {
						sum = add(sum, D[i - 1][k]);
					}
				} else {
					list.removeAll(forbid);
					for (Integer v : list) {
						sum = add(sum, D[i - 1][duimian[v]]);
					}
				}
				D[i][j] = sum;
			}
		}
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			sum = add(sum, D[n][i]);
		}
		System.out.println((sum * Math.pow(4, n) % (rem)));
	}

	public static List<Integer> init() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		return list;
	}

	public static int add(int base, int added) {
		return (base % rem + added % rem) % rem;
	}
}
