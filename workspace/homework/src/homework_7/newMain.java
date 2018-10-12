package homework_7;

import java.util.Scanner;

public class newMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		 * 题目内容：
		我们认为2是第一个素数，3是第二个素数，5是第三个素数，依次类推。
		现在，给定两个整数n和m，0<n<=m<=200，你的程序要计算第n个素数到第m个素数之间所有的素数的和，
		包括第n个素数和第m个素数。
		注意，是第n个素数到第m个素数之间的所有的素数，并不是n和m之间的所有的素数。
		输入格式:
		两个整数，第一个表示n，第二个表示m。
		输出格式：
		一个整数，表示第n个素数到第m个素数之间所有的素数的和，包括第n个素数和第m个素数。
		输入样例：
		2 4
		输出样例：
		15
 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int count = 0;
		int num = 2;
		int sum = 0;
		while(num!=0)	
		{
			Boolean flag=true;
			for(int i=2;i<=Math.sqrt(num);i++)
			{
				if(num%i==0)
				{
					flag = false;
					break;
				}
			}
				if(flag == true)
				{
					count++;
					if(count>=n&&count<=m)
					{
						sum+=num;
					}
					if(count> m)
					{
						break;
					}
				}
		num++;
		}
		System.out.println(sum);
	}

}
