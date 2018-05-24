package 蓝桥杯官方.真题.决赛题.b2017;

public class Problem2 {
	static int[][] map = new int[5][12];
	static int count;
	public static void main(String[] args) {
		f(1,1);
		System.out.println(count);
	}
	static void f(int x,int y) {
		if(x==4) {
			count++;
			return;
		}
		if(y == 11) {
			f(x+1,1);
			return;
		}
		if(map[x][y] == 0) {
			//可放
			// 横
			if(y+1<=10 && map[x][y+1] == 0) {
				//1
				map[x][y] = 1;
				map[x][y+1] = 1;
				if(check(x,y)) {
					f(x,y+2);
				}
				map[x][y] = 0;
				map[x][y+1] = 0;
				//2
				map[x][y] = 2;
				map[x][y+1] = 2;
				if(check(x,y)) {
					f(x,y+2);
				}
				map[x][y] = 0;
				map[x][y+1] = 0;
			}
			// 竖
			if(x+1<=3 && map[x+1][y] == 0) {
				//1
				map[x][y] = 1;
				map[x+1][y] = 1;
				if(check(x,y)) {
					f(x,y+1);
				}
				map[x][y] = 0;
				map[x+1][y] = 0;
				//2
				map[x][y] = 2;
				map[x+1][y] = 2;
				if(check(x,y)) {
					f(x,y+1);
				}
				map[x][y] = 0;
				map[x+1][y] = 0;
			}
			
		}else {
			//不可放置
			f(x,y+1);
		}
		
	}
	private static boolean check(int x, int y) {
		//检查四个子圈
		//左上子圈
		if(map[x][y] == map[x-1][y-1] && map[x][y] == map[x-1][y] && map[x][y] == map[x][y-1]) {
			return false;
		}
		//右上子圈
		if(map[x][y] == map[x-1][y] && map[x][y] == map[x-1][y+1] && map[x][y] == map[x][y+1]) {
			return false;
		}
		//右下子圈
		if(map[x][y] == map[x][y+1] && map[x][y] == map[x+1][y+1] && map[x][y] == map[x+1][y]) {
			return false;
		}
		//左下子圈
		if(map[x][y] == map[x][y-1] && map[x][y] == map[x+1][y] && map[x][y] == map[x+1][y-1]) {
			return false;
		}
		return true;
	}
	
	
}
