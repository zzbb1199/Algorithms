package 蓝桥杯官方.国赛.真题2014;

public class Problem2_1 {
	static int N = 1367631/3*2;
	static int[] odd = new int[N];
	static int target =111*111*111;
	public static void main(String[] args) {
		odd[0] = 1;
		for(int i = 1;i<N;i++) {
			odd[i] = odd[i-1]+2;
		}
		int sum = 0;
		for(int i = 0;i<N;i++) {
			sum = 0;
			sum+=odd[i];
			for(int j = i+1;j<N;j++) {
				sum+=odd[j];
				if(sum > target) {
					break;
				}else if(sum == target){
					System.out.println(sum);
					System.out.println(odd[i]);
					System.out.println(odd[j]);
				}
			}
		}
	}
}
