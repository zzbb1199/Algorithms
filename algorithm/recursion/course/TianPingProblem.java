<<<<<<< HEAD
package algorithm.recursion.course;

import java.util.Scanner;

/**
 * 天平问题
 * 
 * @author zxr
 *
 */
public class TianPingProblem {
	static int[] w = { 81, 27, 9, 3, 1 };
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		deep(n, 0, 0);
		System.out.println(str.toString().replaceAll("\\s0\\s", "+").replaceAll("\\s1\\s", "-").substring(1));
	}

	/**
	 * 
	 * @param value
	 * @param index
	 * @param type
	 *            控制打印符号
	 */
	public static void deep(int value, int index, int c) {
		if (index == 5) {
			return;
		}
		if (value < w[index]) {
			// 判定是否可通过调节砝码来做
			if (value > w[index] / 2) {
				// 可通过调节
				str.append(" " + c + " " + w[index]);
				deep(w[index] - value, index + 1, c ^ 1);
			} else {
				deep(value, index + 1, c);
			}
			return;
		} else if (value > w[index]) {
			str.append(" " + c + " " + w[index]);
			deep(value - w[index], index + 1, c);
		} else if (value == w[index]) {
			str.append(" " + c + " " + w[index]);
		}
	}
}
=======
package algorithm.recursion.course;

import java.util.Scanner;

/**
 * 天平问题
 * 
 * @author zxr
 *
 */
public class TianPingProblem {
	static int[] w = { 81, 27, 9, 3, 1 };
	static StringBuilder str = new StringBuilder();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		deep(n, 0, 0);
		System.out.println(str.toString().replaceAll("\\s0\\s", "+").replaceAll("\\s1\\s", "-").substring(1));
	}

	/**
	 * 
	 * @param value
	 * @param index
	 * @param type
	 *            控制打印符号
	 */
	public static void deep(int value, int index, int c) {
		if (index == 5) {
			return;
		}
		if (value < w[index]) {
			// 判定是否可通过调节砝码来做
			if (value > w[index] / 2) {
				// 可通过调节
				str.append(" " + c + " " + w[index]);
				deep(w[index] - value, index + 1, c ^ 1);
			} else {
				deep(value, index + 1, c);
			}
			return;
		} else if (value > w[index]) {
			str.append(" " + c + " " + w[index]);
			deep(value - w[index], index + 1, c);
		} else if (value == w[index]) {
			str.append(" " + c + " " + w[index]);
		}
	}
}
>>>>>>> master
