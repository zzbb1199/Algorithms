package 国赛恢复训练.省赛2015;

public class Problem2 {
	public static void main(String[] args) {
		int N = 10000;
		int count = 0;
		for(int i = 1;i<=N;i++) {
			if(i == sum((long)Math.pow(i, 3))) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static int sum(long k) {
		int temp = 0;
		String str = k+"";
		for(int i = 0;i<str.length();i++) {
			temp+=Integer.valueOf(str.charAt(i)+"");
		}
		return temp;
	}
}
