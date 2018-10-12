package week3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * 用“埃氏筛法”求2～100以内的素数。
		 * 2～100以内的数，先去掉2的倍数，再去掉3的倍数，再去掉5的倍数，
		 * ……依此类推，最后剩下的就是素数。
		 */
		int []a = new int[98];
		for(int i=0,num=2;i<98;i++,num++)
		{
			a[i] = num;
			//System.out.print(a[i]+" ");
		}
		//构造2~100的全部整数
		for(int num2= 1;num2<98; num2++)
		{
			if(a[num2]%2==0)
			{
				a[num2]= 0;
				
			}
		}
		for(int num3= 2;num3<98; num3++)
		{
			if(a[num3]%3==0)
			{
				a[num3]= 0;
				
			}
		}
		for(int num5= 4;num5<98; num5++)
		{
			if(a[num5]%5==0)
			{
				a[num5]= 0;
				
			}
		}
		//将能被2,3,5整除的数变成0
		loop:
		for(int result=0;result<98;result++ )
		{
			if(a[result]!=0)
			{
				for(int realResult = 0 ; ;realResult++)
				{
					a[realResult]  = a[result];
					System.out.print(a[realResult]+" ");
					continue loop;
				}
			}
		}
		//遍历当前的数组，将非零的项写到realResult里面。
	}

}
