package algorithm.boyi;

import java.util.Random;

/**
 * 火柴问题
 * 
 * @author zxr
 *
 */
public class Chect {
	/**
	 * 0 可放置，1竖直 2 垂直
	 */
	static int[][] x = new int[4][4];

	public static void main(String[] args) {
		Random r = new Random(System.currentTimeMillis());
		do {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					x[i][j] = r.nextInt(3);
				}
			}
		}while(!temp_check(x));
		// 输出当前局面
		for (int[] x1 : x) {
			for (int i : x1) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		// 求解
		System.out.println(f(x,0));
		
	}
	public static void _clone(int[][] from,int[][] to) {
		for(int i =0;i<4;i++) {
			to[i] = from[i].clone();
		}
	}
	// 赢1 输2 平0
	private static int f(int[][] x,int index) {
		if (!check(x)) {
			return 2;
		}
		if(index == 15) {
			return 0;
		}
		int tag = 2;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if(x[i][j] == 0) {
					//什么都不填
					{
						int y = f(x,index+1);
						if(y == 2) {
							return 1;
						}else if(y == 0) {
							tag = 1;
						}
					}
					
					//竖直放
					int[][] save = new int[4][4];
					if(put(x,i,j,1)) {
						_clone(x,save);
						x[i][j] = 1;
						int y = f(x,index+1);
						if(y == 2) {
							if(index == 0) {
								show(save);
							}
							return 1;
						}else if(y == 0) {
							tag = 1;
						}
						x[i][j] = 0;
					}
					//水平放
					if(put(x,i,j,2)) {
						_clone(x,save);
						x[i][j] = 2;
						int y = f(x,index+1);
						if(y == 2) {
							if(index == 0) {
								show(save);
							}
							return 1;
						}else if(y == 0) {
							tag = 1;
							//保存*****************8
						}
						x[i][j] = 0;
					}
				}
			}
		}
		return tag;
	}
	private static void show(int[][] save) {
		System.out.println();
		for (int[] is : save) {
			for (int i : is) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	static boolean temp_check(int[][] x) {
		for(int i =0;i<4;i++) {
			for(int j = 0;j<4;j++) {
				if(!put(x,i,j,x[i][j])) {
					return false;
				}
			}
		}
		return true;
	}
	static boolean check(int[][] x) {
		// 是否有可放点
		boolean canput = false;
		out: for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (x[i][j] == 0) {
					canput = true;
					break out;
				}
			}
		}
		if (!canput) {
			return false;
		}
		// 检查空位
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (x[i][j] == 0) {
					if (put(x, i, j, 1) || put(x, i, j, 2)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	static boolean put(int[][] x, int i, int j, int value) {
		switch (value) {
		case 1:
			// 上
			for(int k = i-1;k>=0;k--) {
				if(x[k][j] == 0) {
					continue;
				}
				if(x[k][k] == 2) {
					break;
				}
				if(x[k][j] == 1) {
					return false;
				}
			}
			// 下
			for(int k = i+1;k<=3;k++) {
				if(x[k][j] == 0) {
					continue;
				}
				if(x[k][j] == 2) {
					break;
				}
				if(x[k][j] == 1) {
					return false;
				}
			}
			break;
		case 2:
			// 左
			for(int k = j-1;k>=0;k--) {
				if(x[i][k] == 0) {
					continue;
				}
				if(x[i][k] == 1) {
					break;
				}
				if(x[i][k] == 2) {
					return false;
				}
			}
			// 右
			for(int k = j+1;k<=3;k++) {
				if(x[i][k] == 0) {
					continue;
				}
				if(x[i][k] == 1) {
					break;
				}
				if(x[i][k] == 2) {
					return false;
				}
			}
			break;
		}
		return true;
	}
}
