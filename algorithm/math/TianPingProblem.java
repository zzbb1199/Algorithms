package algorithm.math;

public class TianPingProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i =1;i<100;i++) {
			System.out.println(i+":"+f(i));
		}

	}

	public static String f(int value) {
		String ans = "";
		int sh = value / 3;
		int k = 0;
		while (value != 0) {
			if (value % 3 == 2) {
				sh++;
				ans = "-" + ((int)Math.pow(3, k)) + ans;
			} else if (value % 3 == 1) {
				ans = "+" + ((int)Math.pow(3, k)) + ans;
			} else if (value % 3 == 0) {
//				ans = ans;
			}
			value = sh;
			sh = value / 3;
			k++;
		}

		return ans.substring(1);
	}

}
