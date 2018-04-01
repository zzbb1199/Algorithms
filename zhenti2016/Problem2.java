package zhenti2016;

public class Problem2 {
	public static void main(String[] args) {
		for(int age = 1;age<=100;age++) {
			int sum = 0;
			for(int end =age;end<=100;end++) {
				sum+=end;
				if(sum == 236) {
					System.out.println(age);
					System.out.println(end);
					return;
				}else if(sum > 236) {
					break;
				}
			}
		}
	}
}
