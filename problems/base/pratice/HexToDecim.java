package problems.base.pratice;

import java.util.Scanner;

/**
 * 16进制转换到10进制
 * @author zxr
 *
 */
public class HexToDecim {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine();
		input.close();
		StringBuilder binaryStr = new StringBuilder();
		//将16进制转换到二进制
		for (char c : str.toCharArray()) {
			StringBuilder temp = new StringBuilder(Integer.toBinaryString(Integer.valueOf(c+"",16)));
			//进行补全
			for(int i = temp.length();i<4;i++) {
				temp = new StringBuilder("0").append(temp);
			}
			//二进制添加
			binaryStr.append(temp);
		}
		//进行二进制转换到10进制
		int length = binaryStr.length();
		long sum = 0;
		for(int i = 0;i<length;i++) {
			if(binaryStr.charAt(i) == '1') {
				sum+= Math.pow(2, length-1-i);
			}
		}
		System.out.println(sum);
	}
}
