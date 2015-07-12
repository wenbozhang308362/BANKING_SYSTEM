//package com.zzxw.layout.actions;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//import javax.swing.JTextField;
//
//import org.apache.commons.mail.*;
//
//public class Reset_button implements ActionListener {
//	public Reset_button(){
//		
//	}
//
//	SimpleEmail email = new SimpleEmail();
//    
//	@Override
//	public void actionPerformed(ActionEvent e) {
//	    try {
//	    	email.setHostName("smtp.qq.com");//need to open up the pop3.smtp service of the sender email
//	        email.addTo("wangb2013@my.fit.edu");
//	        email.setSSL(Boolean.TRUE); 
//	        email.setSslSmtpPort("465"); // if don't use the port, there would be an exception
//	        email.setAuthentication("419945501@qq.com","Wbt19900214!!");
//	        email.setFrom("419945501@qq.com");
//	        email.setSubject("Password Has Changed");
//	        email.setMsg("Your password has been reset to the default.");
//	        email.send();
//	      }
//	      catch (EmailException ex) {
//	        ex.printStackTrace();
//	      }
//	}
//}
