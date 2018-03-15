package algorithm.math;
import java.util.ArrayList;
import java.util.List;
/**
 * 问题7：邮票问题
 * 
 * @author zxr
 *
 */
public class FuDianJingDu {
	static int[] current = new int[12];
	static int[] data = new int[12];
	static int[] currentnum = new int[5];
	public static void main(String[] args) {
		// 初始化
		for (int i = 0; i < 12; i++) {
			data[i] = 1;
		}
		// 递归
		deep(0);
		System.out.println(count);
	}
	static int count;
	public static void deep(int index) {
		if (check1(current)) {
			// 产生一个排列组合，检车该排列组合是否符合要求
			if (check2(currentnum)) {
				outPut(currentnum);
				count++;
			}
			return;
		}
		if (index == 12) {
			return;
		}
		for (int i = 0; i <= data[index]; i++) {
			current[index] = i;
			deep(index + 1);
		}
	}
	private static void outPut(int[] currentnum2) {
		// TODO Auto-generated method stub
		for (int i : currentnum2) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
	}
	public static boolean check1(int[] current) {
		int sum = 0;
		for (int i : current) {
			sum += i;
		}
		if (sum == 5) {
			int k = 0;
			for (int i = 0; i < current.length; i++) {
				if (current[i] != 0) {
					currentnum[k++] = i;
				}
			}
			return true;
		}
		return false;
	}
	static boolean hasAllV = false;
	public static void DFS(Coordinate[] c,Coordinate current,int reset) {
		if(reset == 0) {
			hasAllV = true;
			return;
		}
		if(hasAllVisted(c)) {
			hasAllV = true;
			return;
		}
		List<Coordinate> next = current.next;
		for (Coordinate coordinate : next) {
			if(!coordinate.visted) {
				coordinate.visted = true;
				DFS(c,coordinate,reset-1);
			}
		}
	}
	private static boolean hasAllVisted(Coordinate[] c) {
		for (Coordinate coordinate : c) {
			if(!coordinate.visted) {
				return false;
			}
		}
		return true;
	}
	public static boolean check2(int[] currrentnum) {
		Coordinate[] c = new Coordinate[5];
		// 转换为坐标
		for (int i = 0; i < c.length; i++) {
			c[i] = new Coordinate(currentnum[i] % 4, currentnum[i] / 4);
		}
		// 检查
		for (int i = 0; i < c.length; i++) {
			Coordinate temp_c = c[i];
			Coordinate next;
			// 向上
			if (temp_c.y - 1 >= 0) {
				next = find(c, temp_c.x, temp_c.y - 1);
				if (next != null) {
					c[i].next.add(next);
				}
			}
			// 向下
			if (temp_c.y + 1 <= 2) {
				next = find(c, temp_c.x, temp_c.y + 1);
				if (next != null) {
					c[i].next.add(next);
				}
			}
			// 向左
			if (temp_c.x - 1 >= 0) {
				next = find(c, temp_c.x - 1, temp_c.y);
				if (next != null) {
					c[i].next.add(next);
				}
			}
			// 向右
			if (temp_c.x + 1 <= 3) {
				next = find(c, temp_c.x + 1, temp_c.y);
				if (next != null) {
					c[i].next.add(next);
				}
			}
		}
		hasAllV = false;
		c[0].visted = true;
		DFS(c,c[0],4);
		if(hasAllV) {
			return true;
		}
		return false;
	}
	static Coordinate find(Coordinate[] c, int x, int y) {
		for (Coordinate coordinate : c) {
			if (coordinate.x == x && coordinate.y == y) {
				return coordinate;
			}
		}
		return null;
	}
	static class Coordinate {
		int x;
		int y;
		boolean visted = false;
		List<Coordinate> next = new ArrayList<>();
		public Coordinate(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

