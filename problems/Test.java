package problems;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * @author zxr
 *
 */
public class Test {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		String b = input.nextLine();
		input.close();
		BigInteger big1 = new BigInteger(a);
		BigInteger big2 = new BigInteger(b);
		System.out.println(big1.add(big2));
	}

}
