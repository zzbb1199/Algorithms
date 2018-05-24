package 蓝桥杯官方.国赛.真题2016;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem6 {

	static int n, m;
	static List<People> roots = new ArrayList<People>();
	static int[][] opr;
	static Map<Integer, People> maps = new HashMap<Integer, People>();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		People pl0 = new People(1, new BigInteger(input.nextInt() + ""),
				new BigInteger(input.nextInt() + ""));
		maps.put(1, pl0);
		boolean[] visted = new boolean[n];
		People pl = null;
		for (int i = 1; i < n; i++) {
			pl = new People(i + 1, new BigInteger(input.nextInt() + ""),
					new BigInteger(input.nextInt() + ""));
			maps.put(i + 1, pl);
			// 生成双链表
			People end = getEnd(pl0, visted);
			visted = new boolean[n];
			pl.left = end;
			end.right = pl;
		}

		// 连城环
		pl.right = pl0;
		pl0.left = getEnd(pl0, visted);
		// 操作初始化
		m = input.nextInt();
		opr = new int[m][3];
		for (int i = 0; i < m; i++) {
			opr[i][0] = input.nextInt();
			opr[i][1] = input.nextInt();
			opr[i][2] = input.nextInt();
		}
		for (int i = 0; i < m; i++) {
			opr(i);
		}
	}

	public static void opr(int row) {
		int k = opr[row][0];
		switch (k) {
		case 1:// 交换
			swap(opr[row][1], opr[row][2]);
			calclulcate();
			break;
		case 2:// 重新赋值Hi
			getPeople(opr[row][1]).Hi = new BigInteger(opr[row][2] + "");
			calclulcate();
			break;
		case 3:// 重新赋值Fi
			getPeople(opr[row][1]).Fi = new BigInteger(opr[row][2] + "");
			calclulcate();
			break;
		}
	}

	public static void swap(int i1, int i2) {
		People p1 = getPeople(i1);
		People p2 = getPeople(i2);
		if (p1.right == p2 || p2.right == p1) {// 相邻不交换
			return;
		}
		People p3 = p1.right;
		People p4 = p2.left;

		p3.left = p4;
		p4.right = p3;

		p1.right = p2;
		p2.left = p1;
	}

	public static void calclulcate() {
		// 计算新圈value
		// 得到多个子圈及找到一个圈的任一节点
		boolean[] visted = new boolean[n];
		List<Integer> subnum = new ArrayList<Integer>();
		roots.clear();

		for (int i = 0; i < n; i++) {
			if (!visted[i]) {
				List<Integer> num = new ArrayList<Integer>();
				People root = getPeople(i + 1);
				roots.add(root);
				subnum.add(dfs(root, visted));
			}
		}
		BigInteger sum = new BigInteger(0 + "");
		for (int i = 0; i < roots.size(); i++) {
			People p = roots.get(i);
			int t = subnum.get(i);
			for (int delta = 1; delta < t; delta++) {
				sum = sum.add(new BigInteger((t - delta) + "").multiply(p.Hi)
						.multiply(p.Fi));
			}
			p = p.right;
			while (p != roots.get(i)) {
				for (int delta = 1; delta < t; delta++) {
					sum = sum.add(new BigInteger((t - delta) + "").multiply(
							p.Hi).multiply(p.Fi));
				}
				p = p.right;
			}

		}
		System.out.println(sum);
	}

	private static int dfs(People root, boolean[] visted) {
		if (visted[root.number - 1]) {
			return 0;
		}
		visted[root.number - 1] = true;
		return 1 + dfs(root.right, visted);
	}

	public static People getPeople(int num) {
		return maps.get(num);
	}

	public static People getEnd(People root, boolean[] visted) {
		if (root.right == null || visted[root.number - 1]) {
			return root;
		}
		visted[root.number - 1] = true;
		return getEnd(root.right, visted);
	}

	static class People {
		int number;
		BigInteger Hi;
		BigInteger Fi;
		People left;
		People right;

		public People(int n, BigInteger hi, BigInteger fi) {
			number = n;
			Hi = hi;
			Fi = fi;
		}

	}
}
