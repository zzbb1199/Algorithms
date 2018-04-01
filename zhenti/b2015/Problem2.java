package zhenti.b2015;
/**
 * 
立方变自身

观察下面的现象,某个数字的立方，按位累加仍然等于自身。
1^3 = 1 
8^3  = 512    5+1+2=8
17^3 = 4913   4+9+1+3=17
...

请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

请填写该数字，不要填写任何多余的内容或说明性的文字。

 * @author 张兴锐
 *
 */
public class Problem2 {
	public static void main(String[] args) {
		int count = 0;
		for(long i = 1;i<=1000*1000*100;i++){
			String s = String.valueOf((long)Math.pow(i, 3));
			long sum = 0;
			for(int j = 0;j<s.length();j++){
				sum+=Integer.valueOf(s.charAt(j)+"");
			}
			if(sum == i){
				System.out.println(i);
				count++;
			}
		}
		System.out.println(count);

	}
	}
