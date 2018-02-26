package problems.base.pratice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 * 问题描述
　　Tom教授正在给研究生讲授一门关于基因的课程，有一件事情让他颇为头疼：一条染色体上有成千上万个碱基对，它们从0开始编号，到几百万，几千万，甚至上亿。
　　比如说，在对学生讲解第1234567009号位置上的碱基时，光看着数字是很难准确的念出来的。
　　所以，他迫切地需要一个系统，然后当他输入12 3456 7009时，会给出相应的念法：
　　十二亿三千四百五十六万七千零九
　　用汉语拼音表示为
　　shi er yi san qian si bai wu shi liu wan qi qian ling jiu
　　这样他只需要照着念就可以了。
　　你的任务是帮他设计这样一个系统：给定一个阿拉伯数字串，你帮他按照中文读写的规范转为汉语拼音字串，相邻的两个音节用一个空格符格开。
　　注意必须严格按照规范，比如说“10010”读作“yi wan ling yi shi”而不是“yi wan ling shi”，“100000”读作“shi wan”而不是“yi shi wan”，“2000”读作“er qian”而不是“liang qian”。
 * @author zxr
 *
 */
public class NumberRead {
	
	static Map<Character,String> numMap = new HashMap<>();
	static Map<Integer,String> BigDMap = new HashMap<>();
	static String[] danwei = new String[] {"qian","bai","shi",""};
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String numStr = input.nextLine();
		input.close();
		StringBuilder result = new StringBuilder();
		//初始化映射表
		init();
		int head = numStr.length() % 4;
		int up = (int) Math.ceil((double)numStr.length()/4);
		//先处理顶级数字
		String headNum = numStr.substring(0, head);
		if(headNum.length() >= 2 && headNum.charAt(0) == '1') {
			//对整个数字的首位单独处理
			result.append(addDanwei(0,headNum.length())+" ");
			for(int i = 1;i<headNum.length();i++) {
				if(headNum.charAt(i) != '0') {
					String danwei = addDanwei(i,headNum.length());
					if("".equals(danwei)) {
						result.append(numMap.get(headNum.charAt(i))+" ");	
					}else {
						result.append(numMap.get(headNum.charAt(i))+" "+danwei+" ");	
					}
					}else {
						result.append(numMap.get(headNum.charAt(i))+" ");
					}	
			}
		}else {
			for(int i = 0;i<headNum.length();i++) {
				if(headNum.charAt(i) != '0') {
					String danwei = addDanwei(i,headNum.length());
					if("".equals(danwei)) {
						result.append(numMap.get(headNum.charAt(i))+" ");	
					}else {
						result.append(numMap.get(headNum.charAt(i))+" "+danwei+" ");	
					}
				}else {
					result.append(numMap.get(headNum.charAt(i))+" ");
				}	
			}
		}
		if(head != 0) {
			//加上本级单位
			result.append(BigDMap.get(up)+" ");
		}
		numStr = numStr.substring(head);
		up = (int) Math.ceil((double)numStr.length()/4);
		for(int i = up;i>0;i--) {
			int end = 4*(up-i+1) <= numStr.length()?4*(up-i+1):numStr.length();
 			String num = numStr.substring(+4*(up-i),end);
			for(int j = 0;j<num.length();j++) {
				if(num.charAt(j) != '0') {
					String danwei = addDanwei(j,num.length());
					if("".equals(danwei)) {
						result.append(numMap.get(num.charAt(j))+" ");	
					}else {
						result.append(numMap.get(num.charAt(j))+" "+danwei+" ");	
					}			
				}else {
					result.append(numMap.get(num.charAt(j))+" ");
				}
			}
			result.append(BigDMap.get(i)+" ");
		}
		String rt = result.toString().replaceAll("(ling\\s)\\1+\\s$","$1")
				.replaceAll("ling\\s+$", "").replaceAll("\\s*$", "");
		//去除多余的ling
		System.out.println(rt.replaceAll("(ling )\\1+","$1"));
	}
	private static String addDanwei(int index,int length) {
		return danwei[4-length+index];
	}
	private static void init() {
		// TODO Auto-generated method stub
		numMap.put('0', "ling");
		numMap.put('1', "yi");
		numMap.put('2', "er");
		numMap.put('3', "san");
		numMap.put('4', "si");
		numMap.put('5', "wu");
		numMap.put('6', "liu");
		numMap.put('7', "qi");
		numMap.put('8', "ba");
		numMap.put('9', "jiu");
		
		BigDMap.put(3,"yi");
		BigDMap.put(2, "wan");
		BigDMap.put(1, "");
	}
}
