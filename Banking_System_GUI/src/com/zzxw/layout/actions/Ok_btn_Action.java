package com.zzxw.layout.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.zzxw.layout.BankIO;
import com.zzxw.layout.LogicalImple;

public class Ok_btn_Action implements ActionListener {

	private JTextField textField;
	private JLabel userName;
	private JLabel label_4;
	private String[][] info;
	private BankIO bIO;

	public Ok_btn_Action(JTextField textField, JLabel userName,
			String[][] info, BankIO bIO,JLabel label_4) {
		super();
		this.textField = textField;
		this.userName = userName;
		this.info = info;
		this.bIO = bIO;
		this.label_4=label_4;
	}

	public void actionPerformed(ActionEvent e) {
		String username = userName.getText();
		String withdrawNum = textField.getText();
		LogicalImple li = new LogicalImple();
//		System.out.println("test");
		int i=li.withdraw(withdrawNum, username, info);
		if(i==1){
			JOptionPane.showMessageDialog(null, "Register Successfully");
		}
		try {
			info = bIO.readexcel();
//			System.out.println("balance from withd:"+info[2][3]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Read error from file!");
		}

		label_4.setText(li.getBalance(username, info));

	}

}
