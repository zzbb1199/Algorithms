package problems.base.pratice;

/**
 * 求所有四位回文数
 * 
 * @author 张兴锐
 *
 */
public class PalindromeNumber {
	public static void main(String[] args) {
		for(int i = 1000;i<=9999;i++) {
			if(check(i)) {
				System.out.println(i);
			}
		}
	}

	private static boolean check(int k) {
		String str = String.valueOf(k);
		int length = str.length();
		for(int i = 0;i<length/2;i++) {
			if(str.charAt(i) != str.charAt(length - 1 -i)){
				return false;
			}
		}
		return true;
	}
}
