package problems.base.pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 有n（2≤n≤20）块芯片，有好有坏，已知好芯片比坏芯片多。
　　每个芯片都能用来测试其他芯片。用好芯片测试其他芯片时，能正确给出被测试芯片是好还是坏。而用坏芯片测试其他芯片时，会随机给出好或是坏的测试结果（即此结果与被测试芯片实际的好坏无关）。
　　给出所有芯片的测试结果，问哪些芯片是好芯片。
 * @author zxr
 *
 */
public class ChipTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//输入
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int[][] origin = new int[n][n];
		 List<Integer> bad = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<n;j++) {
				origin[i][j] = input.nextInt();
			}
		}
		input.close();
	
		 //step1 按列进行统计
		 int size = origin.length;
		 int[] s = new int[size];
		 for(int i = 0;i<size;i++){
			 for(int j = 0;j<size;j++) {
				 s[i]+=origin[j][i];
			 }
			 s[i]-=origin[i][i];	//减去多加上的本位
		 }

		//如果统计为正的数量大于等于了一半，那么该芯片一定为好芯片
		 for(int i = 0;i<size;i++) {
			 if(s[i]<Math.floor((float)size/2)) {
				 bad.add(i);
			 }
		 }
		 //step2 输出尝试
		 //生成全解
		 List<Integer> solution = new ArrayList<>();
		 for(int i = 0;i<n;i++) {
			 solution.add(i);
		 }
		 //删除错误芯片
		 for(int i = 0;i<bad.size();i++) {
			 solution.remove(bad.get(i));
		 }
		 //输出
		 StringBuilder result = new StringBuilder();
		 for (Integer integer : solution) {
			result.append((integer+1)+" ");
		}
		 System.out.println(result.toString().substring(0, result.length()-1));
	}	
}
