package problems;

public class Combination {

	/**
	 * 组合问题，给定n和m求解Cn,m
	 * @param args
	 */
	
	public static void main(String[] args) {
		System.out.println(c1(10,3));
		System.out.println(c2(10,3));
	}
	/**
	 * 方法一-选择一个球作为中间点，那么全局剩余两种情况：
	 * 有这个球，则Cn-1,m-1
	 * 无这个球，则Cn-1,m
	 * 其实中学也有这个公式，不过理解了在使用更容易
	 */
	public static int c1(int n,int m) {
		if(m == 0) {
			return 1;
		}
		if (n == m) {
			return 1;
		}
		return c1(n-1,m-1)+c1(n-1,m);
	}
	/**
	 * 方法二-先求排列，在消除多余的。
	 */
	public static int c2(int n,int m) {
		return a(n,m)/a(m,m);
	}
	public static int a(int n,int m) {
		if(m==1) {
			return n;
		}
		if(m == 0) {
			return 1;
		}
		return a(n,1)*a(n-1,m-1);
	}

}
