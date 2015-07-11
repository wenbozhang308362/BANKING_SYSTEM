package com.zzxw.layout;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.*;

public class TestCommon {
  public TestCommon() {
  }
  public static void main(String[] args){
    SimpleEmail email = new SimpleEmail();
    email.setHostName("smtp.qq.com");//need to open up the pop3.smtp service of the sender email
    
    try {
      email.addTo("monsoon1013@gmail.com");
      email.setSSL(Boolean.TRUE); 
      email.setSslSmtpPort("465"); // if don't use the port, there would be an exception
      email.setAuthentication("419945501@qq.com","Wbt19900214!!");
      email.setFrom("419945501@qq.com");
      email.setSubject("Password Has Changed");
      email.setMsg("Your password has been reset to the default.");
      email.send();
    }
    catch (EmailException ex) {
      ex.printStackTrace();
    }
  }
}
