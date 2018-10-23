package keyToWeek6_1;
import java.util.Scanner;

public class main {
		//时间显示
		//为什么不是根据经度和东八区的差来判断？
		public static void showTime(String time) {
			int intTime = Integer.parseInt(time);
			int second=intTime%100;
			int minute=(intTime/100)%100;
			int hour=intTime/10000+8;
			if(hour>=24)
				hour=hour-24;
			System.out.printf("%02d:%02d:%02d",hour, minute, second);
		}
		//计算校验和
		//这里一定要记住我当时取得是A之前那个,的位置
		public static int CaltheCheckNum(String in,int startLoc,int endLoc) {
			endLoc++;//结束于A
			startLoc++;//$后第一个元素
			int theSum=in.charAt(startLoc);
			for(int i=startLoc+1;i<=endLoc;i++) {
				theSum=theSum^in.charAt(i);
			}
			return theSum%65536;
		}
		//判断是否是可以输出的语句
		public static boolean canOutput(String GPS_data) {
			//找到GPRMC和A*
			int locOfGPRMC=GPS_data.indexOf("$GPRMC");
			int locOfA=GPS_data.indexOf(",A*");
			if(locOfGPRMC==-1||locOfA==-1) {
				//没有GPRMC和,A*的不能计算校验和
				return false;
			}
			//GPRMC和A*同时存在才可以计算校验和并判断
			else {
				String cheNum=GPS_data.substring(locOfA+3, locOfA+5);//取收到的校验码
				int tenCheNum=Integer.parseInt(cheNum,16);//化为十进制
				//计算得到的校验码
				int calCheck=CaltheCheckNum(GPS_data,locOfGPRMC,locOfA);
				if(tenCheNum==calCheck) {
					return true;
				}//校验码验证没问题
				else {
					return false;
				}
			}
		}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			
			//创建字符串数组GPS_data用于存储所有输入的语句
			String[] GPS_data =new String[100];
			//读取所有输入
			int dataCnt=0;//计数用
			int endAt=0;//记录END是第几条语句
			while(true) {
				GPS_data[dataCnt]=in.nextLine();
				if(GPS_data[dataCnt].equals("END")) {
					endAt=dataCnt;
					break;
				}
				dataCnt++;//准备录入下一行语句				
			}
			//判断每一条语句并找到要进行输出处理的语句，即最后一句canOutput的语句
			int theLastOut=0;//记录最后一句可输出的语句是第几句
			boolean outExist=false;//有可输出语句的标志
			for(int j=0;j<endAt;j++) {
				if(canOutput(GPS_data[j])){
					theLastOut=j;
					outExist=true;//说明有可输出语句
				}
			}
			//记录下来这个要输出的语句
			String theoutData=GPS_data[theLastOut];
			//当可以输出的时候才能输出时间
			if(outExist) {
				int locOftime=theoutData.indexOf("$GPRMC")+7;//取时间的开头位置
				String recievedTime=theoutData.substring(locOftime, locOftime+6);
				//取时间这一字符串
				showTime(recievedTime);
			}
			
	}
}

