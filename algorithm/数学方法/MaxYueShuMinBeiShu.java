<<<<<<< HEAD
package algorithm.math;
/**
 * 最大公约和最小公倍数
 * @author zxr
 *
 */
public class MaxYueShuMinBeiShu {
	public static void main(String[] args) {
		System.out.println(gcd(6,10));
		System.out.println(lcm(6,10));
	}
	/**
	 * 欧几里得　辗转相除法
	 * @return
	 */
	
	static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	/**
	 * 最小公倍数 a*b/gcd(a,b)
	 * @param a
	 * @param b
	 * @return
	 */
	static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
	
}
=======
package algorithm.math;
/**
 * 最大公约和最小公倍数
 * @author zxr
 *
 */
public class MaxYueShuMinBeiShu {
	public static void main(String[] args) {
		System.out.println(gcd(6,10));
		System.out.println(lcm(6,10));
	}
	/**
	 * 欧几里得　辗转相除法
	 * @return
	 */
	
	static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
	/**
	 * 最小公倍数 a*b/gcd(a,b)
	 * @param a
	 * @param b
	 * @return
	 */
	static int lcm(int a,int b) {
		return a*b/gcd(a,b);
	}
	
}
>>>>>>> master
