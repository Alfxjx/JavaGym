package Week7;

import java.util.Scanner;

//ÿ����������������������д�ɼ���������Ҳ�ɳ�Ϊ��������˵���ʽ���⼸�������Ͷ����������������������
//���磬6���Ա��ֽ�Ϊ2x3����24���Ա��ֽ�Ϊ2x2x2x3��
//���ڣ���ĳ���Ҫ����һ��[2,100000]��Χ�ڵ�������Ȼ����������������ֽ�ʽ���������ľ�������ʱ�����������
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
					i = 1; // ��������Ϊ����ѭ����ʱ���ǻ�++�ġ�
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