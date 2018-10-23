package keyToWeek6_1;
import java.util.Scanner;

public class main {
		//ʱ����ʾ
		//Ϊʲô���Ǹ��ݾ��ȺͶ������Ĳ����жϣ�
		public static void showTime(String time) {
			int intTime = Integer.parseInt(time);
			int second=intTime%100;
			int minute=(intTime/100)%100;
			int hour=intTime/10000+8;
			if(hour>=24)
				hour=hour-24;
			System.out.printf("%02d:%02d:%02d",hour, minute, second);
		}
		//����У���
		//����һ��Ҫ��ס�ҵ�ʱȡ����A֮ǰ�Ǹ�,��λ��
		public static int CaltheCheckNum(String in,int startLoc,int endLoc) {
			endLoc++;//������A
			startLoc++;//$���һ��Ԫ��
			int theSum=in.charAt(startLoc);
			for(int i=startLoc+1;i<=endLoc;i++) {
				theSum=theSum^in.charAt(i);
			}
			return theSum%65536;
		}
		//�ж��Ƿ��ǿ�����������
		public static boolean canOutput(String GPS_data) {
			//�ҵ�GPRMC��A*
			int locOfGPRMC=GPS_data.indexOf("$GPRMC");
			int locOfA=GPS_data.indexOf(",A*");
			if(locOfGPRMC==-1||locOfA==-1) {
				//û��GPRMC��,A*�Ĳ��ܼ���У���
				return false;
			}
			//GPRMC��A*ͬʱ���ڲſ��Լ���У��Ͳ��ж�
			else {
				String cheNum=GPS_data.substring(locOfA+3, locOfA+5);//ȡ�յ���У����
				int tenCheNum=Integer.parseInt(cheNum,16);//��Ϊʮ����
				//����õ���У����
				int calCheck=CaltheCheckNum(GPS_data,locOfGPRMC,locOfA);
				if(tenCheNum==calCheck) {
					return true;
				}//У������֤û����
				else {
					return false;
				}
			}
		}
	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner in = new Scanner(System.in);
			
			//�����ַ�������GPS_data���ڴ洢������������
			String[] GPS_data =new String[100];
			//��ȡ��������
			int dataCnt=0;//������
			int endAt=0;//��¼END�ǵڼ������
			while(true) {
				GPS_data[dataCnt]=in.nextLine();
				if(GPS_data[dataCnt].equals("END")) {
					endAt=dataCnt;
					break;
				}
				dataCnt++;//׼��¼����һ�����				
			}
			//�ж�ÿһ����䲢�ҵ�Ҫ��������������䣬�����һ��canOutput�����
			int theLastOut=0;//��¼���һ������������ǵڼ���
			boolean outExist=false;//�п�������ı�־
			for(int j=0;j<endAt;j++) {
				if(canOutput(GPS_data[j])){
					theLastOut=j;
					outExist=true;//˵���п�������
				}
			}
			//��¼�������Ҫ��������
			String theoutData=GPS_data[theLastOut];
			//�����������ʱ��������ʱ��
			if(outExist) {
				int locOftime=theoutData.indexOf("$GPRMC")+7;//ȡʱ��Ŀ�ͷλ��
				String recievedTime=theoutData.substring(locOftime, locOftime+6);
				//ȡʱ����һ�ַ���
				showTime(recievedTime);
			}
			
	}
}

