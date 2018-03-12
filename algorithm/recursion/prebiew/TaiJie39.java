package algorithm.recursion.prebiew;
/**
 * 39台阶
 * @author zxr
 *
 */
public class TaiJie39 {
	static int status ;//0 左脚 1 右脚
	static int count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		status = 1;//因为首先迈左脚，所以现在的状态为右脚
		deep(0);
		System.out.println(count);
	}
	public static void deep(int current) {
		if(current >= 39) {
			if(status == 1) {
				count++;
			}
			return;
		}
		if(status == 0) {
			//现在上右脚
			status = 1;
			//上一步
			int temp = current;
			deep(current+1);
			current = temp;
			
			//再上两不
			deep(current+2);
			current = temp;
			status = 0;
		}
		if(status == 1) {
			//现在上左脚
			status = 0;
			int temp = current;
			deep(current+1);
			current = temp;
			
			deep(current+2);
			current = temp;
			status = 1;
		}
	}

}
