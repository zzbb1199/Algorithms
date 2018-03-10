package problems.base.pratice;

import java.util.Scanner;

/**
 * 大数据中16进制转换到8进制
 * 思想采用二进制
 * 使用StringBuilder而不是String来加快运行速度
 *
 */
public class HexadecimalConversion {
	public static void main(String[] args) {
		// 输入
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		input.nextLine();
		String[] hexs = new String[n];
		for (int i = 0; i < hexs.length; i++) {
			hexs[i] = input.nextLine();
		}
		input.close();
		// 蓝桥杯的给的数据太变态,采用8421BCD码转换
		for (String str : hexs) {
			// 将一个16进制数，换算称4位二进制
			StringBuilder binary = new StringBuilder();
			for (char c : str.toCharArray()) {
				StringBuilder temp = new StringBuilder(Integer.toBinaryString(Integer.valueOf(c + "", 16)));
				// 不够，前面补0
				for (int i = temp.length(); i < 4; i++) {
					temp = new StringBuilder("0").append(temp);
				}
				binary.append(temp);
			}
			// 补零
			int length = binary.length();
			int rest = 3 - str.length() % 3;
			length += rest;
			for (int i = 0; i < rest; i++) {
				binary = new StringBuilder("0").append(binary);
			}
			// 按三位换算称八进制
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < length / 3; i++) {
				int temp = Integer.valueOf(binary.substring(i * 3, (i + 1) * 3), 2);
				result.append(temp);
			
			}
			// 输出
			System.out.println(result.toString().replaceAll("^0*", ""));//采用正则表达式替换掉，避免多次判断
		}

	}

}
