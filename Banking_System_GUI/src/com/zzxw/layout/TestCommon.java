package com.zzxw.layout;
import org.apache.commons.mail.SimpleEmail;

import java.util.Random;

import org.apache.commons.mail.*;

public class TestCommon {
	private static String emailbox;
	private static String username;
	public TestCommon(String emailbox,String username) {
		this.emailbox = emailbox;
		this.username=username;
	}
	public static void main(String[] args){
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.qq.com");//need to open up the pop3.smtp service of the sender email

		try {
			//email.addTo("wangb2013@my.fit.edu");
			email.addTo(emailbox);
			email.setSSL(Boolean.TRUE); 
			email.setSslSmtpPort("465"); // if don't use the port, there would be an exception
			email.setAuthentication("419945501@qq.com","Wbt19900214!!");
			email.setFrom("419945501@qq.com");
			email.setSubject("Password Has Changed");
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";  
		    Random random = new Random();  
		    StringBuffer buf = new StringBuffer();  
		    for (int i = 0; i < 6; i++) {  
		        int num = random.nextInt(62);  
		        buf.append(str.charAt(num));  
		    }
		    
		    String st=buf.toString();
			email.setMsg("Your password has been reset to "+st);
			email.send();
		}
		catch (EmailException ex) {
			ex.printStackTrace();
		}
	}
}