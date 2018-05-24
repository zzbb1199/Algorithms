package 国赛恢复训练.省赛2015;

public class Problem8_2 {
	/**
	 * 递归解法
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10000;
		f(n);
		System.out.println(count);
	}
	static long count = 0;
	public static void f(int current) {
		if(current < 3) {
			count+= current;
			return;
		}else {
			count+= current - current%3;
			f(current/3+current%3);
		}
	}
}
