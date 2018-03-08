package algorithm.violence;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 第一行是整数 n,表示接下来有 n 个罗马数字(n<100)。 以后每行一个 罗马数字。罗马数字大小不超过 999。 要求程序输出 n
 * 行，就是罗马数字对应的十 进制数据
 * 
 * @author zxr
 *
 */
public class RomanNumBer {
	static Map<Character, Integer> map = new HashMap<Character,Integer>();
	static Map<Character,Integer> type = new HashMap<Character,Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		String[] str = new String[n];
		input.nextLine();
		for (int i = 0; i < n; i++) {
			str[i] = input.nextLine();
		}
		input.close();
		// 建立映射表
		init();
		for (int i = 0; i < n; i++) {
			outPut(str[i]);
		}
	}

	private static void init() {
		// TODO Auto-generated method stub
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		type.put('I', 1);
		type.put('V', 2);
		type.put('X', 3);
		type.put('L', 4);
		type.put('C', 5);
		type.put('D', 6);
		type.put('M', 7);
		
	}

	private static void outPut(String str) {
		// TODO Auto-generated method stub
		char[] c = str.toCharArray();
		int sum = 0;
		int i = 0;
		while (i < c.length-1) {
			// 从当前点向右边扫描
			if(map.get(c[i]) >= map.get(c[i+1])) {
				sum+=map.get(c[i]);
				i++;
			}else if(type.get(c[i+1]) - type.get(c[i]) == 1){
				sum +=(map.get(c[i+1]) - map.get(c[i]));
				i= i+2;
			}else {
				sum+=map.get(c[i]);
				i++;
			}
		}
		if(i == c.length -1) {
			sum+=map.get(c[i]);
		}
		System.out.println(sum);
	}


}
