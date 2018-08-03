package problems.zhenti.b2017;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * k区间
 * @author Raven
 *
 */
public class Problem10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		int[] data = new int[N];
		for(int i = 0;i<data.length;i++){
			data[i] = input.nextInt();
		}
		//计算前缀和
		int[] sum = new int[N];
		int count = 0;
//		sum[0] = data[0];
//		for(int i =1;i<data.length;i++){
//			sum[i]=(sum[i-1]+data[i]);
//		}
//		
//		//求相同数
//		for(int i =0;i<data.length;i++){//首位移动指针
//			if(sum[i] % K == 0){
//				count++;
//			}
//			for(int j = i+1;j<data.length;j++){
//				if((sum[j]-sum[i]) % K == 0){
//					count++;
//				}
//			}
//		}
//		System.out.println(count);
		//上述解法 时间复杂度O(n^2)
		sum[0] = data[0] % K;
		for(int i =1;i<data.length;i++){
			sum[i] = (sum[i-1]+data[i]) % K;
		}
	
		Map<Long,Integer> maps = new HashMap<Long,Integer>();
		for (long l : sum) {
			if(maps.containsKey(l)){
				maps.put(l,maps.get(l)+1);
			}else{
				maps.put(l, 1);
			}
		}
		//最后遍历maps
		for (int v : maps.values()) {
			count+=v;
		}
		System.out.println(count+maps.get(0L));
	}
}
