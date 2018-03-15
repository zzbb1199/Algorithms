package algorithm.boyilun;

import java.util.Scanner;

public class TakeBall {
	static int[] data = {1,3,7,8};
	static int max = 8;
	public static void main(String[] args) {
		Scanner input =new Scanner(System.in);
		int num = input.nextInt();
		take(num,1);
		System.out.println(win);
	}
	
	/**
	 * 
	 * @param current 当前还剩求数量
	 * @param x	取求人 1 是自己 0 是对方
	 */
	static boolean win = false;
	public static void take(int current,int x){
		if(current <= max){
			if(x == 1){
				win = true;
			}
			return;
		}
		for(int i = 0;i<4;i++){
			if(current - data[i] >= 0){
				take(current - data[i],x^1);
			}
		}
	}
}
