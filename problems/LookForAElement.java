package problems;

import java.util.Scanner;

/**
 * 查找元素
 * @author zxr
 *
 */
public class LookForAElement {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] data = new int[n];
		for (int i = 0; i < data.length; i++) {
			data[i] = input.nextInt();
		}
		int l = input.nextInt();
		input.close();
		System.out.println(lookfor(data,l));
	}

	private static int lookfor(int[] data, int l) {
		int i = 0;
		try{
			while(l != data[i++]);
			return i;
		}catch (Exception e) {
			// TODO: handle exception
			return -1;
		}
	}
}
