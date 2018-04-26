package problems.base.pratice;

import java.util.Scanner;

/**
 * 十进制转换到十六进制
 * @author zxr
 *
 */
public class DecimToHex {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String decim = input.nextLine();
		input.close();
		System.out.println(Integer.toHexString(Integer.valueOf(decim)).toUpperCase());
	}
}
