package problems;

import java.util.LinkedList;
import java.util.List;

/**
 * 最长公共子串
 * 给定两个字符串，找出两个字符串的最长公共子串
 * @author Raven
 *
 */
public class LongestSubstring {

	static int current;
	static int best;
	static StringBuilder currentStr;
	static List<String> record = new LinkedList<>();
	public static void main(String[] args) {
		String str1 = "abcefg123415341234";
		String str2 = "efgabc413151231234";
		for (int i = 0; i < str1.length()-best; i++) {
			for(int j = 0;j<str2.length()-best;j++) {
				if(str1.charAt(i) == str2.charAt(j)) {
					//从该点向后扫描
					current = 1;
					currentStr = new StringBuilder();
					currentStr.append(str1.charAt(i));
					int k1 = i+1;
					int k2 = j+1;
					while(k1 < str1.length() && k2 < str2.length() && str1.charAt(k1) == str2.charAt(k2)) {
						current++;
						currentStr.append(str1.charAt(k1));
						k1++;
						k2++;
					}
					if(best < current) {
						record.clear();
						record.add(currentStr.toString());
						best = current;
					}else if(best == current) {
						record.add(currentStr.toString());
					}
					j = k2-1;
				}
			}
		}
		//outPut
		System.out.println("最长公共子序列长度为:"+best);
		for (String string : record) {
			System.out.println(string);
		}
	}
	

}
