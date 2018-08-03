package 蓝桥杯官方.真题.省赛题.zhenti.b2017;
/**
 * 寻找对称图案
 * @author Raven
 *
 */
public class Probleam4 {
	public static void main(String[] args) {
		visted[3][3] = true;
		deep(3,3);
		System.out.println(count/4);
	}
	static boolean[][] visted = new boolean[7][7];
	static int count = 0;

	public static void deep(int x,int y){
		if(x == 6 || y == 6 || x == 0 || y == 0){
			count++;
			return;
		}
		int i = 0;
		int saveX = x;
		int saveY = y;
		while(i <= 3){
			if(i == 0){
				//左
				x -= 1;
			}else if(i == 1){
				//右
				x += 1;
			}else if(i == 2){
				//上
				y -= 1;
			}else if(i == 3){
				//下
				y+=1;
			}
			if(!visted[x][y]){
				visted[x][y] = true;
				visted[6-x][6-y] = true;
				deep(x,y);
				//回溯
				visted[x][y] = false;
				visted[6-x][6-y] = false;
			}
			x = saveX;
			y = saveY;
			i++;
		}


	}
}
