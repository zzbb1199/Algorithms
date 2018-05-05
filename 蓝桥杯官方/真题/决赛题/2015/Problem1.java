

public class Problem1 {
	public static void main(String[] args) {
		int count = 0;
		for(int i1 = 1;i1<=9;i1++){
			for(int i2=0;i2<=9;i2++){
				for(int i3=0;i3<=9;i3++){
					if(i1 > i2 && i2>i3){
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
