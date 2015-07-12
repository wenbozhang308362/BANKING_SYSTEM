package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zzxw.layout.BankIO;
import com.zzxw.layout.LogicalImple;

public class login_btn implements ActionListener{
	
	private JPanel content;
	private JTextField username_input;
	private JPasswordField password_input;
	private String[][] info = null;
	private JLabel userName;
	private JLabel accountNumberLabel;
	private JLabel accountNumber;
	

	public login_btn(JPanel content, JTextField username_input,
			JPasswordField password_input, String[][] info, JLabel userName,
			JLabel accountNumberLabel, JLabel accountNumber) {
		super();
		this.content = content;
		this.username_input = username_input;
		this.password_input = password_input;
		this.info = info;
		this.userName = userName;
		this.accountNumberLabel = accountNumberLabel;
		this.accountNumber = accountNumber;
	}


	@Override
		public void actionPerformed(ActionEvent e) {
			LogicalImple li= new LogicalImple();
			
			String username="";
			String pwd="";
			username=username_input.getText();
//			pwd=Arrays.toString(password_input.getPassword());
			for(char a:password_input.getPassword()){
				String temp=a+"";
				pwd+=temp;
			}
			BankIO bIO= new BankIO();
			try {
				info = bIO.readexcel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}
			String flag[]=li.loginVerification(username, pwd, info);
			
			if(flag[0].equals("0")){
				String accountNum=li.getAccountId(flag[1], info);
				String uName=li.getUsername(flag[1], info);
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "business");
				username_input.setText("");
				password_input.setText("");
				accountNumberLabel.setVisible(true);
				accountNumber.setVisible(true);				
				userName.setText(uName);
				userName.setVisible(true);
				accountNumber.setText(accountNum);			
			} else if(flag[0].equals("1")){
				JOptionPane.showMessageDialog(null, "User does not exist,please re-enter");
			} else if(flag[0].equals("2")){
				JOptionPane.showMessageDialog(null, "Password is Wrong!");
			} else{
				System.exit(-1);
			}
		}	
	
	
	
	
}