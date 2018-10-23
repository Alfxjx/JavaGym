package key;
import java.util.Scanner;
public class main{
	
    private static void print(int[] c){
        boolean Firstexist =false;
        for(int i = c.length-1; i>=0; i--)
        {
            if(c[i] !=0)
            {
                if(Firstexist &&c[i] >0)//判断是否为首位数  ,不需加符号
                {
                    System.out.print("+");
                }

                if(c[i] !=1)  //系数 != 1, 输出
                {
                    System.out.print(c[i]);
                    if(i>0) //有x
                    {
                        System.out.print("x");
                        if(i!=1)//如次数为1,则省略,大余1则输出
                        {
                            System.out.print(i);
                        }
                    }
                }else           //系数 ==1
                {
                    System.out.print("x");
                    if(i!=1)//如次数为1,则省略,大余1则输出
                    {
                        System.out.print(i);
                    }
                }
                Firstexist = true;//进入一次则有输出,有了首位数.
            }
        }
        if(!Firstexist)
        {
            System.out.print(0); //如果此时未输出有较数字,输出0
        }
    }

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        int[] c = new int[101];
        int t,k;
        for(int flags=0;flags<2 ;flags++)
        {
            do{
                t =scan.nextInt();
                k = scan.nextInt();
                c[t] += k;
            }while(t!=0);
        }
        print(c);
    }
}