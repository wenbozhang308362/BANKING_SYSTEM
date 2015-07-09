package com.zzxw.layout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class registerAction implements ActionListener{
	private JPasswordField new_password;
	private JLabel label1;
	private JLabel userName ;
	private JPanel content;
	
	
	public registerAction(JPasswordField new_password, JLabel label1,
			JLabel userName, JPanel content) {
		super();
		this.new_password = new_password;
		this.label1 = label1;
		this.userName = userName;
		this.content = content;
	}



	public void actionPerformed(ActionEvent e) {
		if (!new_password.getText().isEmpty()&&!new_password.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Register Successfully");
			CardLayout cards = (CardLayout) content.getLayout();
			cards.show(content, "login");
			label1.setVisible(true);
			userName.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Entry is Empty");
		}
	}
}