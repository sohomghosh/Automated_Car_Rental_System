package p1;

import java.awt.Color;
import java.util.*;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Administration extends JFrame implements ActionListener
{

	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	private String AddCar;
	private String Remove;
	private String HourlyRate;
	private String ViewAvail;
	private String ViewCust;
	private String ViewColl;
	private String DelCust;
	private String Update;

	private JButton bAddCar, bRemove, bHourlyRate, bViewAvail, bViewCust,
			bViewColl, bDelCust, bUpdate,blogout;

	ArrayList<RegData> list1 = new ArrayList<RegData>();

	public Administration(String title) {
		super(title);

		Container c = getContentPane();
		c.setLayout(new GridLayout(10, 1));

		bAddCar = new JButton("Add New Cars/Define Hourly Rate/s");
		bAddCar.addActionListener(this);

		bRemove = new JButton("Remove Damaged Cars");
		bRemove.addActionListener(this);

		bHourlyRate = new JButton("Display Full Car List");
		bHourlyRate.addActionListener(this);

		bViewAvail = new JButton("Available Cars");
		bViewAvail.addActionListener(this);

		bViewCust = new JButton("View customers");
		bViewCust.addActionListener(this);

		bViewColl = new JButton("View Collection Report");
		bViewColl.addActionListener(this);

		bDelCust = new JButton("Delete a customer");
		bDelCust.addActionListener(this);

		bUpdate = new JButton("Update Hourly Rate/s");
		bUpdate.addActionListener(this);
		
		blogout = new JButton("LOGOUT");
		blogout.addActionListener(this);
		Font f = new Font("Arial Rounded MT Bold", Font.BOLD, 27);
		l1 = new JLabel("ADMINISTRATION");
		l1.setFont(f);
		l1.setForeground(Color.RED);

		c.add(l1);
		c.add(bAddCar);
		c.add(bRemove);
		c.add(bHourlyRate);
		c.add(bViewAvail);
		c.add(bViewCust);
		c.add(bViewColl);
		c.add(bDelCust);
		c.add(bUpdate);
		c.add(blogout);
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent arg) 
	{
		if(arg.getSource()==blogout)
		{
			JOptionPane.showMessageDialog(this, "Logged out successfully");
			new FirstFrame("Choose User");
			setVisible(false);
		}
		if(arg.getSource()==bViewAvail)
		{
			new ShowAvailableCars();//new FirstFrame("Choose User");
		}
		if(arg.getSource()==bAddCar)
		{
			new AddCar("Add new car/hourly rate");
			setVisible(false);
		}
		if(arg.getSource()==bRemove)
		{
			new RemoveCar();
			setVisible(false);
		}
		if(arg.getSource()==bViewCust)
		{
			new DisplayFromFile();
		}
		if(arg.getSource()==bDelCust)
		{
			new RemoveCus();//setVisible(false);
		}
		if(arg.getSource()==bHourlyRate)//displaying car list
		{
			new DisplayCarList();
		}
		if(arg.getSource()==bUpdate)
		{
			new UpdateHourlyWindow();
			setVisible(false);
		}
		if(arg.getSource()==bViewColl)
		{
			new DisplayCollection();
			TotalMoneyCalculate obj8=new TotalMoneyCalculate();
			double l=obj8.TotalMoneyCalculate();
			JOptionPane.showMessageDialog(this, "Total Amount collected"+l);
		}	
	}
}
