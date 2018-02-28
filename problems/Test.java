package problems;

import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
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
		double x = 1.245;
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		String reuslt= df.format(x);
		System.out.println(reuslt);
		System.out.println(String.format("%.2f", x));

	}

}
