package com.zzxw.layout;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

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

public class MainFrame_1 {

	private JFrame frame;
	private JTextField username_input;
	private JPasswordField password_input;
	private JButton login_button;
	private JPasswordField psw_new;
	private JPasswordField psw_confirm;
	public JTree service_tree;
	public JPanel service_panel;
	public JPanel content;

	public JLabel userName;
	public JLabel psw_reset_label;
	public JButton back;
	public JButton exit_button;
	public JButton confirm;

	private String name = "bob";
	private String pw = "1234";
	private int security = 3;
	private JTextField new_username;
	private JPasswordField new_password;
	private JButton btnOk;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame_1 window = new MainFrame_1();
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
	public MainFrame_1() {
		initialize();
		TextFieldHandler tfh = new TextFieldHandler();
		username_input.addActionListener(tfh);
		password_input.addActionListener(tfh);
		login_button.addActionListener(tfh);
		//confirm.addActionListener(tfh);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Banking System");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width - 608)/2, (d.height - 482)/2, 608, 482);
		//frame.setBounds(100, 100, 608, 482);
		frame.setResizable(false);
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

		userName = new JLabel("Guest");
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

		login_button = new JButton("LOGIN");

		login_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		login_button.setBounds(322, 312, 99, 40);
		login.add(login_button);

		exit_button = new JButton("EXIT");
		exit_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		exit_button.setBounds(433, 312, 108, 40);
		login.add(exit_button);
		exit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});


		JLabel psw_forget = new JLabel(
				"<html><a href='#'>Forget Password</a></html>");
		psw_forget.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "reset");
				label1.setVisible(false);
				userName.setVisible(false);
				psw_reset_label = new JLabel("Reset your password");
				psw_reset_label.setFont(new Font("Verdana", Font.PLAIN, 20));
				psw_reset_label.setHorizontalAlignment(SwingConstants.CENTER);
				psw_reset_label.setBounds(143, 13, 267, 39);
				
				//frame.getContentPane().add(psw_reset_label);
				psw_reset_label.setVisible(true);
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

		new_username = new JTextField();
		new_username.setFont(new Font("Verdana", Font.PLAIN, 25));
		new_username.setColumns(10);
		new_username.setBounds(323, 74, 200, 50);
		register.add(new_username);

		JLabel label_1 = new JLabel("PASSWORD:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		label_1.setBounds(91, 188, 218, 62);
		register.add(label_1);

		new_password = new JPasswordField();
		new_password.setFont(new Font("Verdana", Font.PLAIN, 25));
		new_password.setBounds(323, 200, 200, 50);
		register.add(new_password);

		btnOk = new JButton("OK");
		btnOk.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnOk.setBounds(259, 319, 99, 40);
		register.add(btnOk);

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!new_password.getText().isEmpty()&&!new_password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Register Successfully");
					CardLayout cards = (CardLayout) content.getLayout();
					cards.show(content, "login");
				}
				else {
					JOptionPane.showMessageDialog(null, "Entry is Empty");
				}
			}
		});

		JPanel business = new JPanel();
		business.setLayout(null);
		content.add(business, "business");

		service_tree = new JTree();
		service_tree.setFont(new Font("Verdana", Font.PLAIN, 16));
		service_tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Service") {
			private static final long serialVersionUID = 1L;

			{
				add(new DefaultMutableTreeNode("Withdraw"));
				add(new DefaultMutableTreeNode("Deposit"));
				add(new DefaultMutableTreeNode("Balance"));
			}
		}));
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

		JPanel welcome_panel = new JPanel();
		service_panel.add(welcome_panel, "welcome_panel");
		welcome_panel.setLayout(null);

		JLabel service_option = new JLabel(
				"<html>Please select one <br> &nbsp; &nbsp; &nbsp;  option on the left .</html>");
		service_option.setFont(new Font("Verdana", Font.PLAIN, 20));
		service_option.setHorizontalAlignment(SwingConstants.CENTER);
		service_option.setBounds(81, 101, 278, 107);
		welcome_panel.add(service_option);

		JLabel Thankyou_label = new JLabel(
				"Thank you for using our banking system");
		Thankyou_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Thankyou_label.setHorizontalAlignment(SwingConstants.CENTER);
		Thankyou_label.setBounds(12, 13, 431, 75);
		welcome_panel.add(Thankyou_label);

		JPanel withdraw_panel = new JPanel();
		service_panel.add(withdraw_panel, "withdraw_panel");
		withdraw_panel.setLayout(null);

		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(128, 96, 97, 25);
		withdraw_panel.add(btnNewButton_1);

		JPanel deposit_panel = new JPanel();
		service_panel.add(deposit_panel, "deposit_panel");
		deposit_panel.setLayout(null);

		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(30, 269, 97, 25);
		deposit_panel.add(btnNewButton_2);

		JPanel balance_panel = new JPanel();
		service_panel.add(balance_panel, "balance_panel");
		balance_panel.setLayout(null);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(291, 300, 97, 25);
		balance_panel.add(btnNewButton_3);

		JPanel reset = new JPanel();
		content.add(reset, "reset");
		reset.setLayout(null);

		JLabel psw_new_label = new JLabel("NEW PASSWORD:");
		psw_new_label.setFont(new Font("Verdana", Font.PLAIN, 20));
		psw_new_label.setHorizontalAlignment(SwingConstants.CENTER);
		psw_new_label.setBounds(32, 81, 251, 48);
		reset.add(psw_new_label);

		JLabel psw_confirm_label = new JLabel("CONFIRM PASSWORD:");
		psw_confirm_label.setHorizontalAlignment(SwingConstants.CENTER);
		psw_confirm_label.setFont(new Font("Verdana", Font.PLAIN, 20));
		psw_confirm_label.setBounds(32, 189, 251, 48);
		reset.add(psw_confirm_label);

		psw_new = new JPasswordField();
		psw_new.setFont(new Font("Tahoma", Font.PLAIN, 20));
		psw_new.setBounds(316, 79, 200, 50);
		reset.add(psw_new);

		psw_confirm = new JPasswordField();
		psw_confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		psw_confirm.setBounds(316, 187, 200, 50);
		reset.add(psw_confirm);

		back = new JButton("BACK");
		back.setFont(new Font("Verdana", Font.PLAIN, 15));
		back.setBounds(269, 310, 89, 35);
		reset.add(back);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "login");
			}
		});

		confirm = new JButton("CONFIRM");
		confirm.setFont(new Font("Verdana", Font.PLAIN, 15));
		confirm.setBounds(399, 310, 129, 35);
		reset.add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (psw_new.getText().equals(psw_confirm.getText())) {
					JOptionPane.showMessageDialog(null, "Password Changed Successfully");
					CardLayout cards = (CardLayout) content.getLayout();
					cards.show(content, "login");
				}
				else{
					JOptionPane.showMessageDialog(null, "The passwords don't match, please check");
				}

			}
		});
	}

	private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) service_tree
				.getLastSelectedPathComponent();
		String option = (String) node.getUserObject();
		CardLayout cards1 = (CardLayout) content.getLayout();
		CardLayout cards = (CardLayout) service_panel.getLayout();
		if (option.equals("Withdraw")) {
			cards.show(service_panel, "withdraw_panel");
		} else if (option.equals("Deposit")) {
			cards.show(service_panel, "deposit_panel");
		} else if (option.equals("Balance")) {
			cards.show(service_panel, "balance_panel");
		}
	}


	public class TextFieldHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent event) {

			String account = username_input.getText();
			if(!psw_new.getText().isEmpty()){
				pw = psw_new.getText();
			}
			else if(!new_username.getText().isEmpty()&&!new_password.getText().isEmpty()){
				pw = new_password.getText();
				name = new_username.getText();
			}
			String password = password_input.getText();
			System.out.println("The user account: " + account);
			System.out.println("The password: " + password);
			System.out.println(psw_new.getText());
			if(account.equals(name) && password.equals(pw)){//use equals method to compare 2 strings
				//System.out.println("Log in successfully");
				JOptionPane.showMessageDialog(null, "Log in Successfully");
				JOptionPane.showMessageDialog(null, "Welcome " + name);
				userName.setText(name);

				CardLayout cards = (CardLayout) content.getLayout();
				cards.show(content, "business");
			}
			else if(account.isEmpty())
			{
				JOptionPane.showConfirmDialog(null, "The account entry is empty, try again?", "Acccount", JOptionPane.OK_CANCEL_OPTION);
			}
			else if(password.isEmpty())
			{
				JOptionPane.showConfirmDialog(null, "The password entry is empty, try again?", "Password", JOptionPane.OK_CANCEL_OPTION);
			}
			else {
				JOptionPane.showMessageDialog(null, "The user account or the password is not correct.");
				security --;
				if(security == 0)
				{
					username_input.setEditable(false);
					password_input.setEditable(false);
					JOptionPane.showMessageDialog(null, "The system has locked down\n " + "you are not allowed to enter"
							+ " the account and the password");
					JOptionPane.showMessageDialog(null, "System closed");
					System.exit(0);
				}
			}
		}
	}
}
