package algorithm.violence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 每组测试数据为一个 3*3 的矩阵，其中为 0 的部分表示被小明抹去的部分。 对于 100%的数据，满足给出的矩阵至少能还原出一组可行的三阶幻方。
 * 
 * @author zxr
 *
 */
public class ThreeOrderMagicSquare {

	static List<int[]> as = new ArrayList<int[]>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int[][] A = new int[3][3];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				A[i][j] = input.nextInt();
			}
		}
		List<int[]> index = findEpty(A);
		// 找到未用数字
		List<Integer> sets = new ArrayList<Integer>();
		sets.add(1);
		sets.add(2);
		sets.add(3);
		sets.add(4);
		sets.add(5);
		sets.add(6);
		sets.add(7);
		sets.add(8);
		sets.add(9);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (A[i][j] != 0) {
					sets.remove(new Integer(A[i][j]));
				}
			}
		}
		int[][] o = new int[3][3];
		int[] a = new int[sets.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = sets.get(i);
		}
		// 生成全排列
		P(a, 0);
		// 填表
		int count = 0;
		for (int m = 0; m < as.size(); m++) {
			for (int i = 0; i < index.size(); i++) {
				int[] in = index.get(i);
				A[in[0]][in[1]] = as.get(m)[i];
			}
			// 检查
			if (check(A)) {
				for(int i =0;i<3;i++) {
					o[i] = A[i].clone();
				}
				count++;
			}
		}
		if (count == 1) {
			outPut(o);
		} else if (count > 1) {
			System.out.println("To Many");
		}

	}

	private static boolean check(int[][] a) {
		// 计算行
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += a[0][i];
		}
		int temp = 0;
		for (int i = 1; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				temp += a[i][j];
			}
			if (sum != temp) {
				return false;
			}
			temp = 0;
		}
		// 计算列
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i < 3; i++) {
				temp += a[i][j];
			}
			if (sum != temp) {
				return false;
			}
			temp = 0;
		}
		// 计算对角线
		temp = a[0][0] + a[1][1] + a[2][2];
		if (temp != sum) {
			return false;
		}
		return true;
	}

	private static void outPut(int[][] a) {
		// TODO Auto-generated method stub
		for (int[] is : a) {
			StringBuilder str = new StringBuilder();
			for (int i : is) {
				str.append(i + " ");
			}
			System.out.println(str.toString().substring(0, str.length() - 1));
		}
	}

	private static List<int[]> findEpty(int[][] a) {
		// TODO Auto-generated method stub
		List<int[]> index = new ArrayList<int[]>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] == 0) {
					index.add(new int[] { i, j });
				}
			}
		}
		return index;
	}

	/**
	 * 求解全排列方式一
	 * 
	 * @param answer
	 * @param index
	 */
	private static void P(int[] answer, int index) {
		if (index == answer.length - 1) {
			// System.out.println(Arrays.toString(answer));
			as.add(answer.clone());
			return;
		}
		for (int i = index; i < answer.length; i++) {
			swap(answer, index, i);
			P(answer, index + 1);
			swap(answer, index, i);
		}
	}

	private static void swap(int[] answer, int index, int i) {
		// TODO Auto-generated method stub
		int temp = answer[index];
		answer[index] = answer[i];
		answer[i] = temp;
	}

	// 使用时需要进行初始化
	static int[] answer;
	static boolean[] visted;

	/**
	 * 
	 * 求解全排列方式二，效率比第一种方式高，但是需要借助辅助变量
	 * 
	 * @param start
	 * @param end
	 * @param index
	 */
	private static void pailie(int start, int end, int index) {
		if (index == end) {
			System.out.println(Arrays.toString(answer));
			return;
		}
		for (int i = 0; i < end; i++) {
			if (!visted[i]) {
				visted[i] = true;
				answer[index] = i + 1;
				pailie(start, end, index + 1);
				visted[i] = false;
			}
		}
	}

}
