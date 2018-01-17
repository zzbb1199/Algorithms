package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	/**
	 * BFS 图的广度遍历方式
	 * 图的广度遍历方式采用了非递归方式，使用队列数据结构
	 */
	private static int[][] D ={
			{0,1,1,1,0,0},
			{1,0,1,0,1,0},
			{1,1,0,1,1,1},
			{1,0,1,0,0,1},
			{0,1,1,0,0,1},
			{0,0,1,1,1,0},
			};  
	public static void main(String[] args) {
		bfs();
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visted = new boolean[D.length];
		int[] record = new int[D.length];
		int recordIndex = 0;
		//不妨从零开始
		int current = 0;
		queue.offer(current);
		visted[current] = true;
		record[recordIndex++] = current;
		while(!queue.isEmpty()) {
			for (int i = 0; i < D.length; i++) {
				if(!visted[i] && D[current][i] == 1) {
					visted[i] = true;
					queue.offer(i);
					record[recordIndex++] = i;
				}
			}
			current = queue.poll();
		}
		System.out.println(Arrays.toString(record));
	}
}
