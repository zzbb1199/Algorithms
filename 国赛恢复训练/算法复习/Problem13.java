package 国赛恢复训练.算法复习;

import java.util.Scanner;

/**
 * Excel单元格的地址表示很有趣，它使用字母来表示列号，比如：
A表示第1列，
B表示第2列，
Z表示第26列，
AA表示第27列，
AB表示第28列，
BA表示第53列，
....
当然Excel的最大列号是有限度的，所以转换起来不难。
如果我们想把这种表示法一般化，可以把很大的数字转换为很长的字母序列呢？

本题目既是要求对输入的数字, 输出其对应的Excel地址表示方式。

例如，
输入：
26
则程序应该输出：
Z

再例如，
输入：
2054
则程序应该输出：
BZZ

我们约定，输入的整数范围[1,2147483647]

 * @author 张兴锐
 *
 */
public class Problem13 {
	public static void main(String[] args) {
		//其实就是进制转化
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		StringBuilder ans = new StringBuilder();
		int rem;
		while(n!=0) {
			rem = n% 26;
			n/=26;
			if(rem == 0) {
				n-=1;
				ans.append("Z");
			}else {
				ans.append((char)('A'+rem-1)+"");
			}
		}
		System.out.println(ans.reverse());
	}
}
