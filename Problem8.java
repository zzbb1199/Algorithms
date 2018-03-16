import java.util.Arrays;
import java.util.Scanner;

public class Problem8 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int target = input.nextInt();
		hasSolve = false;
		f(0,target);
	}

	static int[] current = new int[4];
	static boolean hasSolve = false;

	public static void f(int index, int target) {

		for (int i = 0; i < 1000; i++) {
			if (index == 3) {
				current[index] = i;
				long temp = current[0] * current[0] + current[1] * current[1] + current[2] * current[2]
						+ current[3] * current[3] ;
				if ( temp == target) {
					hasSolve = true;
					System.out.println(Arrays.toString(current));
					return;
				}else if(temp > target) {
					return;
				}
			} else {
				if (Math.pow(current[index], 2) > target) {
					current[index] = 0;//回溯
					return;
				} else {
					if (!hasSolve) {
						current[index] = i;
						f(index + 1, target);
					}

				}
			}
		}
	}
}
