package week6_1;

import java.util.Scanner;

/*
 * �����ʽ:
 * ����GPS��䣬ÿ�����Իس����н��������һ����END������д��ĸ��
 * �����ʽ��
 * 6λ��ʱ�䣬���Ϊ��hh:mm:ss
 * ���У�hh����λ����Сʱ��������λʱǰ�油0��mm����λ���ķ��ӣ�������λʱǰ�油0��
 * ss����λ�����룬������λʱǰ�油0��
 * ���룺
 * $GPRMC,024813.640,A,3158.4608,N,11848.3737,E,10.05,324.27,150706,,,A*50
 * END
 * �����
 * 10:48:13
 */



public class Main {
	
	public static StringBuilder toString(String inList[])
	{
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < inList.length; i++) {
			build.append(inList[i]);
		}
		//System.out.println("�����龭�������õ����ַ�����ʽ��");
		return(build);
	}

	public static String toBJTime(String time,String longitude,String EW)

	{
		String hms = time.substring(0, 6);
		int hour = Integer.parseInt(hms.substring(0,2));
		int BJhour=0;
		double gap; 
		if(EW=="W")
		{
			gap = 120.0+Double.parseDouble(longitude);
			double timegap = (gap/15.0);
			BJhour = (int)((double)hour - timegap);
		}
		if(EW=="E")
		{
			gap = 120.0-Double.parseDouble(longitude);
			double timegap = (gap/15.0);
			BJhour = (int)((double)hour - timegap);
		}
		String BJTime;
		BJTime = BJhour +":"+hms.substring(2,4)+":"+hms.substring(4,6);
		return BJTime;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String []inList = new String[16];
		//����Ϊһ���ַ������ϻ���
//		String time = "024813.012";
//		System.out.println(toBJTime(time));
		while(true)
		{
			String input = in.nextLine();
			if(input!= "END")
			{
				//System.out.println(1);
				inList = input.split(",");
				StringBuilder temp = toString(inList);
				temp.deleteCharAt(0);
				String tempString = temp.toString();
				String numString = tempString.substring(tempString.length()-2, tempString.length());
				int num = Integer.parseInt(numString);
				char []tempChar = tempString.toCharArray();
				int cnt = 1;
				char XOR='$' ;
				while(tempChar[cnt]!= '*')
				{
					XOR = (char)(XOR^tempChar[cnt]);
					cnt++;
				}
				int result = Integer.parseInt(String.valueOf(XOR%65536), 10)-1;
				System.out.println(result);
				if(num==result)
				{
					String BJtime = toBJTime(inList[1],inList[4],inList[5]);
					System.out.println(BJtime);
				}			
			}
			else
			{
				break;
			}
		}
		in.close();
		
	}

}
