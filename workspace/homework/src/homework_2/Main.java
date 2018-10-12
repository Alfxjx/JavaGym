package homework_2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int BJT;
		int UTC;
		Scanner in = new Scanner(System.in);
		BJT = in.nextInt();
		if(BJT <=759)
		{
			UTC = 1600+BJT;
			System.out.println(UTC);
		}
		else
			{
			if(BJT<=2359)
			{
				UTC = BJT - 800;
				System.out.println(UTC);
			}
				
			}
	}

}
