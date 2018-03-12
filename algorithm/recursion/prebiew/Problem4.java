package algorithm.recursion.prebiew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
匪警请拨110,即使手机欠费也可拨通！
为了保障社会秩序，保护人民群众生命财产安全，警察叔叔需要与罪犯斗智斗勇，因而需要经常性地进行体力训练和智力训练！

某批警察叔叔正在进行智力训练：
1 2 3 4 5 6 7 8 9 = 110

请看上边的算式，为了使等式成立，需要在数字间填入加号或者减号（可以不填，但不能填入其它符号）。之间没有填入符号的数字组合成一个数，例如：12+34+56+7-8+9 就是一种合格的填法；123+4+5+67-89 是另一个可能的答案。

请你利用计算机的优势，帮助警察叔叔快速找到所有答案。
每个答案占一行。形如：
12+34+56+7-8+9
123+4+5+67-89
......
 * @author zxr
 *
 */
public class Problem4 {
	static List<int[]> answer = new ArrayList<>();
	static int[] current = new int[8];
	
	public static void main(String[] args) {
		deep(0);
		//检验解
		Iterator<int[]> iter = answer.iterator();
		StringBuilder fomular;
		int[] constant = {2,3,4,5,6,7,8,9};
		int sum ;
		while(iter.hasNext()) {
			fomular = new StringBuilder("1");
			int[]  c = iter.next();
			for(int i = 0;i<c.length;i++) {
				if(c[i] == 0) {
					fomular.append(constant[i]);
				}else if(c[i] == 1) {
					fomular.append("+"+constant[i]);
				}else if(c[i] == 2) {
					fomular.append("-"+constant[i]);
				}
			}
			//检验算式
			String[] value = fomular.toString().split("[+-]");
			sum = Integer.valueOf(value[0]);
			int k =1;
			for(int i =0;i<c.length;i++) {
				if(c[i] == 0) {
				}else if(c[i] == 1) {
					sum+=Integer.valueOf(value[k]);
					k++;
				}else if(c[i] == 2) {
					sum-=Integer.valueOf(value[k]);
					k++;
				}
			}
			if(sum != 110) {
				iter.remove();
			}else {
				System.out.println(fomular);
			}
		}
		System.out.println(answer.size());
	}
	public static void deep(int index) {
		if(index == 8) {
			answer.add(current.clone());
			return;
		}
		//填空 0 代表空白， 1代表+ 2代表-
		current[index] = 0;
		deep(index+1);
		
		current[index] = 1;
		deep(index+1);
		
		current[index] = 2;
		deep(index+1);
	}
}
