package homework_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int F_temp;
		int C_temp;
		Scanner in = new Scanner (System.in);
		F_temp = in.nextInt();
		C_temp = (int)((F_temp - 32)*5/9.0);
		System.out.println(C_temp);
		in.close();
	}

}
