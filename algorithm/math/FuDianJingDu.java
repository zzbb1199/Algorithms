package algorithm.math;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * 精度问题
 * 
 * @author zxr
 *
 */
public class FuDianJingDu {
	private static int count;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] o = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		deep(0, o);
		System.out.println(count);
	}

	public static void deep(int index, char[] o) {
		if (index == 9) {
			if (check(o)) {
				count++;
			}
			return;
		}
		for (int i = index; i < 9; i++) {
			char t = o[index];
			o[index] = o[i];
			o[i] = t;
			deep(index + 1, o);
			t = o[index];
			o[index] = o[i];
			o[i] = t;
		}
	}

	private static boolean check(char[] o) {
		Ra A = new Ra(new BigInteger(o[0] + ""));
		Ra B = new Ra(new BigInteger(o[1] + ""), new BigInteger(o[2] + ""));
		Ra C = new Ra(new BigInteger("" + o[3] + o[4] + o[5]), new BigInteger(
				"" + o[6] + o[7] + o[8]));
		if (A.add(B).add(C).equals(new Ra(new BigInteger("10")))) {
			System.out.println(A);
			System.out.println(B);
			System.out.println(C);
			System.out.println();
			return true;
		}
		return false;
	}

	static class Ra {
		BigInteger[] num = { BigInteger.ZERO, BigInteger.ONE };

		/**
		 * 构造函数
		 */
		public Ra() {
		}

		public Ra(BigInteger numerator, BigInteger denominator) {
			BigInteger c = gcd(numerator, denominator);
			num[0] = numerator.divide(c);
			num[1] = denominator.divide(c);
		}

		public Ra(BigInteger numerator) {
			this(numerator, BigInteger.ONE);
		}

		/**
		 * 求解最大公约数
		 * 
		 * @param a
		 * @param b
		 * @return
		 */
		public BigInteger gcd(BigInteger a, BigInteger b) {
			if (b.equals(BigInteger.ZERO)) {
				return a;
			}
			return gcd(b, a.remainder(b));
		}

		/**
		 * 四则运算
		 */
		public Ra add(Ra b) {
			BigInteger numerator = this.num[0].multiply(b.num[1]).add(
					this.num[1].multiply(b.num[0]));
			BigInteger denominator = this.num[1].multiply(b.num[1]);
			return new Ra(numerator, denominator);
		}

		public Ra subtract(Ra b) {
			return add(negate(b));
		}

		public Ra multiply(Ra b) {
			return new Ra(this.num[0].multiply(b.num[0]),
					this.num[1].multiply(b.num[1]));
		}

		public Ra divide(Ra b) throws Exception {
			if (b.equals(BigInteger.ZERO)) {
				throw new Exception("分母为0");
			}
			return new Ra(this.num[0].multiply(b.num[1]),
					this.num[1].multiply(b.num[0]));
		}

		/**
		 * 其他运算
		 */
		public Ra negate(Ra b) {
			b.num[0] = b.num[0].negate();
			return b;
		}

		public boolean equals(Ra b) {
			if (this.subtract(b).num[0].equals(BigInteger.ZERO)) {
				return true;
			}
			return false;
		}

		public String toString() {
			String str = "";
			if (this.num[1].equals(BigInteger.ONE)) {
				str = num[0] + "";
			} else {
				str = num[0] + "/" + num[1];
			}
			return str;

		}
	}
}
