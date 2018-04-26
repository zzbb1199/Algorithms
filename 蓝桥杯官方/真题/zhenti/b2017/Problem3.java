package problems.zhenti.b2017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem3 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	static float[][] data ;
	static List<String> list = new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:\\projects\\java_project\\Algorithms\\problems\\zhenti\\b2017\\problem3.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;
		while((line =br.readLine())!= null){
			list.add(line.replaceAll(" ", ""));//添加去掉空格
		}
		br.close();
		//填数组
		data  = new float[list.size()][];
		for(int i =0 ;i<list.size();i++){
			data[i] = new float[i+1];
			for(int j = 0;j<=i;j++){
				data[i][j] = list.get(i).charAt(j)-'0';
			}
		}
		//循环计算
		for(int i = 0;i<data.length-1;i++){//控制行
			for(int j = 0;j<=i;j++){//扫描每行
				data[i+1][j] += data[i][j]/2;
				data[i+1][j+1] += data[i][j]/2;
			}
		}
		float [] last = new float[30];
		int blast  = data.length;
		for(int i = 0;i<blast;i++){
			last[i] += data[blast-1][i]/2;
			last[i+1] += data[blast-1][i]/2;
		}
		float[] d = findMaxAndMin(last);
		System.out.println(String.format("%.0f",d[1]/d[0]*2086458231));
	}
	public static float[] findMaxAndMin(float[] data){
		float[] d = new float[2];
		float min = 100000000000.0f;
		float max = 0f;
		for (float f : data) {
			if(min > f){
				min = f;
			}
			if(max < f){
				max = f;
			}
		}
		d[0] = min;
		d[1] = max;
		return d;
		
	}

}
