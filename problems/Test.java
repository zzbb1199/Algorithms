package problems;

import java.io.IOException;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * 
 * @author zxr
 *
 */
/*
 * JAVA中的无穷大和NaN的构造方法
 */
public class Test {

	public static void main(String[] args) {
		// 筛选
//		int target = 10002;
//		int N = target * 100;
//		BigInteger[] origin = new BigInteger[N];
//		for (int i = 0; i < origin.length; i++) {
//			origin[i] = new BigInteger(""+(i+2));
//		}
//		int temp = 0;
//		for (int i = 0; i < N; i++) {
//			if (origin[i].equals(BigInteger.ZERO)) {
//				continue;
//			} else {
//				temp++;
//				if (temp == target) {
//					System.out.println(origin[i]);
//					return;
//				}
//				for(int p = i+1;p<N;p++) {
//					if(origin[p].mod(origin[i]).equals(BigInteger.ZERO)) {
//						origin[p] = BigInteger.ZERO;
//					}
//				}
//			}
//		}
		BigInteger prim = new BigInteger("1");
		for(int i = 1;i<=10002;i++) {
			prim = prim.nextProbablePrime();
		
		}
		System.out.println(prim);
	}
}
