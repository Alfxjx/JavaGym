package homework_7;

import java.util.Scanner;

public class newMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		 * ��Ŀ���ݣ�
		������Ϊ2�ǵ�һ��������3�ǵڶ���������5�ǵ������������������ơ�
		���ڣ�������������n��m��0<n<=m<=200����ĳ���Ҫ�����n����������m������֮�����е������ĺͣ�
		������n�������͵�m��������
		ע�⣬�ǵ�n����������m������֮������е�������������n��m֮������е�������
		�����ʽ:
		������������һ����ʾn���ڶ�����ʾm��
		�����ʽ��
		һ����������ʾ��n����������m������֮�����е������ĺͣ�������n�������͵�m��������
		����������
		2 4
		���������
		15
 */
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int count = 0;
		int num = 2;
		int sum = 0;
		while(num!=0)	
		{
			Boolean flag=true;
			for(int i=2;i<=Math.sqrt(num);i++)
			{
				if(num%i==0)
				{
					flag = false;
					break;
				}
			}
				if(flag == true)
				{
					count++;
					if(count>=n&&count<=m)
					{
						sum+=num;
					}
					if(count> m)
					{
						break;
					}
				}
		num++;
		}
		System.out.println(sum);
	}

}
