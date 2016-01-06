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
public class CusLogin extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5,l6,l11,l12;
	private JTextField cusid;
	private JButton bdone;
	private JButton bavailcars;
	private String systime;
	private String sysdate;
	public CusLogin(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));
		
		cusid=new JTextField(5);
		bdone=new JButton("DONE");
		bdone.addActionListener(this);
		
		bavailcars=new JButton("Show available cars");
		bavailcars.addActionListener(this);
		Font f=new Font("Chiller",Font.BOLD,20);
		l1=new JLabel("CAR LOG IN.........");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l2=new JLabel("Enter Customer's mail");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		
		l3=new JLabel("To see list of available cars");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		l4=new JLabel("Current time");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		
		l5=new JLabel("Current date");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		Calendar cal = Calendar.getInstance();
		
        String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
	    String cmin = ""+cal.get(Calendar.MINUTE);
	    String csec =""+cal.get(Calendar.SECOND);
	    systime = chr+":"+cmin+":"+csec;
	    
	    l6=new JLabel("");
		l11=new JLabel(systime);
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	String dateonly = df.format(dt);
    	sysdate=dateonly;
    	l12=new JLabel(sysdate);
		
		
		c.add(l1);c.add(new JLabel(""));
		c.add(l2);c.add(cusid);
		c.add(l3);c.add(bavailcars);
		c.add(l4);c.add(l11);
		c.add(l5);c.add(l12);
		c.add(l6);c.add(bdone);
		
		setSize(350, 425);
		setLocation(400,200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent arg)
	{
		if(arg.getSource()==bavailcars)
		{
			new ShowAvailableCars();
			setVisible(false);
		}
		
		
		SearchCus ob1=new SearchCus();
		String  mail=cusid.getText();
		int k=ob1.searchName(mail);
		if(k!=-1)
		{
			if(arg.getSource()==bdone)
			{
				JOptionPane.showMessageDialog(this, "You don't have a account... u need to create an account at first");
				new Search("Customer Log In dedtails......");
				setVisible(false);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(this, "You don't have a account... u need to create an account at first");
			   new OperatorPanel("Welcome to Operator's Panel");
		}
		
	}

		public static void main(String[] args) {
		new CusLogin("Customer Log In dedtails......");
		}
}