package 国赛恢复训练.算法复习;

public class Problem6 {
	public static void main(String[] args) {
		String reuslt = Integer.toString(1000*1000,7);
		int sum = 0;
		for (char c : reuslt.toCharArray()) {
			sum+= (c - '0');
		}
		System.out.println(sum);
	}
}
 