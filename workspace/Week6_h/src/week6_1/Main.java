package week6_1;

import java.util.Scanner;

/*
 * 输入格式:
 * 多条GPS语句，每条均以回车换行结束。最后一行是END三个大写字母。
 * 输出格式：
 * 6位数时间，表达为：hh:mm:ss
 * 其中，hh是两位数的小时，不足两位时前面补0；mm是两位数的分钟，不足两位时前面补0；
 * ss是两位数的秒，不足两位时前面补0。
 * 输入：
 * $GPRMC,024813.640,A,3158.4608,N,11848.3737,E,10.05,324.27,150706,,,A*50
 * END
 * 输出：
 * 10:48:13
 */



public class Main {
	
	public static StringBuilder toString(String inList[])
	{
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < inList.length; i++) {
			build.append(inList[i]);
		}
		//System.out.println("将数组经过处理后得到的字符串格式：");
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
		//输入为一个字符串加上换行
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
