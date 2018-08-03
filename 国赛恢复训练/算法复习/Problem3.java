package 国赛恢复训练.算法复习;

import java.util.Arrays;

/**
 * 全排列
 * @author Raven
 *
 */
public class Problem3 {
	static int count = 0;
	public static void main(String[] args) {
		String origin = "ABCDEF";
		f(origin.toCharArray(),0);
		System.out.println(count);
		}
	
	public static void f(char[] c,int index) {
		if(index == c.length) {
			count++;
			System.out.println(Arrays.toString(c));
			return;
		}
		for(int i = index;i<c.length;i++) {
			{char t = c[index];c[index] = c[i];c[i] = t;}
			f(c,index+1);
			{char t = c[index];c[index] = c[i];c[i] = t;}
		}
	}
}
