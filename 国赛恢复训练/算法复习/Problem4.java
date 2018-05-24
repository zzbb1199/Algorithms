package 国赛恢复训练.算法复习;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 重复字母的组合问题
 * @author 张兴锐
 *
 */
public class Problem4 {
	public static void main(String[] args) {
		String origin = "AABBBCCCDDEF";
		//为了完整性，这里采用动态来记录
		Set<Character> sets = new HashSet<Character>();
		for (char c : origin.toCharArray()) {
			sets.add(c);
		}
		int[] data = new int[sets.size()];
		current = new int[sets.size()];
		for (char c : origin.toCharArray()) {
			data[c - 'A']++; //注意，这里只针对字母
		}
		f(data,0,4);
	}
	static int [] current ;
	public static void f(int[] data,int index,int target) {
		if(sum() == target) {
			System.out.println(Arrays.toString(current));
			return;
		}
		if(index == data.length) {
			return;
		}
		for(int i = 0;i<=data[index];i++) {
			current[index] = i;
			f(data,index+1,target);
		}
		//回溯
//		current[index] = 0;
	}
	public static int sum() {
		int s = 0;
		for (int i : current) {
			s+=i;
		}
		return s;
	}
	
}
