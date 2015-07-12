package com.zzxw.layout.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;


public class Exit implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, "Thank you again for using our banking system, have a nice day!");
			System.exit(0);
		}
}
