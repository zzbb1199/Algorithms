package 国赛恢复训练.省赛2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 递归求解，最多满足60%测试
 * 30%数据通过
 * @author 张兴锐
 *
 */
public class Problem9 {
	static long count = 0;
	static int[] duimian = {0,4,5,6,1,2,3};
	static Map<Integer,List<Integer>> paichi = new HashMap<Integer,List<Integer>>();
	static long n;
	static long base ;
	public static void main(String[] args) {
		//初始化
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		base = (int)Math.pow(4, n);
		int m = input.nextInt();
		for(int i = 0;i<m;i++) {
			int m1 = input.nextInt();
			int m2 = input.nextInt();
			if(paichi.containsKey(m1)) {
				paichi.get(m1).add(m2);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(m2);
				paichi.put(m1, list);
			}
			if(paichi.containsKey(m2)) {
				paichi.get(m2).add(m1);
				
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(m1);
				paichi.put(m2, list);
			}
		}
		input.close();
		
		//模拟开始
		for(int i = 1;i<=6;i++) {
			f(1,duimian[i]);
		}
		System.out.println(count);
	}
	public static void f(int index,int bottom) {
		if(index == n) {
			count = (long) ((count+base) % ( 1E9 + 7 ));
			return;
		}
		//
		List<Integer> list = init();
		List<Integer> p = paichi.get(bottom);
		if(p!=null) {
			list.removeAll(p);
		}
		for (Integer integer : list) {
			f(index+1,duimian[integer]);
		}
	}
	public static List<Integer> init(){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.add(6);
		return list;
	}
	
}
