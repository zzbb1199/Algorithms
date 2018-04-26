package problems;

import java.util.Arrays;

public class KnapsackB {

	/**
	 * 0-1背包问题
	 * 使用回溯法
	 */
	//初始化参数
	private static int[] w = {2, 2, 6, 5, 4};
	private static int[] v = {6, 3, 5, 4, 6};
	private static int N = w.length;
	private static float[] p = new float[N];
	private static int c = 10;
	private static int[] currentX = new int[w.length];
	private static int[] bestX = new int[N];
	private static int currentV;
	private static int currentW;
	private static int currentC;
	private static int bestV ;
	
	public static void main(String[] args) {
		//计算一个性价比
		for (int i = 0; i < N; i++) {
			p[i] = (float)v[i]/w[i];
		}
//		currentC = c;
//		System.out.println(bound(2));
		back(0);
		//输出
		System.out.println("max value:"+bestV);
		System.out.println("current solution:"+Arrays.toString(bestX));
	}
	private static void back(int i) {
		if(i == N) {
			//产生一个解
			if(bestV < currentV) {
				bestV = currentV;
				bestX = currentX.clone();
			}
			return;
		}
		//进入左子树
		currentC = c-currentW;
		if(w[i] <= currentC) {
			currentX[i] = 1;
			currentW += w[i];
			currentV += v[i];
			back(i+1);
			currentW -= w[i];
			currentV -= v[i];
			currentC = c-currentW;
		}
		//进入右子树-不加入剪枝函数
//		currentX[i] = 0;
//		back(i+1);
		//进入右子数-加入剪枝函数
		//如果还可能加入的点的可能创造的总价值不能超过之前产生的最优解，则不用进入右子树
		if(currentV + bound(i+1) > bestV) {
			currentX[i] = 0;
			back(i+1);
		}
	}

	private static float bound(int i) {
		if(i == N) {
			return 0;
		}
		float cv = 0;
		int cw = 0;
		int cc = currentC;
		while(cw + w[i] <= cc && i <N) { 
			cw += w[i];
			cv += v[i];
		}
		if(i < N && cc-cw>0) {
			//加入余量
			cv += p[biggestP(i)]*(cc-cw);
		}
		return cv;
	}
	/**
	 * 选择从i-N-1中性价比最高的
	 * @param i
	 * @return
	 */
	private static int biggestP(int i) {
		int maxV = 0;
		int maxIndex = -1;
		for(;i<N;i++) {
			if(maxV < v[i]) {
				maxV = v[i];
				maxIndex = i;
			}
		}
		return maxIndex; 
	}
}
