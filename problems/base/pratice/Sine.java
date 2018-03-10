package problems.base.pratice;

import java.util.Scanner;

/**
 * 最近FJ为他的奶牛们开设了数学分析课，FJ知道若要学好这门课，必须有一个好的三角函数基本功。所以他准备和奶牛们做一个“Sine之舞”的游戏，寓教于乐，提高奶牛们的计算能力。
　　不妨设
　　An=sin(1–sin(2+sin(3–sin(4+...sin(n))...)
　　Sn=(...(A1+n)A2+n-1)A3+...+2)An+1
　　FJ想让奶牛们计算Sn的值，请你帮助FJ打印出Sn的完整表达式，以方便奶牛们做题。

 * @author zxr
 *
 */
public class Sine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//(A1+3)A2+2)A3+1
		//((sin(1)+3)sin(1–sin(2))+2)sin(1–sin(2+sin(3)))+1
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		System.out.println(getS(n,n));
	}
	public static String getS(int now,int n) {
		if(now == 1) {
			return getA(1,now)+"+"+(n-now+1);
		}
		return "("+getS(now-1,n)+")"+getA(1,now)+"+"+(n-now+1);
	}
	public static String getA(int now,int end) {
		return geta(now,end).replaceAll("[+-]\\)", ")");
	}
	private static String geta(int now,int end) {
		if(now <= end) {
			if((now+1)%2 == 0) {
				return "sin("+now+"-"+getA(now+1,end)+")";
			}else {
				return "sin("+now+"+"+getA(now+1,end)+")";
			}
		}
		return "";
	}
}
