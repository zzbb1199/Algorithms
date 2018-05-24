package 国赛恢复训练.算法复习;
/**
 * 0 1 背包问题
 * @author 张兴锐
 *
 */
public class Problem17 {
	static int[] w = new int[] {0,3,5,1,2,4,123};
	static int[] v = new int[] {0,4,5,1,2,12,4};
	static int c = 10;
	static int N = w.length;
	public static void main(String[] args) {
		//DP求解
		int[][] dp = new int[N][c+1];
		//清空
		for(int i = 0;i<N;i++) {
			dp[i][0] = 0;
		}
		for(int i = 0;i<c+1;i++) {
			dp[0][i] = 0;
		}
		//dp开始
		for(int i = 1;i<N;i++) {
			for(int j = 1;j<=c;j++) {
				if(j<w[i]) {
					//不可放置i
					dp[i][j] = dp[i-1][j];
				}else {
					//可放置
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j-w[i]]+v[i]);
				}
			}
		}
		//输出
		System.out.println(dp[N-1][c]);
		//找到放置了哪些物品
		int i = N-1;
		int j = c;
		StringBuilder ans = new StringBuilder();
		while(i != 0) {
			if(dp[i][j] == dp[i-1][j]) {
				//相同，则未放置i
				i--;
			}else {
				//不同，防止了i
				ans.append(i+" ");
				j-=w[i];
				i--;
			}
		}
		System.out.println(ans.reverse().substring(1));
	}
}
