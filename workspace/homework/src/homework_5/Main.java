package homework_5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int count = 0;
		int binary = 1;
		int x;
		int out;
		int result=0;
//		in.close();
		while(num!=0)	
		{	x = num%10;
			num = num/10;
			count = count+1;
			if(x%2!=count%2)
			{
				out = 0;
			}
			else
			{
				out = 1;
			}
			result = result+ out*binary;
			binary = binary*2;
		}
		System.out.println(result);
	}

}
