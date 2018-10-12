package homework_3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input_num;
		int single;
		int ten;
		Scanner in = new Scanner(System.in);
		input_num = in.nextInt();
		ten = input_num/10;
		single = input_num - 10*ten;
		if(single==1)
		{
			System.out.print("Faint signals, barely perceptible");
		}
		if(single==2)
		{
			System.out.print("Very weak signals");
		}		
		if(single==3)
		{
			System.out.print("Weak signals");
		}		
		if(single==4)
		{
			System.out.print("Fair signals");
		}		
		if(single==5)
		{
			System.out.print("Fairly good signals");
		}		
		if(single==6)
		{
			System.out.print("Good signals");
		}		
		if(single==7)
		{
			System.out.print("Moderately strong signals");
		}
		if(single==8)
		{
			System.out.print("Strong signals");
		}
		if(single==9)
		{
			System.out.print("Extremely strong signals");
		}
		if(ten==1)
		{
			System.out.print(", "+"unreadable.");
		}
		if(ten==2)
		{
			System.out.print(", "+"barely readable, occasional words distinguishable.");
		}
		if(ten==3)
		{
			System.out.print(", "+"readable with considerable difficulty.");
		}
		if(ten==4)
		{
			System.out.print(", "+"readable with practically no difficulty.");
		}
		if(ten==5)
		{
			System.out.print(", "+"perfectly readable.");
		}
		in.close();
	}

}
