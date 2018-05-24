package 国赛恢复训练.算法复习;

import java.math.BigInteger;


public class Problem10 {
	public static void main(String[] args) {
		BigInteger a = BigInteger.ONE;
		for(int i = 1;i<=10002;i++) {
			a = a.nextProbablePrime();	
		}
		System.out.println(a);
	}
}
