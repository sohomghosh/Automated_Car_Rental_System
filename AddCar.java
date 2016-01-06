package p1;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class AddCar extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5;
	private JTextField  tmod, tno, thrate;
	private JButton badd,bdis, badmin;
	public AddCar(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));
		tmod=new JTextField(20);
		tno=new JTextField(20);
		thrate=new JTextField(20);
		
		badd=new JButton("Add Cars");
		badd.addActionListener(this);bdis=new JButton("Display Car List");
		bdis.addActionListener(this);
		badmin=new JButton("Back to Admin");
		badmin.addActionListener(this);
		
		Font f=new Font("Chiller",Font.BOLD,27);
		l1=new JLabel("to go back to admin->");
		l1.setFont(f);
		l1.setForeground(Color.GREEN);
		
		Font f1=new Font("Chiller",Font.BOLD,27);
		l2=new JLabel("Car Model");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		Font f2=new Font("Chiller",Font.BOLD,27);
		l3=new JLabel("Car Number");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		Font f3=new Font("Chiller",Font.BOLD,27);
		l4=new JLabel("Car Type");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		
		Font f4=new Font("Chiller",Font.BOLD,27);
		l5=new JLabel("Hourly Rate");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		ImageIcon keyhand=new ImageIcon("plus.jpg");
		ImageIcon ret=new ImageIcon("r1.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		c.add(l2);c.add(tmod);
		c.add(l3);c.add(tno);
		c.add(l5);c.add(thrate);
		c.add(badd);c.add(bdis);
		c.add(l1);c.add(badmin);
		
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);


	}
	String model,no,rate,typ;//id=hourly rate
	public void actionPerformed(ActionEvent arg) 
	{
		model=tmod.getText();
		no=tno.getText();
		rate=thrate.getText();
		if(arg.getSource()==badd)
		{		
		   
			SearchCar scr = new SearchCar();
			int aa = scr.searchNo(no);
			
			if(aa==-1)//if no car of that no exists
			{
				Scanner sc4 = new Scanner(no);
				String match1=sc4.findInLine("^[A-Za-z0-9]{9}$");
				Scanner sc3 = new Scanner(rate);
				String match2=sc3.findInLine("^[0-9]{1,5}$");
				if(match1!=null&&match2!=null)
				{
				RegCar r=new RegCar(model,rate,"Y",no);
				new AddCarInfo(r);
				JOptionPane.showMessageDialog(this, "Car & Hourly Rate Added Successfully");
				tmod.setText("");
				tno.setText("");
				 thrate.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Enter proper data");
					 tno.setText("");
					 thrate.setText("");	
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this, "This Car already exists");
			}
	   }
		if(arg.getSource()==bdis)
		{	
			new DisplayCarList();	
		}
		if(arg.getSource()==badmin)
		{
			new Administration("Admin Panel");
			setVisible(false);
		}
	}	
}
		
	



