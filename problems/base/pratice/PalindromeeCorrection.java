package problems.base.pratice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * 　回文串，是一种特殊的字符串，它从左往右读和从右往左读是一样的。小龙龙认为回文串才是完美的。现在给你一个串，它不一定是回文的，请你计算最少的交换次数使得该串变成一个完美的回文串。
　　交换的定义是：交换两个相邻的字符
　　例如mamad
　　第一次交换 ad : mamda
　　第二次交换 md : madma
　　第三次交换 ma : madam (回文！完美！)
	输入格式
　　第一行是一个整数N，表示接下来的字符串的长度(N <= 8000)
　　第二行是一个字符串，长度为N.只包含小写字母
	输出格式
　　如果可能，输出最少的交换次数。
　　否则输出Impossible
 */
public class PalindromeeCorrection {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		input.nextLine();
		String originStr = input.nextLine();
		input.close();
		int count = 0;
		char[] str = originStr.toCharArray();
		// step1 判定是否有可能成为回文数
		if (mayBe(originStr)) {
			// 偶数列
			boolean confirm = false;
			for (int i = 0; i < N / 2; i++) {
				if (str[i] == str[N - i - 1]) {
					continue;
				} else {
					// 从右向左查找
					boolean iscenter = true;
					for (int j = N - 1 -i; j > i; j--) {
						if (str[i] == str[j]) {
							iscenter = false;
							// 查找到位置,依次 向右交换
							for (int k = j; k < N - i - 1; k++) {
								char c = str[k];
								if(confirm && k+1 == N/2) {
									k++;
									str[k-1] = str[k+1];
								}else {
									str[k] = str[k + 1];
								}
								str[k + 1] = c;
								count++;
							}
							break;
						}
					}
					if(!confirm && iscenter) {
						confirm = true;
						//该字符是中心字符
						for(int k = i;k<N/2;k++) {
							char c = str[k];
							str[k] = str[k+1];
							str[k+1] = c;
							count++;
						}
						i--;
					}
				}
			}
			System.out.println(count);
		} else {
			System.out.println("Impossible");
		}
	}

	public static boolean mayBe(String str) {
		Map<Character, Integer> countMap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (countMap.containsKey(str.charAt(i))) {
				countMap.put(str.charAt(i), countMap.get(str.charAt(i)) + 1);
			} else {
				countMap.put(str.charAt(i), 1);
			}
		}
		int oddNum = 0;
		for (char c : countMap.keySet()) {
			int count = countMap.get(c);
			if (count % 2 == 0) {
			} else if (count %2 == 1) {
				oddNum++;
			} 
		}
		if (str.length() % 2 == 0) {
			// 偶数长度
			if (oddNum != 0 ) {
				return false;
			}
		} else {
			if (oddNum != 1) {
				return false;
			}
		}
		return true;
	}
}
