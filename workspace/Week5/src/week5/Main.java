package week5;

import java.util.Scanner;

/*
 * 一个多项式可以表达为x的各次幂与系数乘积的和，比如：
 * 2x6+3x5+12x3+6x+20
 * 现在，你的程序要读入两个多项式，然后输出这两个多项式的和，
 * 也就是把对应的幂上的系数相加然后输出。
 * 程序要处理的幂最大为100。
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int []input = new int[101];
		int i,j;
		for(int inNum=0;inNum<=1;inNum++)
		{
			do{
				i = in.nextInt();
				j = in.nextInt();
				input[i]+=j;
			}while(i!=0);
		}
		boolean isFirst = false;
		for(int m = input.length-1;m>=0;m--)
		{
			if(input[m]!=0)
			{
				if(isFirst && input[m]>0)
				{
					System.out.print("+");
				}
				if(input[m]!=1)
				{
					System.out.print(input[m]);
					if(m>0)
					{
						 System.out.print("x");
						 if(m!=1)
						 {
							 System.out.print(m);
						 }
					}
				}
				else
				{
					System.out.print("x");
					if(m!=1)
					{
						System.out.print(m);
					}
				}
				isFirst = true;
				
			}
		}
		if(!isFirst)
		{
			System.out.print(0);
		}
		in.close();
	}

}
