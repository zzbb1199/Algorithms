package problems;
import java.util.Scanner;

/**
 * 符号三角形
 * 符号三角形输入n，共n行，所有个数共n*(n+1)/2
 * 基于上述特点，可以设计剪枝函数，当某种符号超过总量的一半时即不用在继续向下深入了
 * @author 张兴锐
 *
 */
public class SymbolicTriangle {

	static int n;
	static int total;
	static int count;//记录总共有多少种符合条件的三角形
	static int[][] triangle;
	static int[] x;//记录第一行
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		input.close();
		total = n*(n+1)/2;
		count = 0;
		triangle = new int[n][n];
		x = new int[n];
		back(0);
		if(count == 0) {
			System.out.println("No Solution");
		}
	}
	/**
	 * 回溯法
	 */
	public static void back(int i) {
		if(i == n) {
			//递归出口
			//生成了第一行的数据，进行赋值和检验
			if(generate(x)) {
				System.out.println("solution:"+(++count));
				outPut(0);//递归输出,当然也可以不这样输入，直接套用循环
			}
			return;
		}
		//进入左子树
		x[i] = 1;
		back(i+1);
		//进入右子树
		x[i] = 0;
		back(i+1);
	}
	private static void outPut(int i) {
		if(i == n) {
			return;
		}
		
		StringBuilder rest = new StringBuilder();
		for(int k = 0;k<i;k++) {
			rest.append(" ");
		}
		System.out.print(rest);
		for(int k = 0;k<n-i;k++) {
			System.out.print(triangle[i][k]+" ");
		}
		System.out.println();
		outPut(i+1);
		
	}
	
	/**
	 * 根据第一行的生成项来生成整个三角形
	 * 可以使用剪枝来减少生成
	 * @param x 第一行的数据
	 */
	private static boolean generate(int[] x) {
		//使用克隆，而不是直接赋值，避免由于x的更改，
		//triangle也随之而改。但是只有当x中的数据是基本数据类型时，写成克隆才有效，因为java中的克隆都是浅克隆
		triangle[0] = x.clone();
		for (int i = 1; i < n; i++) {
			for(int j = 0;j<n-i;j++) {
				triangle[i][j] = triangle[i-1][j] ^ triangle[i-1][j+1] ^ 1;//一次异或后与1异或表示两元素的同或
				
			}
			//写在外层，避免多次调用
			if(cutSuccess(i)) {
				return false;
			}
			
		}
		
		return true;
	}
	
	/**
	 * 剪枝函数
	 * @return
	 */
	private static boolean cutSuccess(int k) {
		int zeroNum = 0;
		int oneNum = 0;
		for (int i = 0; i <= k; i++) {
			for (int j = 0; j < n-i; j++) {
				if(triangle[i][j] == 1){
					oneNum++;
				}else {
					zeroNum++;
				}
			}
		}
		if(oneNum > total/2 || zeroNum > total/2) {
			return true;
		}
		return false;
	}

}
