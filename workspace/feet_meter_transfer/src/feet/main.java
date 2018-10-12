package feet;

import java.util.Scanner;
public class main{
    public static void main( String[] args ){
     long sum=0,cbrtSum=0; 
     for(long a=1;a<=1000;a++){
         for(long n=2;n<=1000;n++){ 
           /*此为求从起始项到结束项的立方和公式*/
             sum=n*a*a*a+((n*(n-1))>>1)*(3*a*a+((n<<1)-1)*a+((n*(n-1))>>1));
             cbrtSum=(long)Math.cbrt(sum); 
             if((long)Math.pow(cbrtSum, 3)==sum){  
                 System.out.println(a+"^3+...+"+(a+n-1)+"^3="+cbrtSum+"^3");
            }
         }
    	 }
    	 System.out.println("Finished");
    }
}
    	