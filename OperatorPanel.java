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

public class OperatorPanel extends JFrame implements ActionListener
{

	private JLabel l1;
	private JButton bAddCus, bCarBook, bCarReturn, bViewCars,bback;	
	public OperatorPanel(String title) 
	{
		super(title);
		Container c = getContentPane();
		c.setLayout(new GridLayout(6, 1));
		bAddCus = new JButton("Add New Customer");
		bAddCus.addActionListener(this);
		bCarBook = new JButton("Car Booking");
		bCarBook.addActionListener(this);
		bback = new JButton("Back");
		bback.addActionListener(this);
		bCarReturn = new JButton("Car Return");
		bCarReturn.addActionListener(this);
		bViewCars = new JButton("View Available Cars");
		bViewCars.addActionListener(this);
		Font f = new Font("Arial Rounded MT Bold", Font.BOLD, 27);
		l1 = new JLabel("Operator's Panel");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		c.add(l1);
		c.add(bAddCus);
		c.add(bCarBook);
		c.add(bCarReturn);
		c.add(bViewCars);
		c.add(bback);
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent arg) 
	{		
		if(arg.getSource()==bCarReturn)
		{
			new CarReturn("CAR RETURN details......");
			setVisible(false);
		}
		if(arg.getSource()==bCarBook)
		{
			new CarBook("Car Booking Zone");
			setVisible(false);
		}
		if(arg.getSource()==bAddCus)
		{
			new Registration("Register here...");
		}
		if(arg.getSource()==bViewCars)
		{
			new ShowAvailableCars();
		}
		if(arg.getSource()==bback)
		{
			new FirstFrame("Welcome...");
			setVisible(false);
		}
	}
}