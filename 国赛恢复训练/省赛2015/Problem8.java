package 国赛恢复训练.省赛2015;

import java.util.Scanner;

/**
 * 饮料换购

乐羊羊饮料厂正在举办一次促销优惠活动。乐羊羊C型饮料，凭3个瓶盖可以再换一瓶C型饮料，并且可以一直循环下去，但不允许赊账。

请你计算一下，如果小明不浪费瓶盖，尽量地参加活动，那么，对于他初始买入的n瓶饮料，最后他一共能得到多少瓶饮料。
 * @author Raven
 *
 */
public class Problem8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.close();
		for(int i = 1;i<=n;i++) {
			if(i % 3 == 0) {
				n++;
			}
		}
		System.out.println(n);
	}
}
