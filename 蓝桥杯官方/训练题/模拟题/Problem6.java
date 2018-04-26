package moni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
	static int[][] loc = {
		{-1,2,6,-1,-1,-1,-1,-1,-1},
		{-1,-1,-1,5,-1,2,-1,-1,4},
		{-1,-1,-1,1,-1,-1,-1,-1,7},
		{-1,3,-1,-1,2,-1,1,8,-1},
		{-1,-1,-1,3,-1,9,-1,-1,-1},
		{-1,5,4,-1,1,-1,-1,-1,7,-1},
		{5,-1,-1,-1,-1,1,-1,-1,-1},
		{6,-1,-1,9,-1,7,-1,-1,-1},
		{-1,-1,-1,-1,-1,-1,7,5,-1}
	};
	public static void main(String[] args) {
		try {
			f(0);
		} catch (Exception e) {
		}
	}
	static void f(int num) throws Exception{
		if(num == -1){
			return ;
		}
		int i = num/9;
		int j = num%9;
		if(i == 8 && j == 8){
			//填充最后一个
			List<Integer> can_use = findCanUse(i,j);
			if(can_use.size() == 0){
				return ;
			}else{
				loc[i][j] = can_use.get(0);
				//输出
				outPut();
				throw new Exception("find a answer");
			}
		}
		List<Integer> can_use = findCanUse(i,j);
		if(can_use.size() == 0){
			return;
		}else{
			for (int t : can_use) {
				loc[i][j] = t;
				//向右走
				int next = findNextNum(num);
				f(next);
				loc[i][j] = -1;
			}
		}
		
	}
	private static int findNextNum(int current){
		current++;
		while(current <= 80){
			int i  = current/9;
			int j = current %9;
			if(loc[i][j] == -1){
				return current;
			}
			current++;
		}
		return -1;
	}
	private static void outPut() {
		for(int[] is:loc){
			System.out.println(Arrays.toString(is));
		}
	}
	static List<Integer> findCanUse(int i,int j){
		List<Integer> list = initList();
		try{
			//按行扫描
			for(int col = 0;col<9;col++){
				if(loc[i][col]!=-1){
					list.remove(new Integer(loc[i][col]));
				}
			}
			//按列扫描
			for(int row = 0;row<9;row++){
				if(loc[row][j] != -1){
					list.remove(new Integer(loc[row][j]));
				}
			}
			//小方格扫描
			int row_start = i/3*3;
			int row_end = i/3*3+2;
			int col_start = j/3*3;
			int col_end = j/3*3+2;
			for(int row = row_start;row<=row_end;row++){
				for(int col = col_start;col<=col_end;col++){
					if(loc[row][col] != -1){
						list.remove(new Integer(loc[row][col]));
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	static List<Integer> initList(){
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1;i<=9;i++){
			list.add(i);
		}
		return list;
	}
	
}
