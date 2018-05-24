package 国赛恢复训练.算法复习;

public class Problem7 {
	public static void main(String[] args) {
		for(int i = 1;i<=100;i++) {
			f(i);
		}
	}
	public static void f(int value) {
		int x = value;
		StringBuilder ans = new StringBuilder();
		for(int i = 0 ;value!= 0;i++) {
			int rem = value % 3;
			value = value/3;
			if(rem == 2) {
				ans.append((int)Math.pow(3, i)+"-");
				value += 1;
			}else if(rem == 1) {
				ans.append((int)Math.pow(3, i)+"+");
			}
			
		}
		System.out.println(x+" "+ans.reverse().substring(1));
	}
}
