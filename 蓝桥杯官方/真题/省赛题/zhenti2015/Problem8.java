package zhenti2015;

import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		for(int i = 1;i<=n;i++) {
			if(i % 3 == 0) {
				n++;
			}
		}
		System.out.println(n);
	}
}
