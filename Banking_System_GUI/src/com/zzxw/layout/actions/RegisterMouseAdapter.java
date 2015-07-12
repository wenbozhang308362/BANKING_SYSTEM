package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class RegisterMouseAdapter extends MouseAdapter {
	private JPanel content;
	private JLabel info1;
	private JLabel userName;
	
	
	public RegisterMouseAdapter(JPanel content, JLabel info1, JLabel userName) {
		super();
		this.content = content;
		this.info1 = info1;
		this.userName = userName;
	}


		public void mouseClicked(MouseEvent e) {
			CardLayout cards = (CardLayout) content.getLayout();
			cards.show(content, "register");
			info1.setVisible(false);
			userName.setVisible(false);
			
		}
}