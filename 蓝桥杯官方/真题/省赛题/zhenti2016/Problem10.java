package zhenti2016;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem10 {
	static int[] origin;
	static Set<Integer> ra = new HashSet<>();//记录是否出现过
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		origin = new int[n];
		for(int i = 0;i<n;i++) {
			origin[i] = input.nextInt();
		}
		input.close();
		Set<Integer> fre = new HashSet<>();//记录中间出现了几种数字
		int[] changed = new int[n];
		for(int i =0;i<n;i++) {
			if(!ra.contains(origin[i])) {
				ra.add(origin[i]);
				changed[i] = -origin[i];
			}else {
				for(int j = i-1;j>=0;j--) {
					if(origin[j] != origin[i]) {
						fre.add(origin[j]);
					}else {
						changed[i] = fre.size();
						break;
					}
				}
				fre.clear();
			}
		}
		StringBuilder reuslt = new StringBuilder();
		for(int i =0;i<n;i++) {
			reuslt.append(changed[i]+" ");
		}
		System.out.println(reuslt.substring(0,reuslt.length()-1));
	}
}
