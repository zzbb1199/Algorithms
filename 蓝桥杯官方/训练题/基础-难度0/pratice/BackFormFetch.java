package problems.base.pratice;

import java.util.Scanner;

/**
 * 问题描述
　　回形取数就是沿矩阵的边取数，若当前方向上无数可取或已经取过，则左转90度。一开始位于矩阵左上角，方向向下。
输入格式
　　输入第一行是两个不超过200的正整数m, n，表示矩阵的行和列。接下来m行每行n个整数，表示这个矩阵。
输出格式
　　输出只有一行，共mn个数，为输入矩阵回形取数得到的结果。数之间用一个空格分隔，行末不要有多余的空格。
样例输入
3 3
1 2 3
4 5 6
7 8 9
样例输出
1 4 7 8 9 6 3 2 5
 * @author zxr
 *
 */
public class BackFormFetch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//初始化
		Scanner input = new Scanner(System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		int[][] A = new int[m][n];
		for(int i = 0;i<m;i++) {
			for(int j = 0;j<n;j++) {
				A[i][j] = input.nextInt();
			}
		}
		input.close();
		boolean[][] visted = new boolean[m][n];
		CoordinateControl cd = new CoordinateControl(m,n);
		visted[0][0] = true;
		StringBuilder result = new StringBuilder();
		result.append(""+A[0][0]);
		int[] c = new int[2];
		//开始回环遍历
		while(true) {
			if(cd.check(visted, c[0], c[1])) {
				c = cd.change(c[0], c[1]);
				result.append(" "+A[c[0]][c[1]]);
				visted[c[0]][c[1]] = true;
			}else {
				break;
			}
		}
		System.out.println(result);
	}	
	/**
	 * 坐标控制器
	 * @author zxr
	 */
	static class CoordinateControl{
		int count;
		int m;
		int n;
		
		public CoordinateControl(int m, int n) {
			super();
			this.m = m;
			this.n = n;
		}

		private int[] change(int row,int col) {
			int[] c = new int[2];
			c[0] = row;
			c[1] = col;
			switch(count % 4) {
			case 0:
				c[0]+=1;
				break;
			case 1:
				c[1]+=1;
				break;
			case 2:
				c[0]-=1;
				break;
			case 3:
				c[1]-=1;
				break;
			default:
				break;
			}
			return c;
		}
	
		private boolean check(boolean[][] visted,int row,int col) {
			switch(count % 4) {
			case 0:
				if(row+1 < m && !visted[row+1][col]) {
					return true;
				}else {
					//判定右边是否可遍历
					if(col+1 <n && !visted[row][col+1]) {
						count++;
						return true;
					}
				}
				return false;
			case 1:
				if(col+1 < n && !visted[row][col+1]) {
					return true;
				}else {
					//判定上边是否可遍历
					if(row-1 >=0 && !visted[row-1][col]) {
						count++;
						return true;
					}
				}
				return false;
			case 2:
				if(row-1 >=0  && !visted[row-1][col]) {
					return true;
				}else {
					//判定左边是否可遍历
					if(col-1 >=0 && !visted[row][col-1]) {
						count++;
						return true;
					}
				}
				return false;
			case 3:
				if(col-1 >=0 && !visted[row][col-1]) {
					return true;
				}else {
					//判定下边是否可遍历
					if(row+1 <n && !visted[row+1][col]) {
						count++;
						return true;
					}
				}
				return false;
			default:
				break;
			}
			return true;
		}
	}

}
