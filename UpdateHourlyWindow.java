package p1;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UpdateHourlyWindow extends JFrame implements ActionListener
{

	private JLabel l1,l2,l3,l4,l5;
	private JTextField  tmod, tno, thrate;
	private JButton bdone, badmin;
	 public UpdateHourlyWindow()
	{
		super("Update hourly Rate here...");
		Container c=getContentPane();
		c.setLayout(new GridLayout(5,2));
		tmod=new JTextField(20);
		tno=new JTextField(20);
		thrate=new JTextField(20);
		bdone=new JButton("Done");
		bdone.addActionListener(this);	
		badmin=new JButton("Back to Admin");
		badmin.addActionListener(this);
		
		Font f=new Font("Chiller",Font.BOLD,27);
		Font f1=new Font("Chiller",Font.BOLD,27);
		l2=new JLabel("Car Model");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		Font f2=new Font("Chiller",Font.BOLD,27);
		l3=new JLabel("Car Number");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		Font f3=new Font("Chiller",Font.BOLD,27);
		
		Font f4=new Font("Chiller",Font.BOLD,27);
		l5=new JLabel("Hourly Rate");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		
		ImageIcon keyhand=new ImageIcon("arrow.jpg");
		ImageIcon ret=new ImageIcon("money.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		c.add(l2);c.add(tmod);
		c.add(l3);c.add(tno);
		c.add(l5);c.add(thrate);
		c.add(bdone);c.add(badmin);
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
		if(arg.getSource()==bdone)
		{		
			SearchCar scr = new SearchCar();
			int aa = scr.searchNo(no);
			if(aa == -1)
			{
				JOptionPane.showMessageDialog(this, "Please Enter Valid Car Id...");
			}
			else
			{	
				
				RegCar r=new RegCar(model,rate,"Y",no);
				new UpdateHourlyRate(r,aa);
				
				JOptionPane.showMessageDialog(this, "Hourly Rate updated successfully");
			}	
			tmod.setText("");
			tno.setText("");
			thrate.setText("");
	   }
		if(arg.getSource()==badmin)
		{	
			new Administration("Admin Panel");
			setVisible(false);
		}
	}
}
