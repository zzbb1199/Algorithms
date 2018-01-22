package algorithm;

public class BestBinarySearchTree {
	/**
	 * 最优二叉查找树:用于构造字典 动态规划求解 
	 * 需要填的表有两张： 
	 * 主表：填充最优权值 
	 * 根表：填充树的结构
	 */
	/**
	 * 定义节点信息
	 */
	private static float[] nodes = { 0.1f, 0.2f, 0.4f, 0.3f };
	private static int N = nodes.length;
	/**
	 * 主表
	 */
	private static float[][] mainTable = new float[N][N];
	/**
	 * 根表
	 */
	private static int[][] rootTable = new int[N][N];

	public static void main(String[] args) {
		// 初始化表信息
		for (int i = 0; i < mainTable.length; i++) {
			mainTable[i][i] = nodes[i];
			rootTable[i][i] = i;
		}
		// 按对角线进行填表
		for (int d = 1; d < N; d++) {
			for (int i = 0; i < N - d; i++) {
				int j = i + d;
				float minValue = 1000f;// 定义一个较大的数
				int bestK = -1;
				for (int k = i; k <= j; k++) {
					float c;
					if (k == 0) {
						c = mainTable[k + 1][j] + sumWeight(i, j);
					} else if (k == N - 1) {
						c = mainTable[i][k - 1] + sumWeight(i, j);
					} else {
						c = mainTable[i][k - 1] + mainTable[k + 1][j] + sumWeight(i, j);
					}
					if (c < minValue) {
						minValue = c;
						bestK = k;
					}
				}
				mainTable[i][j] = minValue;
				rootTable[i][j] = bestK;
			}
		}
		// 输出结果
		System.out.println("最小权值:" + mainTable[0][N - 1]);

		// 前序遍历
		System.out.println("前序遍历:");
		preOrder(0, N - 1);
	}

	private static void preOrder(int i, int j) {
		if (i > j) {
			return;
		}
		int k = rootTable[i][j];
		System.out.print(k+" ");
		preOrder(i, k - 1);
		preOrder(k + 1, j);

	}

	private static float sumWeight(int from, int to) {
		float sum = 0f;
		for (int i = from; i <= to; i++) {
			sum += nodes[i];
		}
		return sum;
	}

}
