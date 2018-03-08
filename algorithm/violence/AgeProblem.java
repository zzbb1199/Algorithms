package algorithm.violence;

import java.util.HashSet;
import java.util.Set;

/**
 * 美国数学家维纳(N.Wiener)智力早熟， 11 岁就上了大学。 他曾在 1935~1936 年应 邀来中国清华大学讲学。
 * 一次，他参加某个重要会议，年轻的脸孔引人注目。 于是 有人询问他的年龄，他回答说： “我年龄的立方是个 4 位数。我年龄的 4 次方是个 6 位数。这
 * 10 个数字正好包含了从 0 到 9 这 10 个数字，每个都恰好出现 1 次。 ” 请你推算一下，他当时到底有多年轻
 * 
 * @author zxr
 *
 */s
public class AgeProblem {
	public static void main(String[] args) {
		for (int i = 11; i <=100; i++) {
			String r1 = Integer.toString((int)Math.pow(i, 3));
			String r2 = Integer.toString((int)Math.pow(i, 4));
			if (r1.length() == 4 && r2.length() == 6) {
				String r = r1 + r2;
				if (check(r)) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	private static boolean check(String r) {
		// TODO Auto-generated method stub
		Set<Character> sets = new HashSet<Character>();
		for(int i = 0;i<r.length();i++) {
			sets.add(r.charAt(i));
		}
		if(sets.size() == 10) {
			return true;
		}
		return false;
	}
}
