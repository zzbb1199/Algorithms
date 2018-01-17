package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class DFS {
	/**
	 * DFS 图的深度优先遍历
	 * DFS具有两种解法，递归形式和非递归形式
	 * 对于递归形式-代码简单但是耗时较高
	 * 对于非递归形式-使用了堆栈结构，代码稍复杂，耗时相对较低
	 */
	private static int[][] D ={
			{0,1,1,1,0,0},
			{1,0,1,0,1,0},
			{1,1,0,1,1,1},
			{1,0,1,0,0,1},
			{0,1,1,0,0,1},
			{0,0,1,1,1,0},
			};  
	private static boolean visted[];
	private static int[] record;
	private static int recordIndex = 0;
	public static void main(String[] args) {
		int N = D.length;
		//方式一
		visted = new boolean[N];
		record = new int[N];
		for (int i = 0; i < D.length; i++) {
			if(!visted[i]) {
				record[recordIndex++] = i;
				visted[i] = true;
				DFSR(i);
			}
		}
		//输出
		System.out.println(Arrays.toString(record));
		//方式二
		record = new int[N];
		recordIndex = 0;
		visted = new boolean[N];
		DFSNR();
		System.out.println(Arrays.toString(record));
	}
	/**
	 * 方式一：递归形式
	 */
	private static void DFSR(int point) {
		for (int i = 0; i < D.length; i++) {
			if(!visted[i] && D[point][i] == 1) {
				visted[i] = true;
				record[recordIndex++] = i;
				DFSR(i);
			}
		}
	}
	
	/**
	 * 方式二：非递归形式
	 */
	private static void DFSNR() {
		Stack<Integer> stack =  new Stack<>();
		//不妨从零开始访问
		int current = 0;
		stack.push(current);
		visted[current] = true;
		record[recordIndex++] = current;
		boolean pushed = false;
		while(!stack.isEmpty()) {
			for (int i = 0; i < D.length; i++) {
				if(!visted[i] && D[current][i] == 1) {
					pushed = true;
					visted[i] = true;
					record[recordIndex++] = i;
					stack.push(i);
					current = i;
					break;
				}
			}
			if(!pushed && !stack.isEmpty()) {
				current = stack.pop();
			}
			pushed = false;
		}
	}
}

	