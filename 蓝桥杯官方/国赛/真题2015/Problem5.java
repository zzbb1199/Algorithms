package 蓝桥杯官方.国赛.真题2015;

import java.util.Scanner;

public class Problem5 {
	static int m;
	static int n;
	static final int SUM = 1;
	static final int AVG = 2;
	static final int STD = 3;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		m = input.nextInt();
		n = input.nextInt();
		Cell[][] cells = new Cell[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				String in = input.next();
				if (in.matches("\\d+")) {
					cells[i][j] = new Cell(Float.valueOf(in));
				} else {
					String opr = in.substring(0, 3);
					try {
						int fx = Integer.valueOf(in.substring(
								in.indexOf("(") + 1, in.indexOf(","))) - 1;
						int fy = Integer.valueOf(in.substring(
								in.indexOf(",") + 1, in.indexOf(":"))) - 1;
						int tx = Integer.valueOf(in.substring(
								in.indexOf(":") + 1, in.lastIndexOf(","))) - 1;
						int ty = Integer.valueOf(in.substring(
								in.lastIndexOf(",") + 1, in.indexOf(")"))) - 1;
						int Op = -1;
						if (opr.equals("SUM")) {
							Op = SUM;
						} else if (opr.equals("AVG")) {
							Op = AVG;
						} else {
							Op = STD;
						}
						cells[i][j] = new Cell(fx, fy, tx, ty, Op);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				opr(cells[i][j], cells);
			}
		}
		// 输出
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n - 1; j++) {
				System.out
						.print(String.format("%.2f", cells[i][j].value) + " ");
			}
			System.out.println(String.format("%.2f", cells[i][n - 1].value));
		}

	}

	public static double opr(Cell c, Cell[][] cells) {
		double result = 0.0f;
		if (c.type == 0) {
			return c.value;
		} else {
			switch (c.opr) {
			case SUM:
				for (int i = c.fx; i <= c.tx; i++) {
					for (int j = c.fy; j <= c.ty; j++) {
						Cell next = cells[i][j];
						if (next.type == 0) {
							result += next.value;
						} else {
							result += opr(next, cells);
						}
					}
				}
				break;
			case AVG:
				for (int i = c.fx; i <= c.tx; i++) {
					for (int j = c.fy; j <= c.ty; j++) {
						Cell next = cells[i][j];
						if (next.type == 0) {
							result += next.value;
						} else {
							result += opr(next, cells);
						}
					}
				}
				result = result
						/ (((Math.abs(c.ty - c.fy) + 1) * (Math
								.abs(c.tx - c.fx) + 1)));
				break;
			case STD:
				for (int i = c.fx; i <= c.tx; i++) {
					for (int j = c.fy; j <= c.ty; j++) {
						Cell next = cells[i][j];
						if (next.type == 0) {
							result += next.value;
						} else {
							result += opr(next, cells);
						}
					}
				}
				int nums = (((Math.abs(c.ty - c.fy) + 1) * (Math.abs(c.tx
						- c.fx) + 1)));
				double averge = result / nums;
				result = 0.0f;
				for (int i = c.fx; i <= c.tx; i++) {
					for (int j = c.fy; j <= c.ty; j++) {
						result += Math.pow((cells[i][j].value - averge), 2);
					}
				}
				result = result / nums;
				result = Math.sqrt(result);
				break;
			default:
				break;
			}
		}
		c.value = result;
		c.type = 0;
		return result;
	}

	static class Cell {
		double value;
		int type; // 表明是数值还是公式 0 数值,1公式
		int fx, fy, tx, ty;
		int opr; // 1 sum 2 avd 3 std

		public Cell(double value) {
			super();
			this.type = 0;
			this.value = value;
		}

		public Cell(int fx, int fy, int tx, int ty, int opr) {
			super();
			this.type = 1;
			this.fx = fx;
			this.fy = fy;
			this.tx = tx;
			this.ty = ty;
			this.opr = opr;
		}

	}

}
