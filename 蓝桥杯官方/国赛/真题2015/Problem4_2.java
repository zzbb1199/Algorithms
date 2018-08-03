package 蓝桥杯官方.国赛.真题2015;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4_2 {
	static int N;
	static int[][] D;
	static int startx,starty,endx,endy;
	static final int A = -1;
	static final int B = -2;
	static final int zheng = 0;
	static final int fu = 1;
	static boolean[][] v ;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		D = new int[N][N];
		v = new boolean[N][N];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				int c = input.next().toCharArray()[0];
				switch(c) {
				case 'A':
					startx = i;
					starty = j;
					D[i][j] = A;
					break;
				case 'B':
					endx = i;
					endy = j;
					D[i][j] = B;
					break;
				case '+':
					D[i][j] = zheng;
					break;
				case '-':
					D[i][j] = fu;
					break;
				}
			}
		}
		//bfs
		v[startx][starty] = true;
		System.out.println(bfs());
	}
	public static int bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {startx,starty,0});
		while(!q.isEmpty()) {
			int xy[] = q.poll();
			int saveX = xy[0];
			int saveY = xy[1];
			int count = xy[2];//当前走了的步数
			//bfs
			for(int i = 0;i<4;i++) {
				switch(i) {
				case 0:
					xy[0]-=1;
					break;
				case 1:
					xy[0]+=1;
					break;
				case 2:
					xy[1]-=1;
					break;
				case 3:
					xy[1]+=1;
					break;
				}
				if(xy[0]>=0 && xy[0]<N&&xy[1]>=0&&xy[1]<N &&!v[xy[0]][xy[1]] //边界检查 
						&& ((D[saveX][saveY] == A) || (D[xy[0]][xy[1]] == B) ||//起点或终点特殊检查
						((D[xy[0]][xy[1]]^D[saveX][saveY])==1))) {//交叉检查
					v[xy[0]][xy[1]] =  true;
					if(xy[0] == endx&&xy[1] == endy) {
						return count+1;
					}
					q.add(new int[] {xy[0],xy[1],count+1});
				}
				xy[0] = saveX;
				xy[1] = saveY;
			}
		}
		return -1;
	}
}
