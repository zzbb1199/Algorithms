package moni;

import java.util.Scanner;

public class Problem5 {

	public static final int N = 1000;
	public static char[] str = new char[N];
	public static char[] buf = new char[N];
	public static int[] vis = new int[N];
	public static int total = 0;
	public static int len = 0;

	public static void arrange(int num) {
	        if (num == len) {
	            for (int i = 0; i < len; ++i) {
	                System.out.print(buf[i]);
	            }
	            System.out.println();
	            total++;
	            return;
	        }
	        for (int i = 0; i < len; ++i) {
	            if (vis[i] == 0) {
	                int j = 0;
	                for (j = i + 1; j < len; ++j) {
	                    if (str[i] == str[j] && vis[j] == 1) {
	                        break;
	                    }
	                }
	                if (j == len) {
	                    vis[i] = 1;
	                    buf[num] = str[i];
	                    arrange(num + 1);
	                    vis[i]= 0;
	                }
	            }
	        }
	    }

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		str = cin.next().toCharArray();
		total = 0;
		len = str.length;
//		buf[len] = '\0';
//		int i = 0, j = 0;
//		for (i = 0; i < len; ++i) {
//			for (j = i + 1; j < len; ++j) {
//				if (str[i] > str[j]) {
//					char tmp = str[i];
//					str[i] = str[j];
//					str[j] = tmp;
//				}
//			}
//		}
		arrange(0);
		System.out.println("Total " + total);
	}

}
