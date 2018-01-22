package problems;

import java.util.Arrays;
import java.util.Scanner;

public class KMinSelect {

	/**
	 * 第K小问题：即给出一组随机数据，选择第K小的数据 当然我们可以选择用预排序的方法，不过显得太大材小用了。
	 * 这里使用减治法，使用Lomuto划分来进行选择，也可以使用快速排序中的分法
	 */
	private static int[] D = { 10, 2, 3, 4, 1, 23, 40, 103, 40, 10042, 123 };
	private static int[] B = D.clone();

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Arrays.sort(B);
		System.out.println("输入k值（范围从0开始)");
		int k = input.nextInt();
		input.close();
		System.out.println(quickSelect(D, 0, D.length - 1, k - 1));
		System.out.println(B[k - 1]);

	}

	/**
	 * 
	 * @param D
	 *            数据数组
	 * @param start
	 *            开始搜索
	 * @param end
	 *            结束搜索
	 * @param k
	 *            在start-end这个区间中的第几小
	 * @return
	 */
	private static int quickSelect(int[] D, int start, int end, int k) {
		int m = lomutoParitionin(D, start, end);
		if (m == k) {
			return D[m + start];
		}
		int result = -1;
		if (m > k) {// 说明还在m-1的序列中
			result = quickSelect(D, start, start + m - 1, k);
		} else if (m < k) {// 在m+1-end的序列中,但应该注意k已经发生的了变化
			result = quickSelect(D, start + m + 1, end, k - m - 1);
		}
		return result;

	}

	/**
	 * 
	 * L分法，查看当前序列中的第一个元素（当然也可以自定义）在整个序列中的位置
	 * 
	 * @param D
	 * @param start
	 * @param end
	 * @return
	 */
	private static int lomutoParitionin(int[] D, int start, int end) {
		int p = D[start];
		int s = start;
		for (int i = start + 1; i <= end; i++) {
			if (D[i] < p) {
				s++;
				swap(D, s, i);
			}
		}
		// 交换首位和当前s占位
		swap(D, start, s);
		return s - start;
	}

	private static void swap(int[] D, int s, int i) {
		int temp = D[s];
		D[s] = D[i];
		D[i] = temp;
	}

}
