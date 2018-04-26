package problems.base.pratice;
/**
 * 
 * @author zxr
 *对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：

00000

00001

00010

00011

00100

请按从小到大的顺序输出这32种01串。


 */
public class ZeroOne {
	public static void main(String[] args) {
		for(int i = 0;i<32;i++) {
			StringBuilder out = new StringBuilder();
			out.append(Integer.toBinaryString(i));
			//补齐
			while(out.length() != 5){
				out = new StringBuilder("0").append(out);
			}
			System.out.println(out);
		}
	}
}
