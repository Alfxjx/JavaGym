package key;
import java.util.Scanner;
public class main{
	
    private static void print(int[] c){
        boolean Firstexist =false;
        for(int i = c.length-1; i>=0; i--)
        {
            if(c[i] !=0)
            {
                if(Firstexist &&c[i] >0)//�ж��Ƿ�Ϊ��λ��  ,����ӷ���
                {
                    System.out.print("+");
                }

                if(c[i] !=1)  //ϵ�� != 1, ���
                {
                    System.out.print(c[i]);
                    if(i>0) //��x
                    {
                        System.out.print("x");
                        if(i!=1)//�����Ϊ1,��ʡ��,����1�����
                        {
                            System.out.print(i);
                        }
                    }
                }else           //ϵ�� ==1
                {
                    System.out.print("x");
                    if(i!=1)//�����Ϊ1,��ʡ��,����1�����
                    {
                        System.out.print(i);
                    }
                }
                Firstexist = true;//����һ���������,������λ��.
            }
        }
        if(!Firstexist)
        {
            System.out.print(0); //�����ʱδ����н�����,���0
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