package 国赛恢复训练.省赛2015;

public class Problem3 {
	public static void main(String[] args) {
		int[] a = {0,1,2,3,4,5,6,7,8,9};
		f(0,a);
	}

	public static void f(int index,int[] a) {
		if (index == 10 ) {
			if (a[0]!=0 && a[4]!=0 &&check(a)) {
				System.out.println("" + a[4] + a[5] + a[6] + a[1]);
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			int t = a[i];
			a[i] = a[index];
			a[index] = t;
			f(index+1,a);
			t = a[i];
			a[i] = a[index];
			a[index] = t;
		}
	}

	private static boolean check(int [] a) {
		int a1 = Integer.valueOf("" + a[0] + a[1] + a[2] + a[3]);
		int a2 = Integer.valueOf("" + a[4] + a[5] + a[6] + a[1]);
		int a3 = Integer.valueOf("" + a[4] + a[5] + a[2] + a[1] + a[7]);
		return a1 + a2 == a3;
	}
}
