package 国赛恢复训练.算法复习;

import java.math.BigInteger;

/**
 * 无损失有理数计算
 * @author 张兴锐
 *
 */
public class Problem9 {
	public static void main(String[] args) {
		Ra sum = new Ra(BigInteger.ZERO);
		for(int i = 2;i<=100;i++) {
			sum.add(new Ra(BigInteger.ONE,new BigInteger(i+"")));
		}
		System.out.println(sum);
	}
	
	
	
	private static class Ra{
		BigInteger fenzi;
		BigInteger fenmu;
		public Ra(BigInteger fenzi, BigInteger fenmu) {
			super();
			BigInteger c = gcd(fenzi,fenmu);//BigInteger自带了有gcd函数，不过自己学会写还是非常有用的
			this.fenzi = fenzi.divide(c);
			this.fenmu = fenmu.divide(c);
		}
		public Ra(BigInteger fenzi) {
			this(fenzi,BigInteger.ONE);
		}

		BigInteger gcd(BigInteger a, BigInteger b) {
			if(b.equals(BigInteger.ZERO)) {
				return a;
			}
			return gcd(b,a.mod(b));
		}
		/**
		 * 定义加减乘除
		 */
		void add(Ra b) {
			Ra n = new Ra(this.fenzi.multiply(b.fenmu).add(this.fenmu.multiply(b.fenzi)),this.fenmu.multiply(b.fenmu));
			this.fenzi = n.fenzi;
			this.fenmu = n.fenmu;
		}
		/**
		 *
		 */
		void subtract(Ra b) {
			b.fenzi = b.fenzi.negate();
			add(b);
		}
		void mutiply(Ra b) {
			Ra n = new Ra(this.fenzi.multiply(b.fenzi),this.fenmu.multiply(b.fenmu));
			this.fenzi = n.fenzi;
			this.fenmu = n.fenmu;
		}
		void divide(Ra b) throws Exception {
			if(b.fenzi.equals(BigInteger.ZERO)) {
				throw new Exception("分母错误");
			}
			Ra n = new Ra(this.fenzi.multiply(b.fenmu),this.fenmu.multiply(b.fenzi));
			this.fenzi = n.fenzi;
			this.fenmu = n.fenmu;
		}
		@Override
		public String toString() {
			if(this.fenmu.equals(BigInteger.ONE)) {
				return this.fenzi.toString();
			}else {
				return this.fenzi + "/"+this.fenmu;
			}
		}
		
	}
}
