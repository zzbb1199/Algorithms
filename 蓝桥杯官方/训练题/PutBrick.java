package 蓝桥杯官方.训练题;
/**
 * 铺瓷砖
 * 一长度为N(1<=Ｎ<=10)的地板，给定两种不同瓷砖：一种长度为1，另一种长度为2，数目不限。要将这个长度为N的地板铺满，一共有多少种不同的铺法？
　　例如，长度为4的地面一共有如下5种铺法：
　　4=1+1+1+1
　　4=2+1+1
　　4=1+2+1
　　4=1+1+2
　　4=2+2
 * @author zxr
 *
 */
public class PutBrick {
	
	public static void main(String[] args) {
		System.out.println(f1(4));
	}
	static int f1(int n){
		if(n == 0){
			return 1;
		} 
		if(n< 0){
			return 0;
		}
		return f1(n-1)+f1(n-2);
	}
	
}
