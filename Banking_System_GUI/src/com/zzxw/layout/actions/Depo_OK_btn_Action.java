package com.zzxw.layout.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.zzxw.layout.BankIO;
import com.zzxw.layout.LogicalImple;

public class Depo_OK_btn_Action implements ActionListener {

	private JTextField textField_1;
	private JLabel userName;
	private JLabel label_7;
	private String[][] info;
	private BankIO bIO;

	public Depo_OK_btn_Action(JTextField textField_1, JLabel userName,
			String[][] info, BankIO bIO,JLabel label_7) {
		super();
		this.textField_1 = textField_1;
		this.userName = userName;
		this.info = info;
		this.bIO = bIO;
		this.label_7=label_7;
	}

	public void actionPerformed(ActionEvent e) {
		String username = userName.getText();
		String depositNum = textField_1.getText();
		LogicalImple li = new LogicalImple();
		li.deposit(depositNum, username, info);

		try {
			info = bIO.readexcel();
			System.out.println("balance from depo:"+info[2][3]);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("Read error from file!");
		}

		label_7.setText(li.getBalance(username, info));

	}

}