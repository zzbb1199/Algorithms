package problems.base.pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Huffman树在编码中有着广泛的应用。在这里，我们只关心Huffman树的构造过程。
　　给出一列数{pi}={p0, p1, …, pn-1}，用这列数构造Huffman树的过程如下：
　　1. 找到{pi}中最小的两个数，设为pa和pb，将pa和pb从{pi}中删除掉，然后将它们的和加入到{pi}中。这个过程的费用记为pa + pb。
　　2. 重复步骤1，直到{pi}中只剩下一个数。
　　在上面的操作过程中，把所有的费用相加，就得到了构造Huffman树的总费用。
　　本题任务：对于给定的一个数列，现在请你求出用该数列构造Huffman树的总费用。
 * @author zxr
 *例如，对于数列{pi}={5, 3, 8, 2, 9}，Huffman树的构造过程如下：
　　1. 找到{5, 3, 8, 2, 9}中最小的两个数，分别是2和3，从{pi}中删除它们并将和5加入，得到{5, 8, 9, 5}，费用为5。
　　2. 找到{5, 8, 9, 5}中最小的两个数，分别是5和5，从{pi}中删除它们并将和10加入，得到{8, 9, 10}，费用为10。
　　3. 找到{8, 9, 10}中最小的两个数，分别是8和9，从{pi}中删除它们并将和17加入，得到{10, 17}，费用为17。
　　4. 找到{10, 17}中最小的两个数，分别是10和17，从{pi}中删除它们并将和27加入，得到{27}，费用为27。
　　5. 现在，数列中只剩下一个数27，构造过程结束，总费用为5+10+17+27=59。
 */
public class HuffmanTree {
	static int n;
	//保存原有数据
	static List<Integer> origin = new ArrayList<>();
	//记录费用
	static List<Integer> comsum = new ArrayList<>();
 	public static void main(String[] args) {
		// TODO Auto-generated method stub
 		Scanner input = new Scanner(System.in);
 		n = input.nextInt();
 		for(int i = 0;i<n;i++) {
 			origin.add(input.nextInt());
 		}
 		input.close();	
 		
 		Collections.sort(origin);	//排序一次
 		
 		while(origin.size() != 1) {
 			int m1 = origin.get(0);
 			int m2 = origin.get(1);
 			origin.remove(0);
 			origin.remove(0);
 			
 			int m = m1+m2;
 			comsum.add(m);
 			insert(m);
 		}
 		//输出总费用
 		int sum = 0;
 		for(int v:comsum) {
 			sum+=v;
 		}
 		System.out.println(sum);
	}
 	public static void insert(int value) {
 		for(int i = 0;i<origin.size();i++) {
 			if(origin.get(i) >= value) {
 				origin.add(i,value);
 				return;
 			}
 		}
 		origin.add(origin.size(), value);
 	}

}
