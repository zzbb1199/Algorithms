package 国赛恢复训练.算法复习;
/**
 * 不定方程求解
 * 15x+11y = 100
 * @author 张兴锐
 *
 */
public class Problem11 {
	public static void main(String[] args) {
		//方法一
		for(int y = -100;y<=100;y++) {
			if((100-11*y) % 15 == 0) {
				System.out.println("x="+(100-11*y) /15+" y="+y);
			}			
		}
		//方法二，欧几里得扩展公式
		int[] xy = e_gcd(15,11);
		System.out.println("x="+(100*xy[0]+" y="+(100*xy[1])));
		//求解x的最小正解
		int x = xy[0];
		if(x > 0) {
			while(x>0) {
				x-=11;
			}
			System.out.println(x+11);
		}else {
			while(x<0) {
				x+=11;
			}
			System.out.println(x-11);
		}
		
	}
	public static int[] e_gcd(int a,int b) {
		if(b == 0) {
			return new int[] {1,0};
		}
		int[] ans = e_gcd(b,a%b);
		int t = ans[0];
		ans[0] = ans[1];
		ans[1] = t - a/b*ans[1];
		return ans;
	}
}
