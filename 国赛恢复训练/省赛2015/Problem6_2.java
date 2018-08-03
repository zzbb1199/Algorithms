package 国赛恢复训练.省赛2015;
/**
 * 循环解法
 * @author Raven
 *
 */
public class Problem6_2 {
	static int[] a= new int[49];
	static int[] b = new int[48];
	public static void main(String[] args) {
		for(int i = 0;i<49;i++) {
			a[i] = i+1;
		}
		System.out.println();
		for(int i1 = 0;i1<46;i1++) {
			for(int i2 =i1+2;i2<48;i2++) {
				if(i2 - i1 == 1) {
					continue;
				}
				b[i1] = 1;
				b[i2] = 1;
				if(check()) {
					find();
				}
				b[i1] = 0;
				b[i2] = 0;
			}
		}
	}
	private static void find() {
		boolean isFirst = true;
		for(int i = 0;i<48;i++) {
			if(b[i] == 1) {
				if(isFirst) {
					System.out.print(a[i]+" ");
				}else {
					System.out.println(a[i]);
					return;
				}
			}
		}
		return;
	}
	private static boolean check() {
		int sum = a[0];
		for(int i = 0;i<48;i++) {
			if(b[i] == 0) {
				sum+=a[i+1];
			}else {
				sum-=a[i];
				sum+=(a[i]*a[i+1]);
			}
			if(b[i] > 2015) {
				return false;
			}
		}
		return sum == 2015;
	}
}
