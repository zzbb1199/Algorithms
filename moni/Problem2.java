package moni;

public class Problem2 {
	public static void main(String[] args) {
		int[] a = new int[1000];
		for(int i = 1;i<=1000;i++){
			if(i % 3 == 0){
				a[i-1] = a[i-1]^1;
			}
			if(i % 5 == 0){
				a[i-1] = a[i-1]^1;
			}
			if(i % 7 == 0){
				a[i-1] = a[i-1]^1;
			}
		}
		int count = 0;
		for (int i : a) {
			if(i == 0){
				count++;
			}
		}
		System.out.println(count);
	}
}
