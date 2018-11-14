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

class Account{
	private String accountName;
	private String password;
	private double balance;
	//构造方法
	Account(String accountName,String password,double balance){
		this.accountName = accountName;
		this.password = password;
		this.balance = balance;
	}
	public void getName(String accountName){
		return accountName;
	}
	public void getPassword(String password){
		return password;
	}
	public void getBalance(){
		System.out.println("userName:"+userName+",balance:"+balance);
	}
	public void show(){
		System.out.printf("userName:%s\n",userName);  
		System.out.printf("balance:%.2f\n",balance);  
	}
	public void Save(double money){
		balance+=money;
		System.out.printf("%s存了%.2f元，账户余额为%.2f元。\n",userName,money,balance)
	}
	public void Draw(double money){
		if(balance<money){
			System.out.printf("%s取钱%.2f元，账户余额为%.2f元。",userName,money,balance);  
			System.out.println("余额不足，取钱失败。");  
		}else{
			balance -= money;
			System.out.printf("%s取了%.2f元，账户余额为%.2f元。\n", userName, money, balance);
		}
	}
}

class Bank{
	private String bankName;
	private Account account;
	Bank(String bankName){
		this.bankName = bankName;
	}
	Bank(String bankName, ArrayList<Account>accounts){
		this.bankName = bankName;
		this.accounts = accounts;
	}
	//银行的操作需要调用Account的方法
	public void regist(String userName, String password, double balance){
		if(seekAccount(userName)==null){
			accounts.add(new Account(userName,password,balance));
		}
	}
	public void seekAccount(String userName){
		for(Account account : accounts){
			if(userName.equals(accounts.getName)){
				return account;
			}
		}
		return null;
	}
	public void showAccount(){
		Account account = seekAccount(userName);
		if(account==null){
			System.out.println("用户不存在");
		}else{
			account.show();
		}
	}
	public void bankSave(String userName, double money){
		Account account = seekAccount(userName);
		if(account==null){
			System.out.println("用户不存在");
		}else{
			account.Save(money);
		}
	}
	public void bankDraw(String userName, String password, double money){
		Account account = seekAccount(userName);
		if(account==null){
			System.out.println("用户不存在");
		}else{
			if(password.equals(account.getPassword())){
				account.Draw(money);
			}else{
				System.out.println("密码不正确，取钱失败。"); 
			}
		}
	}
}

