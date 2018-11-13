/*
 * 做一个简单的银行、账户演示程序。
 * （1）定义一个账户类，包含用户名、密码、余额等属性、存钱、取钱等方法。
 * （2）定义一个银行类，包含银行名、账户列表等属性，开账户、查账户的功能。账户列表可以使用集合相关的类，
 * 		如ArrayList，最好同时使用泛型。
 * （3）定义一个测试类及main函数，在其中创建一个银行，开设一些账号，模拟存钱、取钱、显示余额等。
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
		//创建userList
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
		System.out.println("你的余额为："+user.getBalance());
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
//测试类
class Test{
	
}
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Bank bank = new Bank("CCB");
		open();
	}
	//模拟银行开始程序
	public static void open(){
		Scanner in = new Scanner(System.in);
		while(true){
			System.out.println("------欢迎使用自助存取款系统------");
			System.out.println("新用户？（Y/N）");
			String account = in.nextLine();
			if (account.equals("y")||account.equals("Y")) {
				System.out.println("请输入新的账户：");
				String account1 = in.nextLine();
				System.out.println("请输入密码：");
				String passwd1 = in.nextLine();
				continue;
			}
			System.out.println("请输入密码：");
			String passwd2 = in.nextLine();
			boolean result = Bank.login(account, passwd2);
			if (result) {
				//System.out.println("登录成功，欢迎" + BankTool.account[BankTool.index].getName() + "光临");
				operate();
			} else {
				System.out.println("输入错误，请重新输入。");
			}
		}	
	}
	//模拟增删改查操作
	public static void operate(){
		Scanner inNext = new Scanner(System.in);
		while(true){
			System.out.println("请选择服务项目：");
			System.out.println("1.存款");
			System.out.println("2.取款");
			System.out.println("3.查询");
			System.out.println("4.退出");
			int n = inNext.nextInt();
			switch(n){
			case 1:
				System.out.println("输入存款金额：");
				double moneySave = inNext.nextDouble();
				Bank.save(moneySave);
				break;
			case 2:
				System.out.println("输入取款金额：");
				double moneyWithdraw = inNext.nextDouble();
				Bank.withdraw(moneyWithdraw);
				break;
			case 3:
				System.out.println("欢迎使用自助查询系统：");
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
