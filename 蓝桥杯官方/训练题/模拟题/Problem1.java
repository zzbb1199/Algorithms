package moni;

public class Problem1 {
	public static void main(String[] args) {
		int count = 0;
		for(int a = 10;a<100;a++){
			for(int b = 10;b<100;b++){
				if(a == (2*(getGe(b)+getShi(b))) &&
				   b == (3*(getGe(a)+getShi(a)))
				){
					count++;
				}
			}
		}
		System.out.println(count);
	}
	static int getGe(int a){
		return a%10;
	}
	static int getShi(int a){
		return a/10;
	}
}
