package problems;

import java.math.BigInteger;
import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * @author zxr
 *
 */
public class Test {

	public static void main(String[] args) throws ParseException {
		double x = 1.245;
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		String reuslt= df.format(x);
		System.out.println(reuslt);
		System.out.println(String.format("%.2f", x));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse("2018-03-04");
		System.out.println(date.toLocaleString());
		
		int[][] a = {
				{9,7,2},
				{1 ,5 ,4},
				{6 ,3 ,8}
		};
		check(a);

	}
	private static boolean check(int[][] a) {
		// 计算行
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += a[0][i];
		}
		int temp = 0;
		for (int i = 1; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp += a[i][j];
			}
			if (sum != temp) {
				return false;
			}
			temp = 0;
		}
		// 计算列
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				temp += a[i][j];
			}
			if (sum != temp) {
				return false;
			}
			temp = 0;
		}
		// 计算对角线
		temp = a[0][0] + a[1][1] + a[2][2];
		if (temp != sum) {
			return false;
		}
		return true;
	}

}
