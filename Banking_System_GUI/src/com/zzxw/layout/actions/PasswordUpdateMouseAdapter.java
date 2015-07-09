package com.zzxw.layout.actions;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class PasswordUpdateMouseAdapter extends MouseAdapter {
	private JPanel service_panel;

	public PasswordUpdateMouseAdapter(JPanel service_panel) {
		super();
		this.service_panel = service_panel;
	}

	public void mouseClicked(MouseEvent e) {
		CardLayout cards = (CardLayout) service_panel.getLayout();
		cards.show(service_panel, "Password_panel");

	}
}
