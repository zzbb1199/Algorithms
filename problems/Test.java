package problems;


/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * 
 * @author zxr
 *
 */
public class Test {
	
	public static void main(String[] args) {
		f(0,0);
		System.out.println(count);
	}
	
	static int count;
	static int boundary = 1;
	public static void f(int x,int y){
		if(x == boundary && y == boundary){
			count++;
			return;
		}
		int saveX = x;
		//向下
		x+=1;
		if(x <= boundary){
			f(x,y);
		}
		x = saveX;
		//向右
		y+=1;
		if(y<=boundary){
			f(x,y);
		}
	}
}
