package 国赛恢复训练.算法复习;

public class Problem2 {
	public static void main(String[] args) {
		System.out.println(f(3,2,0));
		System.out.println(f(3,2));
	}
	/**
	 * 
	 * @param m 0.5元的人数
	 * @param n 1元的人数
	 * @param sum 当前售票员手中的钱
	 * @return
	 */
	public static int f(int m,int n,double sum) {
		if(m + sum/0.5 < n) {
			return 0;
		}
		if(n == 0 ||m == 0) {
			return 1;
		}
	
		int count = 0;
		//放1
		if(sum - 0.5 >= 0) {
			count+=f(m,n-1,sum-0.5);
		}
		//放0
		return count+f(m-1,n,sum+0.5);
	}
	
	public static int f(int m,int n) {
		if(m < n) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		return f(m-1,n)+f(m,n-1);
	}
	
}

