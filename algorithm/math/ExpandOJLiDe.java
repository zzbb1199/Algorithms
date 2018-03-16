package algorithm.math;

/**
 * 扩展欧几里得
 * @author zxr
 * 97x+127y=1　
 */
public class ExpandOJLiDe {
	public static void main(String[] args) {
		int[] xy = new int[2];
		int a = 30;
		int b = 40;
		e_gcd(a,b,xy);
	}
	static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	/**
	 * @param a
	 * @param b
	 * @param xy
	 * @return
	 */
	static int e_gcd(int a,int b,int[] xy) {
		if(b == 0) {
			xy[0] = 1;
			xy[1]= 0;
			return a;
		}
		int res = e_gcd(b,a%b,xy);
		int t = xy[0];
		xy[0] = xy[1];
		xy[1] = t - a/b*xy[1];
		return res;
	}
	
}
