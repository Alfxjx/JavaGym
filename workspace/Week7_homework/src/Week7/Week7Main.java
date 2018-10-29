package Week7;

import java.util.Scanner;

//每个非素数（合数）都可以写成几个素数（也可称为质数）相乘的形式，这几个素数就都叫做这个合数的质因数。
//比如，6可以被分解为2x3，而24可以被分解为2x2x2x3。
//现在，你的程序要读入一个[2,100000]范围内的整数，然后输出它的质因数分解式；当读到的就是素数时，输出它本身。
public class Week7Main {
	public static boolean isPrime(int num){
		boolean isPrime = true;
		int len = num/2;
		for(int i = 2; i< len ; i++){
			if(num%i==0){
				isPrime=false;
				break;
			}
		}
		return isPrime;
	}
	public static void decomposition(int num){
		System.out.print(num+"=");
		for(int i = 2; i < num;i++){
			if(isPrime(i)==true){
				if(num%i==0){
					System.out.print(i+"x");
					num/=i;
					i = 1; // 这里是因为上面循环的时候是会++的。
				}
			}
		}
		System.out.print(num);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if(num>=2&&num<=100000){
			if(isPrime(num) ==true){
				System.out.println(num+"="+num);
			}
			else{
				decomposition(num);
			}
		}
	}

}