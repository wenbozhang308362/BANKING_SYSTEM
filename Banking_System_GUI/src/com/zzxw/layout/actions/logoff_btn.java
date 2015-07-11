package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class logoff_btn implements ActionListener {
	private JPanel content;
	private JLabel accountNumberLabel;
	private JLabel accountNumber;
	private JLabel userName;



	public logoff_btn(JPanel content, JLabel accountNumberLabel,
			JLabel accountNumber, JLabel userName) {
		super();
		this.content = content;
		this.accountNumberLabel = accountNumberLabel;
		this.accountNumber = accountNumber;
		this.userName = userName;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "login");
		
		accountNumber.setVisible(false);
		accountNumberLabel.setVisible(false);
		userName.setText("Guest");
	}
}