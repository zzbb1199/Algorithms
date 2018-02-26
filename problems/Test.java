package problems;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * @author zxr
 *
 */
public class Test {

	public static void main(String[] args) {
		String y = "00000727";
		String x = "0000021b";
		System.out.println(Integer.valueOf(x,16));
		System.out.println(Integer.valueOf(y, 16));
		String a = "er qian er bai ling ling  ";
		Pattern p = Pattern.compile("(ling\\s)\\1+\\s$");
		Matcher m = p.matcher(a);
		System.out.println(m.find());
		System.out.println(m.replaceAll("$1"));

	}

}
