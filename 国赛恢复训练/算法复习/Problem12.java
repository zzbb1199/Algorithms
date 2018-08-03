package 国赛恢复训练.算法复习;
/**
 * 博弈论暴力破解
 * @author Raven
 *
 */
public class Problem12 {
	static int[] data = {1,3,7,8};
	public static void main(String[] args) {
		
		int N = 50;
		long start = System.currentTimeMillis();
		//动态规划求解
		boolean[] ans = new boolean[N+1];
		ans[0] = false;ans[1] = false;ans[2] = true;//初始化几个
		for(int i = 3;i<=N;i++) {
			boolean t = false;
			for(int k = 0;k<data.length;k++) {
				if(i>data[k] && ans[i-data[k]] == false) {
					t = true;
					ans[i] = true;
				}
			}
			if(!t) {
				ans[i] = false;
			}
		}
		//输出
		for(int i = 1;i<=N;i++) {
			System.out.println(ans[i]);
		}
		System.out.println(System.currentTimeMillis()-start);
		
		start = System.currentTimeMillis();
		for(int i = 1;i<=N;i++) {
			System.out.println(f(i));
		}
		System.out.println(System.currentTimeMillis() - start);
	
	}
	static boolean f(int n) {
		for(int  i = 0;i<data.length;i++) {
			if(n > data[i]) {
				boolean t = f(n-data[i]);//拿子后，对方棋况
				if(t == false) {
					return true;
				}
			}else {
				break;
			}
		}
		//所有棋局走完，都无法获胜
		return false;
	}
}
