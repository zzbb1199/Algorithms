package algorithm.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * X星球特别讲究秩序，所有道路都是单行线。 一个甲壳虫车队，共16辆车，按照编号先后发车，夹在其它车流中，缓缓前行。
 * 
 * 路边有个死胡同，只能容一辆车通过，是临时的检查站，如图所示。 X星球太死板，要求每辆路过的车必须进入检查站，也可能不检查就放行，也可能仔细检查。
 * 如果车辆进入检查站和离开的次序可以任意交错。那么，该车队再次上路后，可能的次序有多少种？
 * 
 * 为了方便起见，假设检查站可容纳任意数量的汽车。 显然，如果车队只有1辆车，可能次序1种；2辆车可能次序2种；3辆车可能次序5种。
 * 
 * @author zxr
 *
 */
public class OutQueen {
	static int num = 16;
	static int[] current = new int[num];
	static List<int[]> answer = new ArrayList<>();

	public static void main(String[] args) {
		// 初始化
		for (int i = 0; i < num; i++) {
			current[i] = i + 1;
		}
		deep(0, 0);
		for (int[] a : answer) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(answer.size());
	}

	/**
	 * 
	 * @param index
	 *            递归到第几层
	 * @param offset
	 *            数组偏移量
	 */
	public static void deep(int index, int offset) {
		if (index == num) {
			if (check()) {
				answer.add(current.clone());
			}
			return;
		}

		// 每个甲虫都可能停和不停
		// 停
		int[] temp_c = current.clone();
		swap(offset);
		deep(index + 1, offset);
		// 不停
		// 恢复
		current = temp_c.clone();
		deep(index + 1, offset + 1);
	}

	public static void swap(int index) {
		int temp = current[index];
		for (int i = index; i < num - 1; i++) {
			current[i] = current[i + 1];
		}
		current[num - 1] = temp;
	}

	private static boolean check() {
		for (int i = 0; i < answer.size(); i++) {
			int[] c = answer.get(i);
			boolean match = true;
			for(int j = 0;j<num;j++) {
				if(c[j] != current[j]) {
					match = false;
					break;
				}
			}
			if(match) {
				return false;
			}
		}
		return true;
	}
}
