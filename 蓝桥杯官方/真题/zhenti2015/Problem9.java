package zhenti2015;

import java.math.BigInteger;
import java.util.Scanner;

public class Problem9 {
	static long count = 0;
	static long n;
	static int m;
	static String[] forbid;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextLong();
		m = input.nextInt();
		forbid = new String[m];
		for(int i = 0;i<m;i++) {
			forbid[i] = input.nextInt()+""+input.nextInt();
		}
		//放置第一个
		for(int i = 1;i<=6;i++) {
			f(1,opposite(i));
		}
		System.out.println(count);
		
	}
	public static void f(long index,int prenum) {
		if(index == n+1) {
			count = (count+1)%(10^9 + 7);
			return;
		}
		for(int i =1;i<=6;i++) {
			if(pass(i,prenum)) {
				f(index+1,opposite(i));
			}
		}
	}
	public static int opposite(int i) {
		switch(i) {
			case 1:return 4;
			case 2:return 5;
			case 3:return 6;
			case 4:return 1;
			case 5:return 2;
			case 6:return 3;
			default:return -1;
		}
		
	}
	public static boolean pass(int i,int pre) {
		String com1 =  ""+i+pre;
		String com2 = ""+pre+i;
		for (String string : forbid) {
			if(string.equals(com1)||string.equals(com2)) {
					return false;
			}
		}
		return true;
	}
	static class Area{
		int down;
		int up;
		public Area(int down, int up) {
			super();
			this.down = down;
			this.up = up;
		}
		
	}
}
