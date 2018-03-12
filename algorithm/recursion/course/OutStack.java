package algorithm.recursion.course;

public class OutStack {

	
	public static void main(String[] args) {
			System.out.println(f(3,0));
	}
	/**
	 * 
	 * @param n 等待进站
	 * @param m 已经进站
	 * @return
	 */
	public static int f(int n,int m) {
		if(n == 0) {
			return 1;
		}
		if(m == 0) {
			return f(n-1,1);
		}
		return f(n-1,m+1)	+	f(n,m-1);
	}
	
}
