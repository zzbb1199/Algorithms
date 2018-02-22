package problems;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * @author zxr
 *
 */
public class Test {

	public static void main(String[] args) {
		BigInteger big1 = new BigInteger("20100122201001221234567890");
		BigInteger big2 = new BigInteger("2010012220100122");
		System.out.println(big1.add(big2));
	}

}
