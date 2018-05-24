package 国赛恢复训练.算法复习;
/**
 * 尼姆堆 博弈论
 * @author 张兴锐
 * 先手是否能赢
 */
public class Problem15 {
	public static void main(String[] args) {
		int[] data = {3,4,5};
		System.out.println(f(data));
	}
	
	public static boolean f(int[] data) {
		int x = 0;
		for(int i = 0;i<data.length;i++) {
			x^=data[i];
		}
		if(x == 0) {
			return false;
		}else {
			//输出下一步
			for(int i = 0;i<data.length;i++) {
				if((data[i]^x) < data[i]) {
					System.out.println("从第"+i+"堆中拿走"+(data[i]-data[i]^x));
				}
			}
			return true;
		}
	}
}
