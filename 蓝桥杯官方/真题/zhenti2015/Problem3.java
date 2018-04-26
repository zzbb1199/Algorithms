package zhenti.b2015;

import java.util.HashSet;
import java.util.Set;

public class Problem3 {
	public static void main(String[] args) {
		Set<Integer> sets = new HashSet<Integer>();
		for(int a1 = 1;a1<=9;a1++){
			for(int a2=0;a2<=9;a2++){
				for(int a3 = 0;a3<=9;a3++){
					for(int a4= 0;a4<=9;a4++){
						for(int a5 = 1;a5<=9;a5++){
							for(int a6 = 0;a6<=9;a6++){
								for(int a7 = 0;a7<=9;a7++){
									for(int a8 = 0;a8<=9;a8++){
										sets.add(a1);
										sets.add(a2);
										sets.add(a3);
										sets.add(a4);
										sets.add(a5);
										sets.add(a6);
										sets.add(a7);
										sets.add(a8);
										if(sets.size() != 8){
											sets.clear();
											continue;
										}
										int up = Integer.valueOf(""+a1+a2+a3+a4);
										int down = Integer.valueOf(""+a5+a6+a7+a2);
										if(up+down == Integer.valueOf(""+a5+a6+a3+a2+a8)){
											System.out.println(a5);
											System.out.println(a6);
											System.out.println(a7);
											System.out.println(a2);
											return;
										}
									}
									
								}
							}
						}
					}
				}
			}
		}
	}
}
