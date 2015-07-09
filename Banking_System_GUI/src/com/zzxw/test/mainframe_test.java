package com.zzxw.test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JDesktopPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import javax.swing.JComboBox;

public class mainframe_test extends JFrame {

JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
JPanel Question_T,ready;
JPanel Submit;
JPanel Score;
JPanel instructor;
JPanel login;
JPanel Question_M;
JPanel student;
JRadioButton True;
JRadioButton False;
JButton button_2;
 JTree tree_1;
 JTextPane textPane;
 JTextPane textPane_1;
 String[] answerTF={"","","","","","","","","","",""};
 String choice;
 String[] answer={"","","","","","","","","","",""};
 int i;
 ButtonGroup BG1,BG2;
 JRadioButton rdbtnNewRadioButton;
 JRadioButton rdbtnB;
 JRadioButton rdbtnC;
 JRadioButton rdbtnD;
 int result=0;
 JLabel lblNewLabel_1;
 JPanel content ;
 private JLabel label;
 private JDesktopPane desktopPane_1;
 private JPanel teacher;
 private JPanel Add;
 private JPanel Select;
 private JPanel Index;
 private JLabel label_4;
 private JLabel label_5;
 private JButton addquestion;
 private JButton selquestion;
 private JLabel lblNewLabel_2;
 private JLabel lblIfYouWant;
 private JTextField qField;
 private JLabel lblQuestion;
 private JTextField aField;
 private JLabel lblAnswer;
 private JButton Insert;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainframe_test frame = new mainframe_test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainframe_test() {
		setTitle("EXAM SYSTEM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		
		
		
		login = new JPanel();
		contentPane.add(login, "login");
		login.setLayout(null);
		
		JButton button = new JButton("STUDENT");
		button.setFont(new Font("SimSun", Font.PLAIN, 22));
		button.setBounds(425, 133, 146, 45);
		login.add(button);
		button.addActionListener(new PersonAction());
		
		JButton btnInstructor = new JButton("INSTRUCTOR");
		btnInstructor.setFont(new Font("SimSun", Font.PLAIN, 22));
		btnInstructor.setBounds(425, 233, 146, 45);
		login.add(btnInstructor);
		btnInstructor.addActionListener(new teacherAction());
		
		JLabel lblUcid = new JLabel("UCID");
		lblUcid.setFont(new Font("SimSun", Font.PLAIN, 30));
		lblUcid.setBounds(39, 101, 146, 32);
		login.add(lblUcid);
		
		textField = new JTextField();
		textField.setFont(new Font("SimSun", Font.PLAIN, 30));
		textField.setColumns(10);
		textField.setBounds(39, 146, 206, 32);
		login.add(textField);
		
		JLabel label_1 = new JLabel("OR");
		label_1.setFont(new Font("SimSun", Font.PLAIN, 34));
		label_1.setBounds(486, 191, 81, 32);
		login.add(label_1);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 30));
		label_2.setBounds(39, 191, 146, 32);
		login.add(label_2);
		
		button_2 = new JButton("EXIT SYSTEM");
		button_2.setFont(new Font("SimSun", Font.PLAIN, 30));
		button_2.addActionListener(new button2());
		button_2.setBounds(224, 329, 213, 45);
		login.add(button_2);
		
		JLabel label_3 = new JLabel("     Welcome to online exam system");
		label_3.setFont(new Font("Arial", Font.BOLD, 38));
		label_3.setBounds(0, 13, 677, 68);
		login.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("SimSun", Font.PLAIN, 30));
		passwordField.setBounds(39, 246, 206, 32);
		login.add(passwordField);
		
		student = new JPanel();
		contentPane.add(student, "student");
		student.setLayout(null);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(0, 0, 681, 417);
		student.add(desktopPane);
		
		JLabel lblStudentId = new JLabel("UCID:");
		lblStudentId.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentId.setFont(new Font("SimSun", Font.PLAIN, 24));
		lblStudentId.setBounds(14, 0, 153, 40);
		desktopPane.add(lblStudentId);
		
		JPanel tree = new JPanel();
		tree.setBackground(Color.WHITE);
		tree.setBounds(0, 36, 131, 381);
		desktopPane.add(tree);
		tree.setLayout(null);
		
		tree_1 = new JTree();
		tree_1.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Index") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Questions");
						node_1.add(new DefaultMutableTreeNode("1"));
						node_1.add(new DefaultMutableTreeNode("2"));
						node_1.add(new DefaultMutableTreeNode("3"));
						node_1.add(new DefaultMutableTreeNode("4"));
						node_1.add(new DefaultMutableTreeNode("5"));
						node_1.add(new DefaultMutableTreeNode("6"));
						node_1.add(new DefaultMutableTreeNode("7"));
						node_1.add(new DefaultMutableTreeNode("8"));
						node_1.add(new DefaultMutableTreeNode("9"));
						node_1.add(new DefaultMutableTreeNode("10"));
					getContentPane().add(node_1);
					getContentPane().add(new DefaultMutableTreeNode("Submit"));
				}
			}
		));
		tree_1.setBounds(14, 13, 103, 322);
		tree_1.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                treeValueChanged(evt);
            }
        });
		tree.add(tree_1);
		
		
		content = new JPanel();
		content.setBounds(134, 36, 547, 381);
		desktopPane.add(content);
		content.setLayout(new CardLayout(0, 0));
		
	    ready = new JPanel();
		content.add(ready, "ready");
		ready.setLayout(null);
		
		JLabel lblTheExamsTotal = new JLabel("The exam's total time is 3 H.");
		lblTheExamsTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheExamsTotal.setFont(new Font("SimSun", Font.BOLD, 30));
		lblTheExamsTotal.setBounds(25, 24, 508, 67);
		ready.add(lblTheExamsTotal);
		
		JLabel lblWishYouAll = new JLabel("Wish you all the best.");
		lblWishYouAll.setFont(new Font("SimSun", Font.BOLD, 30));
		lblWishYouAll.setHorizontalAlignment(SwingConstants.CENTER);
		lblWishYouAll.setBounds(25, 106, 508, 67);
		ready.add(lblWishYouAll);
		
		JLabel lblReady = new JLabel("Ready?");
		lblReady.setHorizontalAlignment(SwingConstants.CENTER);
		lblReady.setFont(new Font("SimSun", Font.BOLD, 30));
		lblReady.setBounds(112, 186, 313, 67);
		ready.add(lblReady);
		
		JButton btnNewButton = new JButton("Go");
		btnNewButton.setFont(new Font("SimSun", Font.PLAIN, 20));
		btnNewButton.setBounds(197, 266, 130, 42);
		btnNewButton.addActionListener(new Go());
		ready.add(btnNewButton);
		
		Question_T = new JPanel();
		content.add(Question_T, "Question_T");
		Question_T.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(33, 13, 489, 225);
		Question_T.add(textPane);
		
		True = new JRadioButton("True");
		True.setBounds(48, 278, 157, 27);
		True.addItemListener(new TFRadio());
		Question_T.add(True);
		
		False = new JRadioButton("False");
		False.setBounds(319, 278, 157, 27);
		False.addItemListener(new TFRadio());
		Question_T.add(False);
		BG1=new ButtonGroup();
		BG1.add(True);
		BG1.add(False);

		
		BG2=new ButtonGroup();
		
		Question_M = new JPanel();
		content.add(Question_M, "Question_M");
		Question_M.setLayout(null);
		
		textPane_1 = new JTextPane();
		textPane_1.setBounds(27, 13, 489, 225);
		Question_M.add(textPane_1);
		
		rdbtnNewRadioButton = new JRadioButton("A");
		rdbtnNewRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnNewRadioButton.setBounds(26, 257, 81, 27);
		rdbtnNewRadioButton.addItemListener(new TFRadio());
		Question_M.add(rdbtnNewRadioButton);

		
		
		rdbtnB = new JRadioButton("B");
		rdbtnB.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnB.setBounds(275, 257, 81, 27);
		rdbtnB.addItemListener(new TFRadio());
		Question_M.add(rdbtnB);
		
		rdbtnC = new JRadioButton("C");
		rdbtnC.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnC.setBounds(27, 289, 81, 27);
		rdbtnC.addItemListener(new TFRadio());
		Question_M.add(rdbtnC);
		
		rdbtnD = new JRadioButton("D");
		rdbtnD.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnD.setBounds(275, 289, 81, 27);
		rdbtnD.addItemListener(new TFRadio());
		Question_M.add(rdbtnD);
		
		BG2.add(rdbtnNewRadioButton);
		BG2.add(rdbtnB);
		BG2.add(rdbtnC);
		BG2.add(rdbtnD);
		
		Submit = new JPanel();
		content.add(Submit, "Submit");
		Submit.setLayout(null);
		
		JLabel lblHaveYouFinished = new JLabel("Have you finished all the questions?");
		lblHaveYouFinished.setHorizontalAlignment(SwingConstants.CENTER);
		lblHaveYouFinished.setFont(new Font("SimSun", Font.BOLD, 22));
		lblHaveYouFinished.setBounds(14, 42, 508, 59);
		Submit.add(lblHaveYouFinished);
		
		JLabel lblOnceYouSubmitno = new JLabel("Once you submit,");
		lblOnceYouSubmitno.setHorizontalAlignment(SwingConstants.CENTER);
		lblOnceYouSubmitno.setFont(new Font("SimSun", Font.BOLD, 22));
		lblOnceYouSubmitno.setBounds(24, 111, 508, 59);
		Submit.add(lblOnceYouSubmitno);
		
		JLabel lblYouCantChange = new JLabel("there's no chance to change your answers.");
		lblYouCantChange.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouCantChange.setFont(new Font("SimSun", Font.BOLD, 22));
		lblYouCantChange.setBounds(0, 183, 532, 59);
		Submit.add(lblYouCantChange);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("SimSun", Font.PLAIN, 24));
		btnSubmit.setBounds(222, 291, 124, 42);
		btnSubmit.addActionListener(new Submit());
		Submit.add(btnSubmit);
		
		Score = new JPanel();
		content.add(Score, "Score");
		Score.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Your final score is :");
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(14, 106, 357, 69);
		Score.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel(" ");
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 30));
		lblNewLabel_1.setBounds(392, 106, 103, 69);
		
		Score.add(lblNewLabel_1);
		
		label = new JLabel(" ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SimSun", Font.PLAIN, 24));
		label.setText(" ");
		label.setBounds(164, 4, 83, 33);
		desktopPane.add(label);
		
		instructor = new JPanel();
		contentPane.add(instructor, "instructor");
		instructor.setLayout(null);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBounds(0, 0, 681, 417);
		instructor.add(desktopPane_1);
		desktopPane_1.setBackground(Color.WHITE);
		
		teacher = new JPanel();
		teacher.setBounds(0, 80, 681, 337);
		desktopPane_1.add(teacher);
		teacher.setLayout(new CardLayout(0, 0));
		
		Index = new JPanel();
		teacher.add(Index, "Index");
		Index.setLayout(null);
		
		lblNewLabel_2 = new JLabel("If you want to add a question,please click add button.");
		lblNewLabel_2.setFont(new Font("SimSun", Font.PLAIN, 21));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 23, 681, 83);
		Index.add(lblNewLabel_2);
		
		lblIfYouWant = new JLabel("If you want to select a question,please click select button.");
		lblIfYouWant.setHorizontalAlignment(SwingConstants.CENTER);
		lblIfYouWant.setFont(new Font("SimSun", Font.PLAIN, 21));
		lblIfYouWant.setBounds(0, 102, 681, 83);
		Index.add(lblIfYouWant);
		
		Add = new JPanel();
		teacher.add(Add, "Add");
		Add.setLayout(null);
		
		qField = new JTextField();
		qField.setBounds(186, 13, 481, 178);
		Add.add(qField);
		qField.setColumns(10);
		
		lblQuestion = new JLabel("Question:");
		lblQuestion.setFont(new Font("SimSun", Font.PLAIN, 25));
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(14, 13, 158, 51);
		Add.add(lblQuestion);
		
		aField = new JTextField();
		aField.setBounds(186, 207, 197, 72);
		Add.add(aField);
		aField.setColumns(10);
		
		lblAnswer = new JLabel("Answer:");
		lblAnswer.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswer.setFont(new Font("SimSun", Font.PLAIN, 25));
		lblAnswer.setBounds(14, 207, 158, 51);
		Add.add(lblAnswer);
		
		Insert = new JButton("Insert");
		Insert.setBounds(484, 223, 143, 40);
		Insert.addActionListener(new QuestionAction());
		Add.add(Insert);
		
		Select = new JPanel();
		teacher.add(Select, "Select");
		Select.setLayout(null);
		
		label_4 = new JLabel("UCID:");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("SimSun", Font.PLAIN, 24));
		label_4.setBounds(0, 0, 153, 40);
		desktopPane_1.add(label_4);
		
		label_5 = new JLabel(" ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("SimSun", Font.PLAIN, 24));
		label_5.setText(" ");
		label_5.setBounds(167, 0, 100, 40);
		desktopPane_1.add(label_5);
		
		addquestion = new JButton("Add question");
		addquestion.setBounds(342, 4, 143, 40);
		addquestion.addActionListener(new Add());
		desktopPane_1.add(addquestion);
		
		selquestion = new JButton("Select question");
		selquestion.setBounds(499, 4, 168, 40);
		selquestion.addActionListener(new Select());
		desktopPane_1.add(selquestion);
	}
private void treeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
        
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                      tree_1.getLastSelectedPathComponent();
           String option =(String) node.getUserObject();
           CardLayout cards = (CardLayout)student.getLayout();
           CardLayout cards1 = (CardLayout)content.getLayout();
           if(option.equals("1"))
           {
               i=1;
               cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
		       p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				System.out.println(answerTF[i-1]);
				BG1.clearSelection();
				
             
           }
           else if(option.equals("2"))
           {
        	   i=2;
        	   cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG1.clearSelection();
           }
           else if(option.equals("3"))
           {
        	   i=3;
        	   cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG1.clearSelection();
           }
           else if(option.equals("4"))
           {
        	   i=4;
        	   cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG1.clearSelection();
           }
           else if(option.equals("5"))
           {
        	   i=5;
        	   cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG1.clearSelection();
           }
           else if(option.equals("6"))
           {
        	   i=6;
        	   cards1.show(content, "Question_T");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG1.clearSelection();
				
           }
           else if(option.equals("7"))
           {
        	   i=7;
        	   
        	   cards1.show(content, "Question_M");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane_1.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG2.clearSelection();
				
           }
           else if(option.equals("8"))
           {
        	   i=8;
        	   cards1.show(content, "Question_M");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane_1.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG2.clearSelection();
           }
           else if(option.equals("9"))
           {
        	   i=9;
        	   cards1.show(content, "Question_M");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane_1.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG2.clearSelection();
           }
           else if(option.equals("10"))
           {
        	   i=10;
        	   cards1.show(content, "Question_M");
               String j=String.valueOf(i);
               Question p= new Question();
				Client cl=new Client();
				String Send="question"+"|"+i;
				System.out.println(Send);
				String Receive= cl.login(Send);
				p=Question.ConverToObject(Receive);
				textPane_1.setText(p.Question);
				answerTF[i-1]=p.Answer;
				BG2.clearSelection();
				
           }
           else if(option.equals("Submit"))
           {
              
        	   cards1.show(content,"Submit");
           }
           else if(option.equals("Index"))
           {
              
               cards.show(student,"student");
           }
                   
       }
	class PersonAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String UCID=textField.getText();
			String Password=String.valueOf(passwordField.getPassword());
			if(!UCID.isEmpty()&&!Password.isEmpty())
			{
				Person p= new Person();
				p.UCID=UCID;
				p.Password=Password;
				Client cl=new Client();
				String Send="start"+"|"+Person.ConvertToString(p);
				System.out.println(Send);
				String Receive= cl.login(Send);
				label.setText(p.UCID);
			System.out.println(Receive);
				String[] msg = Receive.split("\\|");
	            if(msg[0].equalsIgnoreCase("confirm"))
	            {
	            	 CardLayout cards = (CardLayout)contentPane.getLayout();
	            	 cards.show(contentPane,"student");
	            	 
	            	 i=1;
	                String j=String.valueOf(i);
	                Question c= new Question();
	                Send="question"+"|"+i;
	 				System.out.println(Send);
	 				Receive= cl.login(Send);
	 		       c=Question.ConverToObject(Receive);
	 				textPane.setText(c.Question);
	 				answerTF[i-1]=c.Answer;
	            }
	            }
		}
		
	}
	class teacherAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String UCID=textField.getText();
			String Password=String.valueOf(passwordField.getPassword());
			String TID = "theo";
			String TPSD="password";
			String[] msg1={"",""};
			msg1[0]=UCID;
			msg1[1]=Password;
			
			if(!UCID.isEmpty()&&!Password.isEmpty())
			{
				label_5.setText(msg1[0]);
	            if(msg1[0].equalsIgnoreCase(TID)&&msg1[1].equalsIgnoreCase(TPSD))
	            {
	            	 CardLayout cards = (CardLayout)contentPane.getLayout();
	            	 cards.show(contentPane,"instructor");
	            }
			}
		}
		
	}
	class QuestionAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String allquestion=qField.getText();
			String answer=aField.getText();
			String[] q1=allquestion.split("\\|");
			if(!allquestion.isEmpty()&&!answer.isEmpty())
			{
				Question q= new Question();
				q.QID=q1[0];			
				q.Question=q1[1];
				q.Answer=answer;
				Client cl=new Client();
				String Send="add"+"|"+Question.ConvertToString(q);
				System.out.println(Send);
				String Receive= cl.login(Send);
			System.out.println(Receive);
				String[] msg = Receive.split("\\|");
	            
	            }
		}
		
	}
	class TFRadio implements ItemListener{
		 public void itemStateChanged(ItemEvent e) {
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		           JRadioButton jrb = (JRadioButton) e.getSource();
		           choice=jrb.getActionCommand();
		           answer[i-1]=choice;
		           System.out.println(answer[i-1]);
	
		           
		        }
		 }
	}
	public int getscore() {
        result=0;
		for(int w=0;w<=9;w++)
		{
			 System.out.println(answer[w]+ answerTF[w]);
			if (answer[w].equalsIgnoreCase(answerTF[w]))
        	 {
        		 result=result+1;
        		
        		
        	 }
		}

		return result;
	}
	class Submit implements ActionListener{
		public void actionPerformed(ActionEvent e){
			  CardLayout cards = (CardLayout)content.getLayout();
			  cards.show(content,"Score");
			   int z=getscore()*10;
			  String j=String.valueOf(z);
			  lblNewLabel_1.setText(j);
			  
		}
		}
	class button2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			  System.exit(0);
			  
		}
		}
	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e){
			CardLayout cards = (CardLayout)teacher.getLayout();
			  cards.show(teacher,"Add");
			  
		}
		}
	class Select implements ActionListener{
		public void actionPerformed(ActionEvent e){
			CardLayout cards = (CardLayout)teacher.getLayout();
			  cards.show(teacher,"Select");
			  
		}
		}
	class Go implements ActionListener{
		public void actionPerformed(ActionEvent e){
			  CardLayout cards = (CardLayout)content.getLayout();
			  cards.show(content,"Question_T");
		}
		}	
}

