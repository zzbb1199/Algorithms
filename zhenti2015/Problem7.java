package zhenti2015;
/**
 * 
 * @author zxr
 *
 */
public class Problem7 {
	static int[] data = new int[13];
	static int[] current = new int[13];
	static int count;
	public static void main(String[] args) {
		for(int i = 0;i<data.length;i++) {
			data[i] = 4;
		}
		f(0);
		System.out.println(count);
	}
	public static void f(int index) {
		if(sum() == 13) {
			count++;
			return;
		}
		if(index == 13) {
			return;
		}
		for(int i = 0;i<=data[index];i++) {
			current[index] = i;
			f(index+1);
		}
	}
	private static int sum() {
		int sum = 0;
		for(int i =0;i<current.length;i++) {
			sum+=current[i];
		}
		return sum;
	}
}
