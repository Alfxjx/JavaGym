package week5;

import java.util.Scanner;

/*
 * һ������ʽ���Ա��Ϊx�ĸ�������ϵ���˻��ĺͣ����磺
 * 2x6+3x5+12x3+6x+20
 * ���ڣ���ĳ���Ҫ������������ʽ��Ȼ���������������ʽ�ĺͣ�
 * Ҳ���ǰѶ�Ӧ�����ϵ�ϵ�����Ȼ�������
 * ����Ҫ����������Ϊ100��
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int []input = new int[101];
		int i,j;
		for(int inNum=0;inNum<=1;inNum++)
		{
			do{
				i = in.nextInt();
				j = in.nextInt();
				input[i]+=j;
			}while(i!=0);
		}
		boolean isFirst = false;
		for(int m = input.length-1;m>=0;m--)
		{
			if(input[m]!=0)
			{
				if(isFirst && input[m]>0)
				{
					System.out.print("+");
				}
				if(input[m]!=1)
				{
					System.out.print(input[m]);
					if(m>0)
					{
						 System.out.print("x");
						 if(m!=1)
						 {
							 System.out.print(m);
						 }
					}
				}
				else
				{
					System.out.print("x");
					if(m!=1)
					{
						System.out.print(m);
					}
				}
				isFirst = true;
				
			}
		}
		if(!isFirst)
		{
			System.out.print(0);
		}
		in.close();
	}

}
