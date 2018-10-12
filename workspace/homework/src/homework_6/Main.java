package homework_6;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     if(n == 0)
     System.out.println("ling");
     else 
     {
        if(n < 0) 
        {
           n = -n;
           System.out.print("fu ");
        }
        int temp = n;
        int count = 0;
        while(temp > 0) 
        {
           count++;
           temp /= 10;
        }
        count--;
        while(count >= 0) 
        {
           int bit = (n / (int)Math.pow(10,count))%10 ;
           switch(bit) 
           {
           			case 0:
           			System.out.print("ling");
           			break;
					case 1:
					System.out.print("yi");
					break;
					case 2:
					System.out.print("er");
					break;
					case 3:
					System.out.print("san");
					break;
					case 4:
					System.out.print("si");
					break;
					case 5:
					System.out.print("wu");
					break;
					case 6:
					System.out.print("liu");
					break;
					case 7:
					System.out.print("qi");
					break;
					case 8:
					System.out.print("ba");
					break;
					case 9:
					System.out.print("jiu");
					break;
           }
           if(count != 0)
           System.out.print(" ");
           count--;
        }
        System.out.println();
     }
  }
}
