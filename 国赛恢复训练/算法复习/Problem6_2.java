package 国赛恢复训练.算法复习;

public class Problem6_2 {
	static int count;
	static boolean[][] visted = new boolean[7][7];
	public static void main(String[] args) {
		visted[3][3] = true;
		f(3,3);
		System.out.println(count/4);
	}
	
	public static void f(int x,int y) {
		if(x == 0 || x == 6 || y == 0 || y == 6) {
			count++;
			return;
		}
		//上下左右
		if(!visted[x][y-1]) {
			visted[x][y-1] = true;
			visted[6-x][6-y+1] = true;
			f(x,y-1);
			visted[x][y-1] = false;
			visted[6-x][6-y+1] = false;
 		}
		//下
		if(!visted[x][y+1]) {
			visted[x][y+1] =true;
			visted[6-x][6-y-1] = true;
			f(x,y+1);
			visted[x][y+1] =false;
			visted[6-x][6-y-1] = false;
		}
		//左
		if(!visted[x-1][y]) {
			visted[x-1][y] = true;
			visted[6-x+1][6-y] = true;
			f(x-1,y);
			visted[x-1][y] = false;
			visted[6-x+1][6-y] = false;
		}
		//右
		if(!visted[x+1][y]) {
			visted[x+1][y] = true;
			visted[6-x-1][6-y] = true;
			f(x+1,y);
			visted[x+1][y] = false;
			visted[6-x-1][6-y] = false;
		}
	}
}

