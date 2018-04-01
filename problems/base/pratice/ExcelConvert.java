package problems.base.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExcelConvert {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		// 特殊26进制
		List<String> result = new ArrayList<>();
		int current = n;
		while (current != 0) {
			result.add(0, current % 26 + "");
			current /= 26;
		}
		String[] r = new String[result.size()];
		for (int i = 0; i < r.length; i++) {
			r[i] = result.get(i);
		}
		// 倒叙
		StringBuilder rx = new StringBuilder();
		for (int i = r.length - 1; i >= 0; i--) {
			if (r[i].equals("0")) {
				if (i != 0) {
					rx.append("Z");
					r[i - 1] = String.valueOf(Integer.valueOf(r[i - 1]) - 1);
				}
			} else {
				rx.append("" + (char) (Integer.valueOf(r[i]).intValue() - 1 + 'A'));
			}
		}
		System.out.println(rx.reverse());
	}
}
