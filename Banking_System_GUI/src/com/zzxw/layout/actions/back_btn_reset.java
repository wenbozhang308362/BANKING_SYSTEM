package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.AbstractDocument.Content;

public class back_btn_reset implements ActionListener {
	private JPanel content;
	private JLabel reset_label_info;
	
	public back_btn_reset(JPanel content,JLabel reset_label_info) {
		super();
		this.content = content;
		this.reset_label_info=reset_label_info;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		CardLayout cards = (CardLayout) content.getLayout();
		cards.show(content, "login");
	}

}
