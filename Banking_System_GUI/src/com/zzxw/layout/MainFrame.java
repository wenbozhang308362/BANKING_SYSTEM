package com.zzxw.layout;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.zzxw.layout.actions.Exit;
import com.zzxw.layout.actions.PasswordUpdateMouseAdapter;
import com.zzxw.layout.actions.PswForgetMouseAdapter;
import com.zzxw.layout.actions.RegisterAction;
import com.zzxw.layout.actions.RegisterMouseAdapter;
import com.zzxw.layout.actions.back_btn;
import com.zzxw.layout.actions.back_btn_reset;
import com.zzxw.layout.actions.login_btn;
import com.zzxw.layout.actions.logoff_btn;

public class MainFrame {

	private JFrame frame;
	private JTree service_tree;
	private JPanel service_panel;
	private JPanel content;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private static String[][] info;
	private JLabel userName;
	private JLabel Uname;
	private JLabel accountNumber;
	private JLabel ActNum;
	public JTextField username_input;
	JLabel label_4;
	JLabel label_7;
	JButton button;
	JButton button_2;
	JLabel Detail_balance;
	JLabel reset_label_info;

	static BankIO bIO = new BankIO();
	private JTextField email4reset;
	private JTextField Reset_Username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try {
						info = bIO.readexcel();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.out.println("Read error from file!");
					}
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
		frame = new JFrame("ZZWX Banking System");
		frame.setBounds(100, 100, 608, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		content = new JPanel();
		content.setBounds(0, 52, 590, 385);
		frame.getContentPane().add(content, "content");
		content.setLayout(new CardLayout(0, 0));

		JLabel info1 = new JLabel("Welcome:");
		info1.setHorizontalAlignment(SwingConstants.RIGHT);
		info1.setBounds(12, 13, 64, 26);
		info1.setVisible(true);
		frame.getContentPane().add(info1);

		userName = new JLabel("Guest");
		userName.setBounds(80, 18, 56, 16);
		frame.getContentPane().add(userName);

		JLabel accountNumberLabel = new JLabel("Account#:");
		accountNumberLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		accountNumberLabel.setBounds(295, 13, 75, 26);
		frame.getContentPane().add(accountNumberLabel);
		accountNumberLabel.setVisible(false);

		accountNumber = new JLabel("");
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

		JPasswordField password_input = new JPasswordField();
		password_input.setFont(new Font("Verdana", Font.PLAIN, 25));
		password_input.setBounds(301, 201, 200, 50);
		login.add(password_input);

		JButton login_button = new JButton("LOGIN");
		login_button.addActionListener(new login_btn(content, username_input,
				password_input, info, userName, accountNumberLabel,
				accountNumber));
		login_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		login_button.setBounds(322, 312, 99, 40);
		login.add(login_button);

		JButton exit_button = new JButton("EXIT");
		exit_button.addActionListener(new Exit());
		exit_button.setFont(new Font("Verdana", Font.PLAIN, 16));
		exit_button.setBounds(433, 312, 108, 40);
		login.add(exit_button);

		JLabel psw_forget = new JLabel(
				"<html><a href='#'>Forget Password</a></html>");
		psw_forget.addMouseListener(new PswForgetMouseAdapter(content, info1,
				userName));
		psw_forget.setToolTipText("Click me if you forget the password.");
		psw_forget.setHorizontalAlignment(SwingConstants.CENTER);
		psw_forget.setBounds(345, 264, 114, 26);
		login.add(psw_forget);

		JLabel register_label = new JLabel(
				"<html><a href='#'>Register</a></html>");
		register_label.setFont(new Font("Verdana", Font.PLAIN, 16));
		register_label.addMouseListener(new RegisterMouseAdapter(content,
				info1, userName));
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

		btnOk.addActionListener(new RegisterAction(new_password, info1,
				userName, content, new_username, info));

		JButton btn_back = new JButton("BACK");
		btn_back.addActionListener(new logoff_btn(content, accountNumberLabel,
				accountNumber, userName));
		btn_back.setFont(new Font("Verdana", Font.PLAIN, 16));
		btn_back.setBounds(229, 319, 99, 40);
		register.add(btn_back);

		JPanel business = new JPanel();
		business.setLayout(null);
		content.add(business, "business");

		service_tree = new JTree();
		service_tree.setBackground(SystemColor.window);
		service_tree.setFont(new Font("Arial", Font.PLAIN, 14));
		service_tree.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(
				"Index") {
			private static final long serialVersionUID = 5789142137729073831L;

			{
				DefaultMutableTreeNode node_1;
				node_1 = new DefaultMutableTreeNode("Bank Services");
				node_1.add(new DefaultMutableTreeNode("Withdraw"));
				node_1.add(new DefaultMutableTreeNode("Deposit"));
				add(node_1);
				node_1 = new DefaultMutableTreeNode("Self Service");
				node_1.add(new DefaultMutableTreeNode("Details"));
				node_1.add(new DefaultMutableTreeNode("Transaction"));
				add(node_1);
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
		service_panel.add(welcome_panel, "Welcome_panel");
		welcome_panel.setLayout(null);

		JLabel service_option = new JLabel(
				"<html>Please select one service <br> &nbsp; &nbsp; &nbsp;  option on the left .</html>");
		service_option.setFont(new Font("Verdana", Font.PLAIN, 20));
		service_option.setHorizontalAlignment(SwingConstants.CENTER);
		service_option.setBounds(81, 101, 278, 107);
		welcome_panel.add(service_option);

		JLabel Thankyou_label = new JLabel(
				"Thank you for using zzxw banking system");
		Thankyou_label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Thankyou_label.setHorizontalAlignment(SwingConstants.CENTER);
		Thankyou_label.setBounds(12, 13, 431, 75);
		welcome_panel.add(Thankyou_label);

		JButton Logoff = new JButton("LogOff");
		Logoff.addActionListener(new logoff_btn(content, accountNumberLabel,
				accountNumber, userName));
		Logoff.setFont(new Font("Arial", Font.PLAIN, 15));
		Logoff.setBounds(262, 289, 97, 43);
		welcome_panel.add(Logoff);

		JPanel withdraw_panel = new JPanel();
		service_panel.add(withdraw_panel, "Withdraw_panel");
		withdraw_panel.setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBounds(222, 166, 185, 37);
		withdraw_panel.add(textField);

		JLabel label_2 = new JLabel("WithDraw:");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Verdana", Font.BOLD, 30));
		label_2.setBounds(0, 156, 206, 59);
		withdraw_panel.add(label_2);

		JLabel label_3 = new JLabel("Balance:");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Verdana", Font.BOLD, 30));
		label_3.setBounds(14, 59, 180, 48);
		withdraw_panel.add(label_3);

		label_4 = new JLabel("$");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setFont(new Font("Verdana", Font.BOLD, 30));
		label_4.setBounds(222, 59, 185, 48);
		withdraw_panel.add(label_4);

		button = new JButton("OK");

		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(135, 299, 97, 25);
		withdraw_panel.add(button);
		button.addActionListener(new Ok_btn_Action());

		JButton button_1 = new JButton("BACK");
		button_1.addActionListener(new back_btn(service_panel));
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_1.setBounds(291, 299, 97, 25);
		withdraw_panel.add(button_1);

		JPanel deposit_panel = new JPanel();
		service_panel.add(deposit_panel, "Deposit_panel");
		deposit_panel.setLayout(null);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Verdana", Font.PLAIN, 30));
		textField_1.setColumns(10);
		textField_1.setBounds(222, 166, 185, 37);
		deposit_panel.add(textField_1);

		JLabel lblDeposit = new JLabel("Deposit:");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setFont(new Font("Verdana", Font.BOLD, 30));
		lblDeposit.setBounds(0, 156, 206, 59);
		deposit_panel.add(lblDeposit);

		JLabel label_6 = new JLabel("Balance:");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("Verdana", Font.BOLD, 30));
		label_6.setBounds(14, 59, 180, 48);
		deposit_panel.add(label_6);

		label_7 = new JLabel("$");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setFont(new Font("Verdana", Font.BOLD, 30));
		label_7.setBounds(222, 59, 185, 48);
		deposit_panel.add(label_7);

		button_2 = new JButton("OK");

		button_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_2.setBounds(135, 299, 97, 25);
		button_2.addActionListener(new Depo_OK_btn_Action());
		deposit_panel.add(button_2);		

		JButton button_3 = new JButton("BACK");
		button_3.addActionListener(new back_btn(service_panel));
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button_3.setBounds(291, 299, 97, 25);
		deposit_panel.add(button_3);

		JPanel details_panel = new JPanel();
		service_panel.add(details_panel, "Details_panel");
		details_panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 45, 133, 47);
		details_panel.add(lblNewLabel);

		Uname = new JLabel("");
		Uname.setFont(new Font("Arial", Font.PLAIN, 20));
		Uname.setHorizontalAlignment(SwingConstants.CENTER);
		Uname.setBounds(183, 45, 211, 47);
		details_panel.add(Uname);

		JLabel lblNewLabel_2 = new JLabel("Account#:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(27, 121, 133, 47);
		details_panel.add(lblNewLabel_2);

		ActNum = new JLabel("");
		ActNum.setFont(new Font("Arial", Font.PLAIN, 20));
		ActNum.setHorizontalAlignment(SwingConstants.CENTER);
		ActNum.setBounds(183, 121, 211, 47);
		details_panel.add(ActNum);

		JLabel lblNewLabel_4 = new JLabel("Balance:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(27, 197, 133, 47);
		details_panel.add(lblNewLabel_4);

		JLabel lblNewLabel_6 = new JLabel(
				"<html><a href='#'>Update your password</a></html>");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(84, 279, 272, 47);
		lblNewLabel_6.addMouseListener(new PasswordUpdateMouseAdapter(
				service_panel));
		details_panel.add(lblNewLabel_6);

		Detail_balance = new JLabel("");
		Detail_balance.setHorizontalAlignment(SwingConstants.CENTER);
		Detail_balance.setFont(new Font("Arial", Font.PLAIN, 20));
		Detail_balance.setBounds(183, 197, 211, 47);
		details_panel.add(Detail_balance);

		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new back_btn(service_panel));
		btnNewButton_2.setBounds(319, 339, 97, 25);
		details_panel.add(btnNewButton_2);

		JPanel transaction_panel = new JPanel();
		service_panel.add(transaction_panel, "Transaction_panel");
		transaction_panel.setLayout(null);

		JPanel password_panel = new JPanel();
		service_panel.add(password_panel, "Password_panel");
		password_panel.setLayout(null);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBounds(140, 296, 94, 41);
		password_panel.add(btnNewButton);
		btnNewButton.addActionListener(new PwdUpdate_Action());

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new back_btn(service_panel));
		btnNewButton_1.setBounds(290, 296, 73, 41);
		password_panel.add(btnNewButton_1);

		JLabel lblNewLabel_7 = new JLabel("Old Password:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(25, 62, 160, 29);
		password_panel.add(lblNewLabel_7);

		passwordField = new JPasswordField();
		passwordField.setBounds(197, 63, 137, 28);
		password_panel.add(passwordField);

		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewPassword.setBounds(25, 124, 160, 29);
		password_panel.add(lblNewPassword);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(197, 125, 137, 28);
		password_panel.add(passwordField_1);

		JLabel lblPasswordConfirm = new JLabel("Password Confirm:");
		lblPasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPasswordConfirm.setFont(new Font("Arial", Font.PLAIN, 16));
		lblPasswordConfirm.setBounds(25, 195, 160, 29);
		password_panel.add(lblPasswordConfirm);

		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(197, 196, 137, 28);
		password_panel.add(passwordField_2);

		JPanel reset = new JPanel();
		content.add(reset, "reset");
		reset.setLayout(null);

		JButton back = new JButton("BACK");
		back.setFont(new Font("Verdana", Font.PLAIN, 15));
		back.setBounds(251, 334, 89, 35);
		reset.add(back);
		back.addActionListener(new back_btn_reset(content));

		JButton Reset = new JButton("RESET");
		Reset.setFont(new Font("Verdana", Font.PLAIN, 15));
		Reset.setBounds(392, 334, 89, 35);
		reset.add(Reset);
		Reset.addActionListener(new pwdReset_Action());

		reset_label_info = new JLabel("Please enter your Email & Username : ");
		reset_label_info.setFont(new Font("Verdana", Font.PLAIN, 22));
		reset_label_info.setHorizontalAlignment(SwingConstants.CENTER);
		reset_label_info.setBounds(30, 55, 458, 68);
		reset.add(reset_label_info);

		email4reset = new JTextField();
		email4reset.setFont(new Font("Verdana", Font.PLAIN, 25));
		email4reset.setColumns(10);
		email4reset.setBounds(158, 134, 257, 50);
		reset.add(email4reset);
		email4reset.setToolTipText("Please enter your email here.");

		Reset_Username = new JTextField();
		Reset_Username.setFont(new Font("Verdana", Font.PLAIN, 25));
		Reset_Username.setColumns(10);
		Reset_Username.setBounds(158, 227, 257, 50);
		reset.add(Reset_Username);
		Reset_Username.setToolTipText("Please enter your username here.");

	}

	private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
		DefaultMutableTreeNode node = (DefaultMutableTreeNode) service_tree
				.getLastSelectedPathComponent();
		String option = (String) node.getUserObject();
		String username= userName.getText();
		CardLayout cards = (CardLayout) service_panel.getLayout();
		if (option.equals("Withdraw")) {
			cards.show(service_panel, "Withdraw_panel");
			try {
				info = bIO.readexcel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}
			LogicalImple li= new LogicalImple();
			label_4.setText(li.getBalance(username, info));

		} else if (option.equals("Deposit")) {
			cards.show(service_panel, "Deposit_panel");
			try {
				info = bIO.readexcel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}
			LogicalImple li= new LogicalImple();
			label_7.setText(li.getBalance(username, info));
		} else if (option.equals("Details")) {
			cards.show(service_panel, "Details_panel");
			Uname.setText(username);
			String accountN=accountNumber.getText();
			ActNum.setText(accountN);	

			try {
				info = bIO.readexcel();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}
			LogicalImple li= new LogicalImple();
			Detail_balance.setText(li.getBalance(username, info));
		}else if(option.equals("Transaction")){
			cards.show(service_panel, "Transaction_panel");
		}
	}


	class Depo_OK_btn_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = userName.getText();
			String depositNum = textField_1.getText();
			LogicalImple li = new LogicalImple();
			li.deposit(depositNum, username, info);

			try {
				info = bIO.readexcel();
				//					System.out.println("balance from depo:" + info[2][3]);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}

			label_7.setText(li.getBalance(username, info));

		}
	}

	class Ok_btn_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = userName.getText();
			String withdrawNum = textField.getText();
			LogicalImple li = new LogicalImple();
			int i=li.withdraw(withdrawNum, username, info);
			if(i==1){
				JOptionPane.showMessageDialog(null, "Withdraw Amount Exceeds Current Balance.");
			}
			if (i == 2){
				JOptionPane.showMessageDialog(null, "Please deposit some money.");
				CardLayout cards = (CardLayout) service_panel.getLayout();
				cards.show(service_panel, "Deposit_panel");
			}
			try {
				info = bIO.readexcel();
				//					System.out.println("balance from withd:"+info[2][3]);
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Read error from file!");
			}
			label_4.setText(li.getBalance(username, info));
		}
	}
	class PwdUpdate_Action implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = userName.getText();
			String oldPwd = "";
			for(char a:passwordField.getPassword()){
				String temp=a+"";
				oldPwd+=temp;
			}
			String newPwd = "";
			for(char a:passwordField_1.getPassword()){
				String temp=a+"";
				newPwd+=temp;
			}
			String newPwdConfirm = "";
			for(char a:passwordField_2.getPassword()){	
				String temp=a+"";
				newPwdConfirm+=temp;
			}

			if(!newPwd.equals(newPwdConfirm)){
				JOptionPane.showMessageDialog(null, "Passwords don't match");
			}
			else{
				LogicalImple li = new LogicalImple();
				int i=li.changePwd(oldPwd, newPwd, username, info);
				if(i==1){
					JOptionPane.showMessageDialog(null, "Old Passworld is WRONG");
				}
				else if (i == 2) {
					JOptionPane.showMessageDialog(null, "New password should be different from the old password!");
				}
				else if (i == 3) {
					JOptionPane.showMessageDialog(null, "Password should contain at least 6 characters!");
				}
				else if (i == 4){
					JOptionPane.showMessageDialog(null, "Password should be different from the username.");
				}
				else {
					JOptionPane.showMessageDialog(null, "Password has been changed successfully");
					passwordField.setText("");
					CardLayout cards = (CardLayout) service_panel.getLayout();
					cards.show(service_panel, "Details_panel");
					//passwordField1.setText("");
					//passwordField2.setText("");
				}
			}
		}
	}

	class pwdReset_Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {

			String email=email4reset.getText();
			String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";  
			Pattern regex = Pattern.compile(check);  
			Matcher matcher = regex.matcher(email);  
			boolean isMatched = matcher.matches();
			String username=Reset_Username.getText();
			if(isMatched){
				if(!username.equals("")){
					CardLayout cards = (CardLayout) content.getLayout();
					cards.show(content, "login");
					new LogicalImple().reset(username, email);
				} else {
					JOptionPane.showMessageDialog(null, "Username is empty");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Please input a valid email address!");
			}

		}
	}
}

