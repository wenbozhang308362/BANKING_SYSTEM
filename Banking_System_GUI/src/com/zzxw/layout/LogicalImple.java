//µÇÂ¼ 	login
//String[]	loginVerification(String username,String pwd, String[][] info)
//·µ»ØÖµ[µÇÂ¼×´Ì¬,ÓÃ»§index]
//È¡Ç®	withdraw
//void	withdraw(String amount,String index,String[][] info)
//´æÇ®	deposit
//void	deposit(String amount,String index,String[][] info)
//×¢²á	register
//String	regist(String username,String pwd,String[][] info)
//¸ÄÃÜÂë	change password
//void	changePwd(String newpwd,String index,String[][] info)


package com.zzxw.layout;

import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class LogicalImple {
	
	public String[] loginVerification(String username,String pwd, String[][] info){
		int UserCount=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				UserCount++;
				if(pwd.equals(info[i][2])){
					System.out.println("Login successful");
					return new String[] {"0",Integer.toString(i)};//login success
					
				}
			}
		}
		if(UserCount==0){
			System.out.println("User doesn't exist");
			return new String[] {"1"};//user doesn't exist
		}
		else{
			System.out.println("Password wrong");
			return new String[] {"2"};//combination is wrong;
		}
	}
	
	
	public int withdraw(String amount,String username,String[][] info) {
		int withdrawAmount=Integer.parseInt(amount);
		int userindex=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				}
			}
		int Balance=Integer.parseInt(info[userindex][3]);
		if(Balance>=withdrawAmount){
			int currentBanlance=Balance-withdrawAmount;
			info[userindex][3]=Integer.toString(currentBanlance);
			try {
				new BankIO().writeexcel(info);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			return 0;	//withdraw sucessful
		}
		else{
			System.out.println("Withdraw Amount Excess Balance");
			return 1;	//Withdraw Amount Excess Balance
		}
	}
	
	public void deposit(String amount,String username,String[][] info) {
		int userindex=0;
		int depositAmount=Integer.parseInt(amount);
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				}
			}
		int Balance=Integer.parseInt(info[userindex][3]);
		int currentBanlance=Balance+depositAmount;
		info[userindex][3]=Integer.toString(currentBanlance);
		try {
			new BankIO().writeexcel(info);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public String getAccountId(String index,String[][] info) {
		int userindex=Integer.parseInt(index);
		String AccountId=info[userindex][0];
		return AccountId;
	}
	
	public String getUsername(String index,String[][] info) {
		int userindex=Integer.parseInt(index);
		String username=info[userindex][1];
		return username;
	}
	
	public String getPwd(String username,String[][] info) {
		int userindex=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				}
			}
		String pwd=info[userindex][2];
		return pwd;
	}
	
	public String getBalance(String username,String[][] info) {
		int userindex=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				}
			}
		String balance=info[userindex][3];
		return balance;
	}

	
	public String regist(String username,String pwd,String[][] info){
		int count=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				count++;
				System.out.println(count);
			}
		}
		System.out.println(count);
		if(count>0){
			System.out.println("User name already existed");
			return "1";	//user name already exist
		}
		else {
			String[] newuser={Integer.toString(info.length+1),username,pwd,Integer.toString(0)};
			info=Arrays.copyOf(info, info.length+1);	
			info[info.length-1]=new String[4];
			for(int i=0;i<newuser.length;i++){
				info[info.length-1][i]=newuser[i];
			}
			try {
				new BankIO().writeexcel(info);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			System.out.println("Register sucessfully");
			return "0";	//successful 
		}
	}
	
	public int changePwd(String oldpwd,String newpwd,String username,String[][] info){
		int userindex=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				}
			}
		System.out.println(oldpwd);
//		System.out.println(newpwd);
		if(oldpwd.equals(info[userindex][2])){
		info[userindex][2]=newpwd;
			try {
				new BankIO().writeexcel(info);
				System.out.println("Password changed sucessfully");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			return 0;	//change pwd success
		} else{
			System.out.println("wrong");
			return 1;	//pwd wrong
		}
		
	}
	
	public int PwdReset(String username,String newPwd, String[][] info){
		int userindex=0;
		int count=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				userindex=i;
				count++;
				}
			}
		if(count>0){
			info[userindex][2]=newPwd;
			try {
				new BankIO().writeexcel(info);
				System.out.println("Password reset sucessfully");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e);
			}
			return 0;
		} else {
			return 1;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void reset(String username,String emailbox){
		String[][] info=new String[0][];
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");//need to open up the pop3.smtp service of the sender email

		try {
			email.addTo(emailbox);
			email.setSSL(Boolean.TRUE); 
			email.setSslSmtpPort("465"); // if don't use the port, there would be an exception
			email.setAuthentication("419945501@qq.com","Wbt19900214!!");
			email.setFrom("419945501@qq.com");
			email.setSubject("Password Has Changed");
			BankIO li=new BankIO();
			String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
			Random random = new Random();  
			StringBuffer buf = new StringBuffer();  
			for (int i = 0; i < 6; i++) {  
				int num = random.nextInt(62);  
				buf.append(str.charAt(num));  
			}
			
			String st=buf.toString();
			email.setMsg("Your password has been reset to "+st);
			try {
				info=li.readexcel();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int i=new LogicalImple().PwdReset(username, st, info);
			if(i==1){
				JOptionPane.showMessageDialog(null, "User doesn't exist");
			} else {
				JOptionPane.showMessageDialog(null, "Your new password has been sent to your email");
				email.send();
			}
			
		}
		catch (EmailException ex) {
			ex.printStackTrace();
		}
	}
//	public static void main(String[] args) {
//		String[][] test={{"1","asd","123456","1000"},{"2","asdfgh","234567","500"}};
//		String[] s=new LogicalImple().loginVerification("asd", "123456",test);
//		System.out.println(Arrays.toString(s));
		
//		new LogicalImple().withdraw("500", "0", test);
//		System.out.println(Arrays.toString(test[0]));
		
//		test=new LogicalImple().deposit("500", "0", test);
//		System.out.println(Arrays.toString(test[0]));
//		
//		System.out.println(new LogicalImple().getAccountId("0",test));
//		System.out.println(new LogicalImple().getPwd("0",test));
//		System.out.println(new LogicalImple().getUsername("0",test));
		
//		new LogicalImple().regist("mo", "123123", test);
//		try {
//			String[][] test=new BankIO().readexcel();
//			System.out.println(new LogicalImple().getBalance("asdfgh",test));
//			new LogicalImple().changePwd("new password test", "0", test);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
	
}
