/** 

* （10分） 

* 做一个简单的银行、账户演示程序。 

* （1）定义一个账户类，包含用户名、密码、余额等属性、存钱、取钱等方法。 

* （2）定义一个银行类，包含银行名、账户列表等属性，开账户、查账户的功能。账户列表可以使用集合相关的类， 

*      如ArrayList，最好同时使用泛型。 

* （3）定义一个测试类及main函数，在其中创建一个银行，开设一些账号，模拟存钱、取钱、显示余额等。 

*/  
package week7;
import java.util.ArrayList;
import java.util.Scanner;
public class main {  
	public static void main(String[] args){  
		Bank bank = new Bank("CCB");  
		bank.openAccount("mike","555",0);  
		bank.openAccount("lee","123",0);  
		bank.openAccount("jojo","444",0);  
		bank.saveMoney("jojo",100);  
		//向特定账户存钱  
		bank.drawMoney("jojo",50,"444");  
		//从特定账户取钱,需验证密码  
		bank.showAccount("jojo");  
		//显示xiaoli账户信息  
		bank.drawMoney("jojo",20,"666");  
		//密码错误，取钱失败的情况  
		bank.drawMoney("jojo",101,"444");  
		//余额不足的情况  
	}  
}  

class Account{  
	private String userName;  
	private String password;  
	private double balance;  
Account(String userName,String password,double balance){  
	this.userName = userName;  
	this.password = password;  
	this.balance = balance;  
}  

public void save(double money){  
	//存钱  
	balance += money;  
	System.out.printf("%s存了%.2f元，账户余额为%.2f元。\n",userName,money,balance);  
}  

public void draw(double money){  
	//取钱，若账户余额不足，则不能取钱  
	if(balance - money <= 0) {  
		System.out.printf("%s取钱%.2f元，账户余额为%.2f元。",userName,money,balance);  
		System.out.println("余额不足，取钱失败。");  
	}else {  
		balance -= money;  
		System.out.printf("%s取了%.2f元，账户余额为%.2f元。\n", userName, money, balance);  
	}  
}  

public void show(){  
	//显示账户信息  
	System.out.printf("userName:%s\n",userName);  
	System.out.printf("balance:%.2f\n",balance);  
}  
public String getUserName(){  
	//得到用户名  
	return userName;  
}  
public String getPassword(){  
	//得到密码  
	return password;  
}  
public String getInfo(){  
	//返回账户信息  
	return "userName:"+userName+",banlance:"+balance;  
}  

}  

class Bank{  
	public String bankName;  
	private ArrayList<Account> accounts;  
Bank(String bankName){  
	this.bankName=bankName;  
	accounts=new ArrayList<Account>();  
}  
Bank(String bankName,ArrayList<Account> accounts){  
	this.bankName=bankName;  
	this.accounts=accounts;  
}  
public void openAccount(String userName,String password,double balance){  
	//开账户  
	accounts.add(new Account(userName,password,balance));  
}  
public Account seekAccount(String userName){  
	//查找账户按用户名,若找到，返回该账户，否则，返回null  
	for(Account account:accounts){  
		if(userName.equals(account.getUserName()))  
			return account;  
	}  
	return null;  
}  
public void showAccount(String userName){  
	Account account=seekAccount(userName);  
		if(account==null)  
			System.out.println("该账户不存在。");  
		else  
			account.show();  
}  
public void saveMoney(String userName,double money){  
	//向特定账户存钱  
	Account account = seekAccount(userName); //查找  
	if(account==null)  
		System.out.println("该账户不存在。");  
	else  
		account.save(money);  
}  
public void drawMoney(String userName,double money,String password){  
	//从特定账户取钱,需验证密码  
	Account account = seekAccount(userName); //查找  
	if(account==null)  
		System.out.println("该账户不存在。");  
	else {  
		if(password.equals(account.getPassword())) {  
			account.draw(money);  
		}else {  
			System.out.println("密码不正确，取钱失败。");  
		}  
	}  
}  
} 