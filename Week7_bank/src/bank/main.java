/*
 * ��һ���򵥵����С��˻���ʾ����
 * ��1������һ���˻��࣬�����û��������롢�������ԡ���Ǯ��ȡǮ�ȷ�����
 * ��2������һ�������࣬�������������˻��б�����ԣ����˻������˻��Ĺ��ܡ��˻��б����ʹ�ü�����ص��࣬
 * 		��ArrayList�����ͬʱʹ�÷��͡�
 * ��3������һ�������༰main�����������д���һ�����У�����һЩ�˺ţ�ģ���Ǯ��ȡǮ����ʾ���ȡ�
 * https://zhidao.baidu.com/question/2122625617223425707.html
 * https://blog.csdn.net/Yang_xinqiao/article/details/81202772
 */
package bank;
import java.util.ArrayList;
import java.util.Scanner;
class Bank{
	public String bankName;
	private ArrayList<Account> userList;
	//constructor
	Bank(String bankName){
		this.bankName = bankName;
		//����userList
		userList = new ArrayList<Account>();
	}
	Bank(String bankName, ArrayList<Account> userList){
		this.bankName = bankName;
		this.userList = userList;
	}
	public void registUser(String userName, String password, double balance){
		
	}
	public void seekUser(String userName){
		
	}
	public static boolean login(String userName,String password){
		return true;
	}
	public static void save(double money){
		
	}
	public static void withdraw(double money){
		
	}
	public static void check(Account user){
		System.out.println("������Ϊ��"+user.getBalance());
	}
	
}
class Account{
	public String userName;
	public String password;
	public double balance;
	Account(String userName,String password,double balance){
		this.userName = userName;
		this.password = password;
		this.balance = balance;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public double getBalance(){
		return balance;
	}
}
//������
class Test{
	
}
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bank bank = new Bank("CCB");
		open();
	}
	//ģ�����п�ʼ����
	public static void open(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("------��ӭʹ��������ȡ��ϵͳ------");
			System.out.println("���û�����Y/N��");
			String account = in.nextLine();
			if (account.equals("y")||account.equals("Y")) {
				System.out.println("�������µ��˻���");
				String account1 = in.nextLine();
				System.out.println("���������룺");
				String passwd1 = in.nextLine();
				continue;
			}
			System.out.println("���������룺");
			String passwd2 = in.nextLine();
			boolean result = Bank.login(account, passwd2);
			if (result) {
				//System.out.println("��¼�ɹ�����ӭ" + BankTool.account[BankTool.index].getName() + "����");
				operate();
			} else {
				System.out.println("����������������롣");
			}
		}	
	}
	//ģ����ɾ�Ĳ����
	public static void operate(){
		Scanner inNext = new Scanner(System.in);
		while(true){
			System.out.println("��ѡ�������Ŀ��");
			System.out.println("1.���");
			System.out.println("2.ȡ��");
			System.out.println("3.��ѯ");
			System.out.println("4.�˳�");
			int n = inNext.nextInt();
			switch(n){
			case 1:
				System.out.println("�������");
				double moneySave = inNext.nextDouble();
				Bank.save(moneySave);
				break;
			case 2:
				System.out.println("����ȡ���");
				double moneyWithdraw = inNext.nextDouble();
				Bank.withdraw(moneyWithdraw);
				break;
			case 3:
				System.out.println("��ӭʹ��������ѯϵͳ��");
				Bank.check();
			case 4:
				return;
			default:
				System.out.println("illegal input nums");
				break;
			}
		}
	}
}
