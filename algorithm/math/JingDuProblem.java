package algorithm.math;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 精度问题 BigDecimal
 * @author zxr
 *
 */
public class JingDuProblem {
	//NaN和INF的表示方法
	public static final double INF = 1.0/0.0;
	public static final double NAN = 0.0/0.0;
	public static void main(String[] args) {
		BigDecimal a = new BigDecimal(1);
		BigDecimal b = new BigDecimal(6);
		System.out.println(a.divide(b,new MathContext(100,RoundingMode.FLOOR)));
	}
}
