package problems.base.pratice;

import java.util.Scanner;

public class LeapYear {
/**
 * 闰年判断
 * @param args
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		int year = input.nextInt();
		input.close();
		if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

}
