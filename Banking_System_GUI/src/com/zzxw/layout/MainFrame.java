package com.zzxw.layout;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JToolBar;
import javax.swing.JComboBox;
import javax.swing.JProgressBar;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

public class MainFrame {

	private JFrame frame;
	private JTextField username_input;
	private JPasswordField password_input;
	private JPasswordField username4Reset;
	private JTree service_tree;
	private JPanel service_panel;
	private JPanel content;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Banking System");
		frame.setBounds(100, 100, 608, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		content = new JPanel();
		content.setBounds(0, 52, 590, 385);
		frame.getContentPane().add(content);
		content.setLayout(new CardLayout(0, 0));

		JLabel label1 = new JLabel("Welcome:");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setBounds(12, 13, 64, 26);
		frame.getContentPane().add(label1);

		JLabel userName = new JLabel("Guest");
		userName.setBounds(80, 18, 56, 16);
		frame.getContentPane().add(userName);

		JLabel label2 = new JLabel("Account#:");
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		label2.setBounds(295, 13, 75, 26);
		frame.getContentPane().add(label2);
		label2.setVisible(false);

		JLabel accountNumber = new JLabel("");
		accountNumber.setBounds(376, 18, 56, 16);
		frame.getContentPane().add(accountNumber);
		accountNumber.setVisible(false);

		JPanel login = new JPanel();
		content.add(login, "login");
		login.setLayout(null);

		JLabel login_username = new JLabel("USERNAME:");
		login_username.setFont(new Font("Verdana", Font.PLAIN, 30));
		login_username.setHorizontalAlignment(SwingConstants.CENTER);
		login_username.setBounds(69, 85, 218, 40);
		login.add(login_username);

		JLabel login_password = new JLabel("PASSWORD:");
		login_password.setFont(new Font("Verdana", Font.PLAIN, 30));
		login_password.setHorizontalAlignment(SwingConstants.CENTER);
		login_password.setBounds(69, 189, 218, 62);
		login.add(login_password);

		username_input = new JTextField();
		username_input.setFont(new Font("Verdana", Font.PLAIN, 25));
		username_input.setBounds(301, 75, 200, 50);
		login.add(username_input);
		username_input.setColumns(10);

		password_input = new JPasswordField();
		password_input.setFont(new Font("Verdana", Font.PLAIN, 25));
		password_input.setBounds(301, 201, 200, 50);
		login.add(password_input);

		JButton login_button = new JButton("LOGIN");
		login_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "business");
			}
		});
		login_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		login_button.setBounds(322, 312, 99, 40);
		login.add(login_button);

		JButton exit_button = new JButton("EXIT");
		exit_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		exit_button.setBounds(433, 312, 108, 40);
		login.add(exit_button);

		JLabel psw_forget = new JLabel(
				"<html><a href='#'>Forget Password</a></html>");
		psw_forget.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "reset");
				label1.setVisible(false);
				userName.setVisible(false);
				JLabel psw_reset_label = new JLabel("Reset your password");
				psw_reset_label.setFont(new Font("Verdana", Font.PLAIN, 20));
				psw_reset_label.setHorizontalAlignment(SwingConstants.CENTER);
				psw_reset_label.setBounds(143, 13, 267, 39);
				frame.getContentPane().add(psw_reset_label);
			}
		});
		psw_forget.setToolTipText("Click me if you forget the password.");
		psw_forget.setHorizontalAlignment(SwingConstants.CENTER);
		psw_forget.setBounds(345, 264, 114, 26);
		login.add(psw_forget);

		JLabel register_label = new JLabel(
				"<html><a href='#'>Register</a></html>");
		register_label.setFont(new Font("Verdana", Font.PLAIN, 16));
		register_label.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "register");
				label1.setVisible(false);
				userName.setVisible(false);
				
			}
		});
		register_label.setToolTipText("Create a new account");
		register_label.setHorizontalAlignment(SwingConstants.CENTER);
		register_label.setBounds(60, 321, 114, 26);
		login.add(register_label);

		JLabel welcome_info = new JLabel("Welcome to our banking system");
		welcome_info.setFont(new Font("Verdana", Font.PLAIN, 28));
		welcome_info.setHorizontalAlignment(SwingConstants.CENTER);
		welcome_info.setBounds(43, 13, 482, 49);
		login.add(welcome_info);

		JPanel register = new JPanel();
		register.setLayout(null);
		content.add(register, "register");

		JLabel label = new JLabel("USERNAME:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Verdana", Font.PLAIN, 30));
		label.setBounds(91, 84, 218, 40);
		register.add(label);

		JTextField new_username = new JTextField();
		new_username.setFont(new Font("Verdana", Font.PLAIN, 25));
		new_username.setColumns(10);
		new_username.setBounds(323, 74, 200, 50);
		register.add(new_username);

		JLabel label_1 = new JLabel("PASSWORD:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		label_1.setBounds(91, 188, 218, 62);
		register.add(label_1);

		JPasswordField new_password = new JPasswordField();
		new_password.setFont(new Font("Verdana", Font.PLAIN, 25));
		new_password.setBounds(323, 200, 200, 50);
		register.add(new_password);

		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOk.setBounds(389, 319, 99, 40);
		register.add(btnOk);
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new_password.getText().isEmpty()&&!new_password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Register Successfully");
					CardLayout cards = (CardLayout) content.getLayout();
					cards.show(content, "login");
					label1.setVisible(true);
					userName.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Entry is Empty");
				}
			}
		});

		JButton btn_back = new JButton("BACK");
		btn_back.setFont(new Font("Verdana", Font.PLAIN, 16));
		btn_back.setBounds(229, 319, 99, 40);
		register.add(btn_back);
		
		
		JPanel business = new JPanel();
		business.setLayout(null);
		content.add(business, "business");

		service_tree = new JTree();
		service_tree.setBackground(SystemColor.window);
		service_tree.setFont(new Font("Arial", Font.PLAIN, 14));
		service_tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Index") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Bank Service");
						node_1.add(new DefaultMutableTreeNode("Withdraw"));
						node_1.add(new DefaultMutableTreeNode("Deposit"));
						node_1.add(new DefaultMutableTreeNode("Balance"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Self Service");
						node_1.add(new DefaultMutableTreeNode("Details"));
						node_1.add(new DefaultMutableTreeNode("Password"));
						node_1.add(new DefaultMutableTreeNode("Transaction"));
					add(node_1);
				}
			}
		));
		service_tree.setBounds(0, 0, 135, 385);
		service_tree
				.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
					public void valueChanged(
							javax.swing.event.TreeSelectionEvent evt) {
						treeValueChanged(evt);
					}
				});
		business.add(service_tree);

		service_panel = new JPanel();
		service_panel.setBounds(135, 0, 455, 385);
		business.add(service_panel);
		service_panel.setLayout(new CardLayout(0, 0));

		JPanel Welcome_panel = new JPanel();
		service_panel.add(Welcome_panel, "welcome_panel");
		Welcome_panel.setLayout(null);

		JLabel service_option = new JLabel(
				"<html>Please select one <br> &nbsp; &nbsp; &nbsp;  option on the left .</html>");
		service_option.setFont(new Font("Verdana", Font.PLAIN, 20));
		service_option.setHorizontalAlignment(SwingConstants.CENTER);
		service_option.setBounds(81, 101, 278, 107);
		Welcome_panel.add(service_option);

		JLabel Thankyou_label = new JLabel(
				"Thank you for using our banking system");
		Thankyou_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Thankyou_label.setHorizontalAlignment(SwingConstants.CENTER);
		Thankyou_label.setBounds(12, 13, 431, 75);
		Welcome_panel.add(Thankyou_label);

		JPanel Wthdraw_panel = new JPanel();
		service_panel.add(Wthdraw_panel, "withdraw_panel");
		Wthdraw_panel.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBounds(236, 151, 185, 37);
		Wthdraw_panel.add(textField);
		
		JLabel label_2 = new JLabel("WithDraw:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Verdana", Font.BOLD, 30));
		label_2.setBounds(28, 141, 206, 59);
		Wthdraw_panel.add(label_2);
		
		JLabel label_3 = new JLabel("Balance:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Verdana", Font.BOLD, 30));
		label_3.setBounds(26, 33, 180, 48);
		Wthdraw_panel.add(label_3);
		
		JLabel label_4 = new JLabel("$");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Verdana", Font.BOLD, 30));
		label_4.setBounds(218, 33, 86, 48);
		Wthdraw_panel.add(label_4);
		
		JButton button = new JButton("OK");
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(149, 284, 97, 25);
		Wthdraw_panel.add(button);
		
		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) service_panel.getLayout();
				cards.show(service_panel, "Welcome_panel");
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(305, 284, 97, 25);
		Wthdraw_panel.add(button_1);

		JPanel Deposit_panel = new JPanel();
		service_panel.add(Deposit_panel, "deposit_panel");
		Deposit_panel.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(222, 166, 185, 37);
		Deposit_panel.add(textField_1);
		
		JLabel lblDeposit = new JLabel("Deposit:");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Verdana", Font.BOLD, 30));
		lblDeposit.setBounds(14, 156, 206, 59);
		Deposit_panel.add(lblDeposit);
		
		JLabel label_6 = new JLabel("Balance:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 30));
		label_6.setBounds(12, 48, 180, 48);
		Deposit_panel.add(label_6);
		
		JLabel label_7 = new JLabel("$");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Verdana", Font.BOLD, 30));
		label_7.setBounds(204, 48, 86, 48);
		Deposit_panel.add(label_7);
		
		JButton button_2 = new JButton("OK");
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(135, 299, 97, 25);
		Deposit_panel.add(button_2);
		
		JButton button_3 = new JButton("BACK");
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBounds(291, 299, 97, 25);
		Deposit_panel.add(button_3);
		
		JPanel Details_panel = new JPanel();
		service_panel.add(Details_panel, "details_panel");
		Details_panel.setLayout(null);
		
		JPanel Transaction_panel = new JPanel();
		service_panel.add(Transaction_panel, "transaction_panel");
		Transaction_panel.setLayout(null);

		JPanel reset = new JPanel();
		content.add(reset, "reset");
		reset.setLayout(null);

		username4Reset = new JPasswordField();
		username4Reset.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username4Reset.setBounds(285, 157, 200, 50);
		reset.add(username4Reset);

		JButton back = new JButton("BACK");
		back.setFont(new Font("Verdana", Font.PLAIN, 15));
		back.setBounds(269, 310, 89, 35);
		reset.add(back);

		JButton Reset = new JButton("RESET");
		Reset.setFont(new Font("Verdana", Font.PLAIN, 15));
		Reset.setBounds(399, 310, 129, 35);
		reset.add(Reset);
		
		JLabel reset_label_info = new JLabel("Please enter your Username: ");
		reset_label_info.setFont(new Font("Verdana", Font.PLAIN, 22));
		reset_label_info.setHorizontalAlignment(SwingConstants.CENTER);
		reset_label_info.setBounds(30, 55, 414, 68);
		reset.add(reset_label_info);

	}

	private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) service_tree
				.getLastSelectedPathComponent();
		String option = (String) node.getUserObject();
		CardLayout cards = (CardLayout) service_panel.getLayout();
		if (option.equals("Withdraw")) {
			cards.show(service_panel, "withdraw_panel");
		} else if (option.equals("Deposit")) {
			cards.show(service_panel, "deposit_panel");
		} else if (option.equals("Balance")) {
			cards.show(service_panel, "balance_panel");
		}
	}
}
