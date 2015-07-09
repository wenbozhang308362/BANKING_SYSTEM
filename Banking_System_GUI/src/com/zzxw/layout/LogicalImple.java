package com.zzxw.layout;

import java.util.Arrays;

public class LogicalImple {
	
	public String[] loginVerification(String username,String pwd, String[][] info){
		int UserCount=0;
		for(int i=0;i<info.length;i++){
			if(username.equals(info[i][1])){
				UserCount++;
				if(pwd.equals(info[i][2])){
					return new String[] {"0",Integer.toString(i)};//login success
					
				}
			}
		}
		if(UserCount==0){
			return new String[] {"1"};//user doesn't exist
		}
		else{
			return new String[] {"2"};//combination is wrong;
		}
	}
	
	
	public String[][] withdraw(String amount,String index,String[][] info) {
		int withdrawAmount=Integer.parseInt(amount);
		int userindex=Integer.parseInt(index);
		int Balance=Integer.parseInt(info[userindex][3]);
		
		int currentBanlance=Balance-withdrawAmount;
		info[userindex][3]=Integer.toString(currentBanlance);
		return info;
	}
	
	public String[][] deposit(String amount,String index,String[][] info) {
		int depositAmount=Integer.parseInt(amount);
		int userindex=Integer.parseInt(index);
		int Balance=Integer.parseInt(info[userindex][3]);
		
		int currentBanlance=Balance+depositAmount;
		info[userindex][3]=Integer.toString(currentBanlance);
		return info;
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
	
//	public static void main(String[] args) {
//		String[][] test={{"1","asd","123456","1000"},{"2","asdfgh","234567","500"}};
//		String[] s=new LogicalImple().loginVerification("asd", "123456",test);
//		System.out.println(Arrays.toString(s));
//		
////		test=new LogicalImple().withdraw("500", "0", test);
////		System.out.println(Arrays.toString(test[0]));
//		
//		test=new LogicalImple().deposit("500", "0", test);
//		System.out.println(Arrays.toString(test[0]));
//		
//		System.out.println(new LogicalImple().getAccountId("0",test));
//		System.out.println(new LogicalImple().getBalance("0",test));
//		System.out.println(new LogicalImple().getPwd("0",test));
//		System.out.println(new LogicalImple().getUsername("0",test));
//	}
	
}
