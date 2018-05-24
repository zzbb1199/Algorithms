package 国赛恢复训练.省赛2015;

public class Problem7 {
	static int count = 0;
	static int[] b = new int[13];
	public static void main(String[] args) {
		f(0);
		System.out.println(count);
	}
	public static void f(int index) {
		int s = sum();
		if(s > 13) {
			return;
		}else if(s == 13) {
			count++;
			return;
		}
		if(index == 13) {
			return;
		}
		for(int i = 0;i<=4;i++) {
			b[index] = i;
			f(index+1);
		}
		//回溯
		b[index] = 0;
		
	}
	public static int sum() {
		int sum = 0;
		for (int i : b) {
			sum+=i;
		}
		return sum;
	}
}
