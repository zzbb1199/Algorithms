package moni;

public class Problem3 {
	public static void main(String[] args) {
		int count = 0;
		for(int i = 1;i<=100000;i++){
			if(check(i)){
				count++;
			}
		}
		System.out.println(count);
	}
	static boolean check(int i){
		char[] x = String.valueOf(i).toCharArray();
		char min = findMin(x);
		int minIndex = -1;
		for(int j = 0;j<x.length;j++){
			if(x[j] == min){
				minIndex = j;
				break;
			}else{
				if(x[j] <= x[j+1]){//在遇到最小值之前，都是递减的，所以出现递增情况一定有问题
					return false;
				}
			}
		}
		if(minIndex == 0 || minIndex == x.length-1){
			return false;
		}
		for(int j = minIndex;j<x.length;j++){
			if(j == x.length-1){
				return true;
			}
			if(x[j] >= x[j+1]){//后面一定是递增，一旦出现减的情况，一定出现问题
				return false;
			}
		}
		return true;
	}
	
	static char findMin(char[] x){
		char c = '9';
		for (char t : x) {
			if(t<c){
				c = t;
			}
		}
		return c;
	}
}
