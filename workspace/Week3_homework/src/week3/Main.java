package week3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * �á�����ɸ������2��100���ڵ�������
		 * 2��100���ڵ�������ȥ��2�ı�������ȥ��3�ı�������ȥ��5�ı�����
		 * �����������ƣ����ʣ�µľ���������
		 */
		int []a = new int[98];
		for(int i=0,num=2;i<98;i++,num++)
		{
			a[i] = num;
			//System.out.print(a[i]+" ");
		}
		//����2~100��ȫ������
		for(int num2= 1;num2<98; num2++)
		{
			if(a[num2]%2==0)
			{
				a[num2]= 0;
				
			}
		}
		for(int num3= 2;num3<98; num3++)
		{
			if(a[num3]%3==0)
			{
				a[num3]= 0;
				
			}
		}
		for(int num5= 4;num5<98; num5++)
		{
			if(a[num5]%5==0)
			{
				a[num5]= 0;
				
			}
		}
		//���ܱ�2,3,5�����������0
		loop:
		for(int result=0;result<98;result++ )
		{
			if(a[result]!=0)
			{
				for(int realResult = 0 ; ;realResult++)
				{
					a[realResult]  = a[result];
					System.out.print(a[realResult]+" ");
					continue loop;
				}
			}
		}
		//������ǰ�����飬���������д��realResult���档
	}

}
