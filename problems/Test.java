package problems;

import java.math.BigInteger;
import java.math.RoundingMode;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 测试类，写算法过程中，一些不确定的东西可以用来测试
 * @author zxr
 *
 */
public class Test {    
    
    public static void main(String[] args)  
    {  
        int[] weight = new int[]{12,2,32,4,52,6,72,82,92,10};  
        int len = weight.length;  
        //int t = 0;  
        int i,a,t;    
         a=weight[0];  
         for(i=0;i<(len-1);i++)  
         {  
          t=0;  
          while(weight[i+1] !=0)   
          { t=weight[i+1];  
          weight[i+1]=a%weight[i+1];  
          a=t;  
          }  
         }  
         System.out.println(a);  
    }  
      
      
}    
