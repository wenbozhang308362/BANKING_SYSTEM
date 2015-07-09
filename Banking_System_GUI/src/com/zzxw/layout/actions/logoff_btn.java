package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class logoff_btn implements ActionListener {
	private JPanel content;

	public logoff_btn(JPanel content) {
		super();
		this.content = content;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "login");
	}
}