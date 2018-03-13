package algorithm.recursion.prebiew;

import java.util.HashSet;
import java.util.Set;

public class PuKeProblem {
	static Set<String> sets = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String origin = "AA223344";
		deep(origin.toCharArray(), 0);
		for (String string : sets) {
			System.out.println(string);
		}
	}

	public static void deep(char[] c, int index) {
		if (index == c.length) {
			// 检验输出
			if (check(c)) {
				String str = ""+c[0] + c[1] + c[2] + c[3] + c[4] + c[5] + c[6] + c[7];
				sets.add(str);
				return;
			}
		}
		for (int i = index; i < c.length; i++) {
			if(index != i && c[index] == c[i]) {
				continue;
			}
			char t = c[index];
			c[index] = c[i];
			c[i] = t;
			deep(c, index + 1);
			t = c[index];
			c[index] = c[i];
			c[i] = t;
		}
	}

	private static boolean check(char[] c) {
		// TODO Auto-generated method stub
		// 恢复称字符串
		String str = ""+c[0] + c[1] + c[2] + c[3] + c[4] + c[5] + c[6] + c[7];
		// 采用正则表达式进行匹配
		// A检验
		if (str.replaceAll("A(.*)A", "AA").length() != c.length - 1) {// 因为AA之间只有一个元素
			return false;
		}
		// 2检验
		if (str.replaceAll("2.*2", "22").length() != c.length - 2) {
			return false;
		}
		// 3检验
		if (str.replaceAll("3.*3", "33").length() != c.length - 3) {
			return false;
		}
		// 4检验
		if (str.replaceAll("4.*4", "44").length() != c.length - 4) {
			return false;
		}
		return true;
	}

}
