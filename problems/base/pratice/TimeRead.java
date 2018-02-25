package problems.base.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 问题描述
　　给定当前的时间，请用英文的读法将它读出来。
　　时间用时h和分m表示，在英文的读法中，读一个时间的方法是：
　　如果m为0，则将时读出来，然后加上“o'clock”，如3:00读作“three o'clock”。
　　如果m不为0，则将时读出来，然后将分读出来，如5:30读作“five thirty”。
　　时和分的读法使用的是英文数字的读法，其中0~20读作：

　　对于大于20小于60的数字，首先读整十的数，然后再加上个位数。如31首先读30再加1的读法，读作“thirty one”。
　　按上面的规则21:54读作“twenty one fifty four”，9:07读作“nine seven”，0:15读作“zero fifteen”。
输入格式
　　输入包含两个非负整数h和m，表示时间的时和分。非零的数字前没有前导0。h小于24，m小于60。
输出格式
　　输出时间时刻的英文。
样例输入
0 15
样例输出
zero fifteen
 * @author zxr
 *
 */
public class TimeRead {
	public static void main(String[] args) {
		//输入
		Scanner input = new Scanner(System.in);
		int h = input.nextInt();
		int m = input.nextInt();
		input.close();
		//初始化
		init();
		if(m == 0) {
			System.out.println(outPutHour(h)+" o'clock");
		}else {
			//有分
			if(m <= 20 || m%10 == 0) {
				//小于20或者为整十数
				System.out.println(outPutHour(h)+" "+timeMap.get(m));
			}else {
				int x = m%10;
				System.out.println(outPutHour(h)+" "+timeMap.get(m-x)+" "+timeMap.get(x));
			}
		}
	}
	static String outPutHour(int h) {
		String result;
		if(h > 20) {
			int x = h % 10;
			result = timeMap.get(20)+" "+timeMap.get(x);
		}else {
			result = timeMap.get(h);
		}
		return result;
	}
	static Map<Integer,String> timeMap = new HashMap<>();
	private static void init() {
		// TODO Auto-generated method stub
		timeMap.put(0, "zero");
		timeMap.put(1, "one");
		timeMap.put(2, "two");
		timeMap.put(3, "three");
		timeMap.put(4, "four");
		timeMap.put(5, "five");
		timeMap.put(6, "six");
		timeMap.put(7, "seven");
		timeMap.put(8, "eight");
		timeMap.put(9, "nine");
		timeMap.put(10, "ten");
		timeMap.put(11, "eleven");
		timeMap.put(12, "twelve");
		timeMap.put(13, "thirteen");
		timeMap.put(14, "fourteen");
		timeMap.put(15, "fifteen");
		timeMap.put(16, "sixteen");
		timeMap.put(17, "seventeen");
		timeMap.put(18, "eighteen");
		timeMap.put(19, "nineteen");
		timeMap.put(20, "twenty");
		timeMap.put(30, "thirty");
		timeMap.put(40, "forty");
		timeMap.put(50, "fifty");
	}
}
