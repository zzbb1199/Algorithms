package 测试;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String testStr = "I can have a cat";
		String regex = "\\s?(\\w+)\\s?";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(testStr);
		while (m.find()) {
			System.out.println(m.group(1));
		}
		System.out.println(-2 ^ 0);
		System.out.println(-2 ^ 1);
		System.out.println(2 ^ 0);
		System.out.println(2 ^ 1);
		String test = "1231242a21";
		System.out.println(test.matches("\\d+"));
		System.out.println(Integer.MAX_VALUE > 1000000007);
		System.out.println(new BigInteger(0 + "").add(new BigInteger(2 + "")));
	}
}
