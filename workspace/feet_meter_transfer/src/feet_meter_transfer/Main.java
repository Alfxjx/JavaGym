package feet_meter_transfer;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(1.2-1.1); // ¸¡µãµÄ¼ÆËãÎó²î
		int foot = (int)(30/6.0);
		double inch = 7; // float ok
		Scanner in = new Scanner(System.in);
		foot = in.nextInt();
		inch = in.nextDouble();
		int result = (int)((inch/12 + foot)*0.3048*100);
		System.out.println(result + " cm");
		//System.out.println(2+3*6/2);
		in.close();
				
	}

}
