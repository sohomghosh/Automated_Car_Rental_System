package p1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;


public class RemoveCus extends JFrame implements ActionListener 
{

	private JLabel l1,l2;
	private JTextField tid;
	private JButton brem,bdis,bback;
	
	public RemoveCus()
	{
		super("Removing A Customer....");
		
		ArrayList<RegData> list4 = new ArrayList<RegData>();
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		
		tid=new JTextField(20);
		brem=new JButton("Remove Customer");
		brem.addActionListener(this);
		bback=new JButton("BACK");
		bback.addActionListener(this);
		
		bdis=new JButton("Display Customer List");
		bdis.addActionListener(this);
	
		Font f=new Font("Chiller",Font.BOLD,27);
		l1=new JLabel("To go back to admin ->");
		l1.setFont(f);
		l1.setForeground(Color.GREEN);
		
		Font f1=new Font("Chiller",Font.BOLD,27);
		l2=new JLabel("Customer mail Id");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		ImageIcon keyhand=new ImageIcon("cross.jpg");
		ImageIcon ret=new ImageIcon("men.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		
		c.add(l2);c.add(tid);
		c.add(brem);c.add(bdis);
		c.add(l1);c.add(bback);
		
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	String id;
	public void actionPerformed(ActionEvent arg) 
	{
		id=tid.getText();
		SearchCus scr = new SearchCus();
		int a = scr.searchName(id);
		if(arg.getSource()==brem)
		{
			if(a == -1)
			{
				JOptionPane.showMessageDialog(this, "No such registered Customer");
				tid.setText("");
			}
			else
			{
				new DeleteCus(a);
				JOptionPane.showMessageDialog(this, "Customer deleted From List Successfully...");
				tid.setText("");
			}
		}
		if(arg.getSource()==bdis)
		{
			new DisplayFromFile();
			tid.setText("");
		}
		if(arg.getSource()==bback)
		{	
			new Administration("Welcome to admin...");
			setVisible(false);
		}
	}
	public static void main(String args[])
	{
		new RemoveCus();
	}
}



	

	

