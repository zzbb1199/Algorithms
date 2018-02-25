package problems.base.pratice;

import java.util.Scanner;

/**
 * 龟兔赛跑
 * 乌龟的比赛中，一旦任一秒结束后兔子发现自己领先t米或以上，它们就会停下来休息s秒。
 * 对于不同的兔子，t，s的数值是不同的，但是所有的乌龟却是一致——它们不到终点决不停止。
 * @author zxr
 *　　输入只有一行，包含用空格隔开的五个正整数v1，v2，t，s，l，其中(v1,v2<=100;t<=300;s<=10;l<=10000且为v1,v2的公倍数)
　	输出包含两行，第一行输出比赛结果——一个大写字母“T”或“R”或“D”，分别表示乌龟获胜，兔子获胜，或者两者同时到达终点。
　　第二行输出一个正整数，表示获胜者（或者双方同时）到达终点所耗费的时间（秒数）。
 */
public class TRGame {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int v1 = input.nextInt();
		int v2 = input.nextInt();
		int t = input.nextInt();
		int s = input.nextInt();
		int l = input.nextInt();
		input.close();
		
		int s1 = 0;	//兔子现在坐标
		int s2 = 0;	//乌龟现在坐标
		int r1 = 0;	//兔子当前还要休息的时间
		//模拟仿真
		int iter = 0;
		while(true) {
			iter++;
			s2+=v2;
			if(r1 > 0) {
				r1--;
			}else {
				s1+=v1;
				if(s1 - s2 >= t) {
					r1 = s;
				}
			}
			//判定是否达到终点
			if(s1 ==  l && s2 != l) {
				System.out.println("R");
				break;
			}else if(s1 != l && s2 == l) {
				System.out.println("T");
				break;
			}else if(s1 == l && s2 == l) {
				System.out.println("D");
				break;
			}
		}
		System.out.println(iter);
	}
}
