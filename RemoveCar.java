package p1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
public class RemoveCar extends JFrame implements ActionListener 
{

	private JLabel l1,l2;
	private JTextField tid,tno;
	private JButton brem,bdis,bback;
	
	public RemoveCar()
	{
		super("Removing Car Window...");
		
		ArrayList<RegData> list4 = new ArrayList<RegData>();
		Container c=getContentPane();
		c.setLayout(new GridLayout(4,2));
		tno=new JTextField(20);
		brem=new JButton("Remove Car/s");
		brem.addActionListener(this);
		bback=new JButton("Back");
		bback.addActionListener(this);
		bdis=new JButton("Display Car List");
		bdis.addActionListener(this);
		Font f=new Font("Chiller",Font.BOLD,27);
		l1=new JLabel("to go back to admin->");
		l1.setFont(f);
		l1.setForeground(Color.GREEN);
		
		Font f1=new Font("Chiller",Font.BOLD,27);
		l2=new JLabel("Car Number");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		ImageIcon keyhand=new ImageIcon("cross.jpg");
		ImageIcon ret=new ImageIcon("r1.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		
		c.add(l2);c.add(tno);
		c.add(brem);c.add(bdis);
		c.add(l1);c.add(bback);
		
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	String no;
	@Override
	public void actionPerformed(ActionEvent arg) 
	{
		no=tno.getText();
		SearchCar scr = new SearchCar();
		int a = scr.searchNo(no);
		if(arg.getSource()==brem)
		{
			if(a == -1)
			{
				JOptionPane.showMessageDialog(this, "No registered Car in that number");
				tno.setText("");
			}
			else
			{
				new DeleteCar(a);
				JOptionPane.showMessageDialog(this, "Car deleted From List Successfully...");
				tno.setText("");
			}
		}
		if(arg.getSource()==bdis)
		{
			new DisplayCarList();
		}
		if(arg.getSource()==bback)
		{	
			new Administration("Welcome to admin...");
			setVisible(false);
		}
	}
}



	

	

