package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PswForgetMouseAdapter extends MouseAdapter {
	private JPanel content;
	JLabel info1;
	JLabel userName;
	
	
	public PswForgetMouseAdapter(JPanel content, JLabel info1, JLabel userName) {
		super();
		this.content = content;
		this.info1 = info1;
		this.userName = userName;
	}


	public void mouseClicked(MouseEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "reset");
		info1.setVisible(false);
		userName.setVisible(false);
	}
}