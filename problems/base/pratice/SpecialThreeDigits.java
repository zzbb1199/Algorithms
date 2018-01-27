package problems.base.pratice;
/**
 * 特殊三位數
 * @author 张兴锐
 *
 */
public class SpecialThreeDigits {
	public static void main(String[] args) {
		for(int i = 100;i<=999;i++) {
			if(check(i)) {
				System.out.println(i);
			}
		}
	}
	private static boolean check(int k) {
		String str = String.valueOf(k);
		int sum = 0;
		for(int i = 0;i<str.length();i++) {
			sum+= Math.pow((str.charAt(i) -'0'),3);
		}
		if(sum == k) {
			return true;
		}
		return false;
	}
}
