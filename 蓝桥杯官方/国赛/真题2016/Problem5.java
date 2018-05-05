package 蓝桥杯官方.国赛.真题2016;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String tex = "AAAA"; String regex = "AAA"; Pattern p =
 * Pattern.compile(regex); Matcher m = p.matcher(tex); while(m.find()){
 * Systinem.out.println(m.group()); System.out.println(m.start());
 * m.region(m.start()+1, tex.length());
 * 
 * }
 * 
 * @author zxr
 * 
 */
public class Problem5 {
	static int n, m, k;
	static String[] in;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		k = input.nextInt();
		in = new String[n];
		for (int i = 0; i < n; i++) {
			in[i] = input.next();
		}

		for (int i = 0; i <= n - m; i++) {
			for (int start = 0; start <= in[i].length() - k; start++) {
				f(1, i + 1, in[i].substring(start, start + k));
			}
		}
		System.out.println(count);
	}

	static int count;

	public static void f(int compared, int level, String regex) {
		if (level == n) {
			return;
		}
		if (compared == m) {
			count = (count + 1) % 1000000007;
			return;
		}
		for (int start = 0; start <= in[level].length() - k; start++) {
			Matcher ma = Pattern.compile(regex).matcher(
					in[level].substring(start));
			if (ma.lookingAt()) {
				f(compared + 1, level + 1, regex);
				if (level + 1 == n && compared + 1 == m) {
					count = (count + 1) % 1000000007;
				}
			}
		}
		f(compared, level + 1, regex);

	}
}
