package problem.zhenti.b2016;


public class Problem6 {
	static int[] x = { 11,0,1, 2, 3, 4, 5, 6, 7, 8, 9,11 };
	static int count = 0;
	static int[][] m = new int[5][6];
	public static void main(String[] args) {
		//初始化
		for(int j =0;j<6;j++){
			m[0][j] = -10;
			m[4][j] = -10;
		}
		for(int i = 0;i<5;i++){
			m[i][0] = -10;
			m[i][5] = -10;
		}
		deep(1);
		System.out.println(count);
	}

	private static void deep(int index) {
		// TODO Auto-generated method stub
		if(index == 11){
			if(check()){
				count++;
			}
			return;
		}
		for(int i = index;i<=10;i++){
			int t = x[index];
			x[index] = x[i];
			x[i] = t;
			deep(index+1);
			t = x[index];
			x[index] = x[i];
			x[i] = t;
		}
	}

	private static boolean check() {
		//填表
		int k = 0;
		for(int i = 1;i<=3;i++){//行
			for(int j = 1;j<=4;j++){//列
				m[i][j] = x[k];
				k++;
			}
		}
		for(int i = 1;i<=3;i++){//行
			for(int j = 1;j<=4;j++){//列
				if((int)Math.abs(m[i][j] - m[i-1][j])== 1 
						|| (int)Math.abs(m[i][j] - m[i+1][j]) == 1
						||	(int)Math.abs(m[i][j] - m[i][j-1]) == 1
						|| (int)Math.abs(m[i][j] - m[i][j+1]) == 1
						|| (int)Math.abs(m[i][j] - m[i-1][j-1]) == 1
						|| (int)Math.abs(m[i][j] - m[i+1][j+1]) == 1
						|| (int)Math.abs(m[i][j] - m[i-1][j+1]) == 1
						|| (int)Math.abs(m[i][j] - m[i+1][j-1]) == 1
						){
					return false;
				}
			}
		}
		return true;
	}
}
