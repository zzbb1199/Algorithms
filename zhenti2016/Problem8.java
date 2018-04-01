package zhenti2016;

import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args)  {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		try {
			f(0);
		} catch (Exception e) {
		
		}
	}
	static int n;
	static int[] ans = new int[4];
	static void f(int index) throws Exception {
		if(index < 3) {
			for(int i = 0;i<n;i++) {
				ans[index] = i;
				if(sum(index) > n) {
					return;
				}else {
					f(index+1);
				}
			}
		}else {
			for(int i = 0;i<n;i++) {
				ans[index] = i;
				if(sum(index) < n) {
					continue;
				}else if(sum(index) == n) {
					StringBuilder str = new StringBuilder();
					for (int k : ans) {
						str.append(k+" ");
					}
					System.out.println(str.substring(0, str.length()-1));
					throw new Exception();//强制退出
				}else if(sum(index) > n) {
					return;
				}
			}
		}
		
		
	}
	static int sum(int index) {
		int an = 0;
		for(int i = 0;i<=index;i++) {
			an+=ans[i]*ans[i];
		}
		return an;
	}
}
