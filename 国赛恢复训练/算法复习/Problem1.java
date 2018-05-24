package 国赛恢复训练.算法复习;

public class Problem1 {
	for(int age= 11;age<=100;age++) {
		int age3 = (int) Math.pow(age, 3);
		if(String.valueOf(age3).length() != 4) {
			continue;
		}
		int age4 = (int) Math.pow(age, 4);
		if(String.valueOf(age4).length() != 6) {
			continue;
		}
		String age10 = age3+""+age4;
		if(age10.replaceAll("(.+)\\1", "$1").length() == 10) {
			System.out.println(age);
			return;
		};
	}
}
