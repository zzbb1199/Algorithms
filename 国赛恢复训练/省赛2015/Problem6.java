package 国赛恢复训练.省赛2015;
/**
 * 递归遍历，太耗时间
 * @author Raven
 *
 */
public class Problem6 {
	static int[] a = new int[50];
	static int[] b = new int[49];
	public static void main(String[] args) {
		//初始化
		for(int i = 0;i<50;i++) {
			a[i] = i+1;
		}
		f(0);
	}
	public static void f(int index) {
		if(sum(b) > 2) {
			return;
		}
		if(index == 49) {
			if(sum(b) == 2) {
				if(check()) {
					System.out.println(find());
				}
			}
			return;
		}
		for(int i = index;i<49;i++) {
			//变0
			b[i] = 0;
			f(index+1);
			//变1
			b[i] = 1;
			f(index+1);
			//还原
			b[i] = 0;
		}
	}
	private static int find() {
		for(int i = 0;i<49;i++) {
			if(b[i] == 1) {
				return a[i];
			}
		}
		return 0;
	}
	private static boolean check() {
		//检查是否相邻
		boolean isFirst = true;
		int currentIndex = -1;
		for(int i = 0;i<49;i++) {
			if(b[i] == 1 ) {
				if(isFirst) {
					isFirst = false;
					currentIndex = i;
				}else {
					if(i - currentIndex == 1) {
						return false;//相邻
					}else {
						break;
					}
				}
				
			}
		}
		//检查求和
		int sum = a[0];
		for(int i = 0;i<49;i++) {
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
	private static int sum(int[] b2) {
		int count = 0;
		for (int i : b2) {
			count+=i;
		}
		return count;
	}
	
}
