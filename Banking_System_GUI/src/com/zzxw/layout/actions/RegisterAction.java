package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.zzxw.layout.LogicalImple;

public class RegisterAction implements ActionListener{
	private JPasswordField new_password;
	private JLabel info1;
	private JLabel userName ;
	private JPanel content;
	private JTextField new_username;
	private String[][] info;
	



	public RegisterAction(JPasswordField new_password, JLabel info1,
			JLabel userName, JPanel content, JTextField new_username,
			String[][] info) {
		super();
		this.new_password = new_password;
		this.info1 = info1;
		this.userName = userName;
		this.content = content;
		this.new_username = new_username;
		this.info = info;
	}




	public void actionPerformed(ActionEvent e) {
		if (!new_password.getText().isEmpty()&&!new_password.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Register Successfully");
			CardLayout cards = (CardLayout) content.getLayout();
			cards.show(content, "login");
			LogicalImple li= new LogicalImple();
			String pwd="";
			String username="";
			username=new_username.getText();
			for(char a:new_password.getPassword()){
				String temp=a+"";
				pwd+=temp;
			}
			li.regist(username, pwd, info);
			info1.setVisible(true);
			userName.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Entry is Empty");
		}
	}
}