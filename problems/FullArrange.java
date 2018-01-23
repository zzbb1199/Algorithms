package problems;

import java.util.Arrays;

/**
 * 求解全排列
 * 
 * @author zxr
 *
 */
public class FullArrange {
	// 用于装解
	static char[] p;
	static boolean[] visted;

	public static void main(String[] args) {
		// 给定一个数组
		char[] datas = "abcdef".toCharArray();
		p = new char[datas.length];
		visted = new boolean[datas.length];
		f(datas,0);
	}
	public static void f(char[] datas, int k) {
		if(k == datas.length) {
			//说明已经到头了
			System.out.println(Arrays.toString(p));
		}
		for (int i = 0; i < datas.length; i++) {
			if (!visted[i]) {
				visted[i] = true;
				p[k] = datas[i];
				f(datas,k+1);
				visted[i] = false;//还原
			}
		}
	}
}
