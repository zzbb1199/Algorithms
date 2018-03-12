package algorithm.recursion.course;

/**
 * 找零钱
 * 
 * @author zxr
 *
 */
public class ChangeProblem {
	public static void main(String[] args) {
		int n = 1;
		int m = 2;
		System.out.println(f(n, m));
		System.out.println(f(n, m, 0));
	}

	/**
	 * 从后往前追溯
	 * 
	 * @param n
	 *            持有1元的
	 * @param m
	 *            持有5角的
	 * @return 当前队列有多少种可能的解法
	 */
	public static int f(int n, int m) {
		if (m < n) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		return f(n - 1, m) + f(n, m - 1);
	}

	public static int f(int n, int m, double sum) {
		if (sum < 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		if (m == 0) {
			return f(n - 1, 0, sum-0.5);
		}
		// 当前位置排列1
		int count = f(n - 1, m, sum - 0.5);
		//当前位置排0
		return count + f(n, m - 1, sum + 0.5);
	}
}
