package p1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.net.URL;

public class FirstFrame extends JFrame implements ActionListener  
{
	private JLabel l1,l2,l3,l4,l5,l6;
	private JButton badmin,boperator;
	public FirstFrame(String title)
	{
		super("...WELCOME TO BHARAT CAR RENTAL SYSTEM PORTAL...");
		Font f = new Font("Bradley Hand ITC", Font.BOLD, 30);
		
		l6 = new JLabel(" ...BHARAT CAR RENTALS      ");
		l6.setFont(f);
		l6.setForeground(Color.BLUE);
		Font f1 = new Font("Chiller", Font.BOLD, 25);
		l1 = new JLabel("WISHING U A HAPPY JOURNEY!!! ");
		l1.setFont(f1);
		l1.setForeground(Color.GREEN);
		l2 = new JLabel("Mob:8001567276 website: www.bharatCRS.co.in   ");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		l3 = new JLabel("  Book ur car! Enjoy ur ride! Ur safety our concern!!");
		l3.setFont(f1);
		l3.setForeground(Color.PINK);
		
		l5 = new JLabel("Booking car made EaSy!!! now automated!!!");
		l5.setFont(f1);
		l5.setForeground(Color.PINK);
		
		l4 = new JLabel("            email: info@bharatCRS.co.in");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,3));
		
		ImageIcon oj1=new ImageIcon("carrent.jpg");
		ImageIcon oj2=new ImageIcon("left.jpg");
		ImageIcon admin=new ImageIcon("admin1.jpg");
		ImageIcon opr=new ImageIcon("operator.jpg");
		ImageIcon oj3=new ImageIcon("right.jpg");
		ImageIcon ojl1=new ImageIcon("l1.jpg");
		ImageIcon ol2=new ImageIcon("l2.jpg");
		
		badmin=new JButton("           ADMIN            ",admin);
		badmin.addActionListener(this);
		boperator=new JButton("           Operator            ",opr);
		boperator.addActionListener(this);
		
		c.add(new JLabel(""));c.add(l6);c.add(new JLabel(""));
		c.add(l1);c.add(new JLabel(""));c.add(l3);
		c.add(new JLabel(ojl1));c.add(badmin);c.add(new JLabel(ol2));
		c.add(new JLabel(""));c.add(new JLabel(""));c.add(new JLabel(""));
		c.add(new JLabel(oj1));c.add(boperator);c.add(new JLabel(oj3));
		c.add(l5);c.add(l2);c.add(l4);
		
		badmin.setForeground(Color.BLACK);
        badmin.setBackground(Color.pink);
        
        boperator.setForeground(Color.BLACK);
        boperator.setBackground(Color.pink);
        
		setSize(1600, 900);
		setLocation(0,0);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);	
		setForeground(Color.LIGHT_GRAY);
		setBackground(Color.PINK); 
	}
	public static void main(String[] args)
	{
		
		new FirstFrame("Choose User");
	}

	@Override
	public void actionPerformed(ActionEvent arg) 
	{
		if(arg.getSource()==badmin)
		{
			
			new LoginId();
		}
		
		if(arg.getSource()==boperator)
		{
			new OperatorPanel("Welcome to Operator's Panel...");
		}
		
	}

}
