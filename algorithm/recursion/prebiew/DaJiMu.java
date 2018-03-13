package algorithm.recursion.prebiew;

import java.util.Arrays;

/**
 * 搭积木
 * 
 * @author zxr
 *
 */
public class DaJiMu {
	static int[][] d = new int[4][4];
	static boolean[] visted = new boolean[10];
	static int sum ;
	public static void main(String[] args) {
		deep(0,0);
		System.out.println(sum);
	}

	/**
	 * 
	 * @param layer
	 *            第几层 0-3
	 * @param count
	 */
	public static void deep(int layer, int count) {
		//每一空均有可能为10个数字中的某一个
		for(int j = 0;j<10;j++) {
			if(!visted[j]) {
				visted[j] = true;
				d[layer][count] = j;
				/****************这里其实可以考虑剪枝，不过为了做题，时间第一啦********************/
				if(count+1 <= layer) {
					deep(layer,count+1);
				}else {
					//下一层
					deep(layer+1,0);
				}
				visted[j] = false;
			}
		}
		if (layer == 3 && count == 3) {
			if(check()) {
				outPut(d);
				sum++;
			}
			return;
		}
	}

	private static boolean check() {
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<=i;j++) {
				if(d[i][j] >= d[i+1][j] || d[i][j] >= d[i+1][j+1]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void outPut(int[][] d2) {
		// TODO Auto-generated method stub
		for (int[] is : d2) {
			System.out.println(Arrays.toString(is));
		}
		System.out.println();
	}
}
