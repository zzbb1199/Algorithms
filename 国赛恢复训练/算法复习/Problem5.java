package 国赛恢复训练.算法复习;
/**
 * 蓝桥杯 裁纸问题
 * @author Raven
 *
 */
public class Problem5 {
	static boolean[][] visted = new boolean[7][7];
	public static void main(String[] args) {
		visted[3][3] = true;
		f(3,3);
		System.out.println(count/4);
	}
	static int count;
	public static void f(int x,int y) {
		if(x == 0 || y == 0 || x == 6 || y == 6) {
			//边界
			count++;
			return;
		}
		int saveX = x;
		int saveY = y;
		for(int i = 0;i<4;i++) {
			switch(i) {
			case 0:
				x+=1;
				break;
			case 1:
				x-=1;
				break;
			case 2:
				y+=1;
				break;
			case 3:
				y-=1;
				break;
			}
			if(!visted[x][y]) {
				visted[x][y] = true;
				visted[6-x][6-y] = true;
				f(x,y);
				visted[x][y] = false;
				visted[6-x][6-y] = false;
			}
			x = saveX;
			y = saveY;
		}
	}
}
