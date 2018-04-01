package algorithm.recursion.prebiew;
/**
 * 
小明参加了学校的趣味运动会，其中的一个项目是：跳格子。
地上画着一些格子，每个格子里写一个字，如下所示：（也可参见下图）

从我做起振
我做起振兴
做起振兴中
起振兴中华

比赛时，先站在左上角的写着“从”字的格子里，可以横向或纵向跳到相邻的格子里，但不能跳到对角的格子或其它位置。一直要跳到“华”字结束。

要求跳过的路线刚好构成“从我做起振兴中华”这句话。
请你帮助小明算一算他一共有多少种可能的跳跃路线呢？
 * @author zxr
 *
 */
public class Problem2 {
	static boolean[][] visted = new boolean[4][5];
	static int count;
	public static void main(String[] args) {
		deep(0,0);
		System.out.println(count);
	}
	public static void deep(int x,int y) {
		if(x == 3 && y == 4) {
			count++;
			return;
		}
		int k = 0;
		int saveX = x;
		int saveY = y;
		while(k<2) {
			if(k == 0) {
				//向右行走
				x+=1;
				if(x<=3) {
					deep(x,y);
				}
			}else if(k == 1) {
				//向下行走
				y+=1;
				if(y<=4) {
					deep(x,y);
				}
			}
			x = saveX;
			y = saveY;
			k++;
		}
	}
}
