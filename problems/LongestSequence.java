package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * 求解最长子序列的长度
 * 求解最长子序列有哪些
 *
 */
public class LongestSequence {
	public static void main(String[] args) {
		hisMothod();
		myMothod();
	}

	public static void hisMothod() {
		System.out.println("hismothod");
		long time1 = System.currentTimeMillis();
		System.out.println("结果:"+f("gfdafagegefeafdsga","adsffagea"));
		long time2 = System.currentTimeMillis();
		System.out.println("耗时："+(time2-time1));
	}

	public static void myMothod() {
		System.out.println("mymethod");
		long time1 = System.currentTimeMillis();
		f("abcxyz","xyzabc",0,0);
		System.out.println("结果:"+bestmax);
		long time2 = System.currentTimeMillis();
		System.out.println("耗时："+(time2-time1));
		System.out.println("子串为:");
		for (String string : record) {
			System.out.println(string);
		}
	}
	/**
	 * 自己写的，效率稍高一点，空间消耗大，但是可求子串为多少
	 */
	static int bestmax = 0;
	static int currentmax = 0;
	static String bestStr = "";
	static String currentStr = "";
	static List<String> record = new ArrayList<>();
	public static void f(String s1,String s2,int k1,int k2) {
		if(bestmax <= currentmax) {//之所以加=号是因为可能存在多个相同长度的子串
			if(currentStr.length() != bestStr.length()) {//如果两个长度不等，则更新
				bestmax = currentmax;
				bestStr = currentStr;
				if(record.size() != 0) {
					record.remove(0);
				}
				record.add(bestStr);
			}else if(!currentStr.equals(bestStr)) {//如果两个长度相同，但字符串又不相等，
				record.add(currentStr);
			}

		}
		if(k1 == s1.length()) {
			return;
		}
		if(k2 == s2.length()) {
			return;
		}
		if(s1.charAt(k1) == s2.charAt(k2)) {//因为是字符所以可以使用==
			currentmax++;
			currentStr += s1.charAt(k1);
			f(s1,s2,k1+1,k2+1);
		}else {
			boolean flag = true;
			int tempmax = currentmax;
			String tempStr = currentStr;
			//如果不相等,s1不动，s2移动
			for(int i = k2+1;i<s2.length();i++) {
				if(s1.charAt(k1) == s2.charAt(i)) {
					flag  = false;
					currentmax++;
					currentStr += s1.charAt(k1);
					f(s1,s2,k1+1,i+1);
					currentmax--;
					currentStr.substring(0, currentStr.length()-1);
					break;
				}
			}
			currentmax = tempmax;//还原
			currentStr = tempStr;
			//s1动，s2不动
			for(int i = k1+1;i<s1.length();i++) {
				if(s1.charAt(i) == s2.charAt(k2)) {
					flag = false;
					currentmax++;
					currentStr += s2.charAt(k2);
					f(s1,s2,i+1,k2+1);
					currentmax--;
					currentStr.substring(0, currentStr.length()-1);
					break;
				}
			}
			if(flag) {
				f(s1,s2,k1+1,k2+1);
			}
		}
		
	}

	/**
	 * 递归教程,写法简单，耗时更大
	 */
	public static int f(String s1,String s2) {
		if(s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if(s1.charAt(0) == s2.charAt(0)) {
			return f(s1.substring(1),s2.substring(1))+1;
		}else {
			return Math.max(f(s1, s2.substring(1)),f(s1.substring(1),s2));
		}
	}
}
