package p1;

import java.awt.Color;
import java.text.DateFormat;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.util.Scanner;

public class Registration extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5,l6,l8,l9,l10,l11,l12;
	private JTextField tid,tmail,tph;

	private JTextField tpass;//tpass=desnination
	private JTextField  tadd;
	private JButton bsubmit,bback;
	private String systime;
	private String sysdate;
	private JComboBox carname;
	ArrayList<RegData> list4=new ArrayList<RegData>();
	public Registration(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(9,2));
		
		tid=new JTextField(20);//name
		tmail=new JTextField(20);//mail
		tpass=new JTextField(20);//destination
		tph=new JTextField(10);//phone no
		tadd=new JTextField();//address
		bback=new JButton("Back");
		bback.addActionListener(this);
		
		bsubmit=new JButton("Register");
		bsubmit.addActionListener(this);
		Font f=new Font("Chiller",Font.BOLD,27);
		l1=new JLabel("REGISTRATION.........");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l2=new JLabel("Enter Name");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		l3=new JLabel("Enter EmailID");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		l4=new JLabel("Enter Destination");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		l5=new JLabel("Enter Address");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		

		l6=new JLabel("Enter Phone Number");
		l6.setFont(f1);
	    l6.setForeground(Color.RED);
			

		l8=new JLabel("Current Time");
		l8.setFont(f1);
		l8.setForeground(Color.RED);
		
		Calendar cal = Calendar.getInstance();
		
        String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
	    String cmin = ""+cal.get(Calendar.MINUTE);
	    String csec =""+cal.get(Calendar.SECOND);
	    systime = chr+":"+cmin+":"+csec;
	    
	    l9=new JLabel("Current Date");
		l9.setFont(f1);
		l9.setForeground(Color.RED);
		
		
		l11=new JLabel(systime);
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	String dateonly = df.format(dt);
    	sysdate=dateonly;
    	l12=new JLabel(sysdate);
	    
	    l10=new JLabel("");
	    ImageIcon keyhand=new ImageIcon("register.jpg");
		
	    c.add(l1);c.add(new JLabel(keyhand));
	    c.add(l2);c.add(tid);
	    c.add(l3);c.add(tmail);
	    c.add(l4);c.add(tpass);
	    c.add(l5);c.add(tadd);
	    c.add(l6);c.add(tph);
	    c.add(l8);c.add(l11);
	    c.add(l9);c.add(l12);
	    c.add(bback);c.add(bsubmit);
	    setSize(475, 475);
	    setLocation(465, 175);
	    setResizable(true);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setVisible(true);
	}
	String nm, mail, pass,add,ph;
	public void actionPerformed(ActionEvent arg) 
	{
		   nm=tid.getText().trim();
		   mail=tmail.getText();
		   pass=tpass.getText();
		   add=tadd.getText();
		   ph=tph.getText();
			if(arg.getSource()==bsubmit)
			{		
				SearchCus ob1=new SearchCus();
				int k=ob1.searchName(mail);
				int v=ob1.searchPh(ph);
				if(k==-1&&v==-1)//both phone number and mail id must be unique
				{
					RegData r;
					Scanner sc2 = new Scanner(mail);
					Scanner sc3 = new Scanner(nm);
					Scanner sc4 = new Scanner(ph);
					String match1=sc3.findInLine("^[A-Z a-z]{1,25}$");
					String match2=sc2.findInLine("^(\\w)+@(\\w+\\.)(\\w+\\.)?[A-Za-z]+$");
					String match3=sc4.findInLine("^[0-9]{10}$");
					if(match1!=null&&match2!=null&&match3!=null)
					{
						r=new RegData(nm,mail,pass,add,ph);
						list4.add(r);
						new AddInfo(r);
						JOptionPane.showMessageDialog(this, "Thank You for Registering...");
						new OperatorPanel("Welcome to Operator's Panel");
						setVisible(false);
					}
					 else
					 {
						 JOptionPane.showMessageDialog(this, "Enter proper data");
						 tmail.setText("");
						 new Registration("Regsiter here");
					 }
				}
				else if(k==-1 && v!=-1)
				{
					 JOptionPane.showMessageDialog(this, "this phone number already exists. Enter ph no");
					 tph.setText("");
					
				}
				else if(k!=-1 && v==-1)
				{
					 JOptionPane.showMessageDialog(this, "this mail id already exists. Enter mail id");
					 tmail.setText("");
				}
				else if(k==v)
				{
						JOptionPane.showMessageDialog(this, "You are already a Registered customer.. proceed directly to car booking");
					   new OperatorPanel("Welcome to Operator's Panel");
					   setVisible(false);
				}
			}
			if(arg.getSource()==bback)
			{		
				new OperatorPanel("Operator's zone ");
				setVisible(false);;
			}
	}		
	
}
