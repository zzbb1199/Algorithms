package 国赛恢复训练.算法复习;
/**
 * 最大公约数，欧几里得
 * 最小公倍数
 * @author Raven
 *
 */
public class Problem8 {
	public static void main(String[] args) {
		System.out.println(gcd(10,5));
		System.out.println(10*5/gcd(10,5));
	}
	public static int gcd(int a,int b) {
		if(b == 0) {
			return a;
		}
		return gcd(b,a%b);
	}
}
