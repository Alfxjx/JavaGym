package feet_meter_transfer;

import java.util.Scanner;

public class note {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		System.out.println("coin in");
		int note  = in.nextInt();
		in.close();
		System.out.println("*******");
		System.out.println("∆±º€10‘™");
		if(note>=10)
			{
			System.out.println("’“¡„£∫" + (note - 10));
			}
		else
			System.out.println("not enough");
		
		
		double a = 1.0;
		double b = 0.3+0.3+0.3+0.1;
		System.out.println(a==b);
		System.out.println("a="+a+"; b="+b);
		System.out.println(Math.abs(a-b)==0);
	}

}
