package problems.Introduction;

import java.util.Scanner;

/**
 * 给定圆的半径r，求圆的面积,保留7位小数，四舍五入
 * @author zxr
 *
 */

public class CircleArea {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		input.close();
		double area = Math.PI*r*r;
		System.out.println(String.format("%.7f", area));
	}
}
