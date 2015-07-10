//��¼ 	login
//String[]	loginVerification(String username,String pwd, String[][] info)
//����ֵ[��¼״̬,�û�index]
//ȡǮ	withdraw
//void	withdraw(String amount,String index,String[][] info)
//��Ǯ	deposit
//void	deposit(String amount,String index,String[][] info)
//ע��	register
//String	regist(String username,String pwd,String[][] info)
//������	change password
//void	changePwd(String newpwd,String index,String[][] info)


package com.zzxw.layout;

import java.util.Arrays;

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
	
	
	public void withdraw(String amount,String index,String[][] info) {
		int withdrawAmount=Integer.parseInt(amount);
		int userindex=Integer.parseInt(index);
		int Balance=Integer.parseInt(info[userindex][3]);
		
		int currentBanlance=Balance-withdrawAmount;
		info[userindex][3]=Integer.toString(currentBanlance);
		try {
			new BankIO().writeexcel(info);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void deposit(String amount,String index,String[][] info) {
		int depositAmount=Integer.parseInt(amount);
		int userindex=Integer.parseInt(index);
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
	
	public String getPwd(String index,String[][] info) {
		int userindex=Integer.parseInt(index);
		String pwd=info[userindex][2];
		return pwd;
	}
	
	public String getBalance(String index,String[][] info) {
		int userindex=Integer.parseInt(index);
		String balance=info[userindex][3];
		return balance;
	}
	
	public String regist(String username,String pwd,String[][] info){
		int count=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				count++;
			}
		}
		if(count>0){
			System.out.println("User name already exist");
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
			System.out.println("Register sucessful");
			return "0";	//successful 
		}
	}
	
	public void changePwd(String newpwd,String index,String[][] info){
		int userindex=Integer.parseInt(index);
		info[userindex][2]=newpwd;
		try {
			new BankIO().writeexcel(info);
			System.out.println("Password change sucessful");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
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
//		System.out.println(new LogicalImple().getBalance("0",test));
//		System.out.println(new LogicalImple().getPwd("0",test));
//		System.out.println(new LogicalImple().getUsername("0",test));
		
//		new LogicalImple().regist("mo", "123123", test);
//		try {
//			String[][] test=new BankIO().readexcel();
//			new LogicalImple().changePwd("new password test", "0", test);
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e);
//		}
//	}
	
}
