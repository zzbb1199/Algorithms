import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Problem10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[] pre = new int[n];
		for(int i = 0;i<pre.length;i++) {
			pre[i] = input.nextInt();
		}
		input.close();
		int[] change = new int[n];
		Set<Integer> hasMeetSet = new HashSet<>();
		for(int i = 0;i<pre.length;i++){
			//按照规则进行变换
			if(hasMeetSet.contains(pre[i])) {
				//包含
				//寻找最后一个出现的本元素的位置
				Set<Integer> sets = new HashSet<>();
				for(int j = i-1;j>=0;j--) {
					if(pre[i] == pre[j]) {
						//找到，统计之间出现了一种元素
						for(int k = j+1;k<i;k++) {
							sets.add(pre[k]);
						}
						break;
					}
				}
				change[i] = sets.size();
			}else {
				//未出现
				hasMeetSet.add(pre[i]);
				change[i] = -pre[i];
			}
		}
		System.out.println(Arrays.toString(change));
	}
}
