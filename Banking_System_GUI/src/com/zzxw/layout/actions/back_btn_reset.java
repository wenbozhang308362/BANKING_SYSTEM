package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;

public class back_btn_reset implements ActionListener {
	private JPanel content;
	
	public back_btn_reset(JPanel content) {
		super();
		this.content = content;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "login");
	}

}
