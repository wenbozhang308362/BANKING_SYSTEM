package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PswForgetMouseAdapter extends MouseAdapter {
	private JPanel content;
	JLabel info1;
	JLabel userName;
	private JFrame frame;
	
	
	public PswForgetMouseAdapter(JPanel content, JLabel info1, JLabel userName, JFrame frame) {
		super();
		this.content = content;
		this.info1 = info1;
		this.userName = userName;
		this.frame = frame;
	}


	public void mouseClicked(MouseEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "reset");
		info1.setVisible(false);
		userName.setVisible(false);
		JLabel psw_reset_label = new JLabel("Reset your password");
		psw_reset_label.setFont(new Font("Verdana", Font.PLAIN, 20));
		psw_reset_label.setHorizontalAlignment(SwingConstants.CENTER);
		psw_reset_label.setBounds(143, 13, 267, 39);
		frame.getContentPane().add(psw_reset_label);
	}
}