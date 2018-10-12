package homework_4;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int even = 0;
		int odd = 0;
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		while(num!=-1)
		{
			if(num%2==0)
			{
				even = even + 1;
			}
			else
			{
				odd = odd + 1;
			}
			num = in.nextInt();
		}
		in.close();	
		System.out.println(odd+" "+even);
	}

}
