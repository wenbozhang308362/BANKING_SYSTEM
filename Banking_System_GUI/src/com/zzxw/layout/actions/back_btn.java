package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class back_btn implements ActionListener{
	
	private JPanel service_panel;
	
	
	public back_btn(JPanel service_panel) {
		super();
		this.service_panel = service_panel;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		CardLayout cards = (CardLayout) service_panel.getLayout();
		cards.show(service_panel, "Welcome_panel");
	}		
}