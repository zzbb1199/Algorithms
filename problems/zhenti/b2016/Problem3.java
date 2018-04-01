package problem.zhenti.b2016;

import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * 高精度问题，采用BigDecimal无法解决
 * @author 张兴锐
 *
 */
public class Problem3 {
	public static void main(String[] args) {
		deep(0);
	}

	static int count;
	static boolean[] visted = new boolean[9];
	static BigDecimal[] bg = new BigDecimal[9];// 高精度

	static void deep(int index) {
		if (index == 9) {
			// 检验
			if (check()) {
				count++;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (!visted[i]) {
				visted[i] = true;
				bg[i] = new BigDecimal(i + 1);
				deep(index + 1);
				visted[i] = false;
			}
		}
	}

	private static boolean check() {
		BigDecimal up = bg[3].multiply(new BigDecimal(100))
				.add(bg[4].multiply(new BigDecimal(10))).add(bg[5]);
		BigDecimal down = bg[6].multiply(new BigDecimal(100))
				.add(bg[7].multiply(new BigDecimal(10))).add(bg[8]);

		if (bg[0].add(bg[1].divide(bg[2],10,RoundingMode.HALF_DOWN)).add(up.divide(down,10,RoundingMode.HALF_DOWN))
				== new BigDecimal(10)) {
			return true;
		}
		return false;
	}
}
