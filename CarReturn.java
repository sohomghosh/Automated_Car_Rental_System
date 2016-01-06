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
public class CarReturn extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	private JTextField cusid,thrs,cmodl;
	private JButton bdone,bback;
	private String systime;
	private String sysdate;
	private JTextField carid;
	
	public CarReturn(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(9,2));
		
		cusid=new JTextField(10);
		cmodl=new JTextField(10);
		thrs=new JTextField(10);
		carid=new JTextField(10);
		bdone=new JButton("DONE");
		bback=new JButton("BACK");
		
		Font f=new Font("Chiller",Font.BOLD,20);
		l1=new JLabel("CAR RETURN DETAILS.........");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l2=new JLabel("Enter CUS MAIL ID");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		l9=new JLabel("CAR Model");
		l9.setFont(f1);
		l9.setForeground(Color.RED);
		
		l3=new JLabel("Enter CAR NO");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		l4=new JLabel("No. of hours");
		l4.setFont(f1);
		l4.setForeground(Color.RED);
		
		l5=new JLabel("Current time");
		l5.setFont(f1);
		l5.setForeground(Color.RED);

		l7=new JLabel("Current Date");
		l7.setFont(f1);
		l7.setForeground(Color.RED);
		
		
		Calendar cal = Calendar.getInstance();
		
        String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
	    String cmin = ""+cal.get(Calendar.MINUTE);
	    String csec =""+cal.get(Calendar.SECOND);
	    systime = chr+":"+cmin+":"+csec; 

	    bdone.addActionListener(this);
	    bback.addActionListener(this);
		  
		l6=new JLabel(systime);
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	String dateonly = df.format(dt);
    	sysdate=dateonly;
    	
    	l8=new JLabel(sysdate);
    	ImageIcon keyhand=new ImageIcon("keyhand.jpg");
		ImageIcon ret=new ImageIcon("return.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		c.add(l1);c.add(new JLabel(""));
		c.add(l2);c.add(cusid);
		c.add(l9);c.add(cmodl);
		c.add(l3);c.add(carid);
		c.add(l4);c.add(thrs);
		c.add(l5);c.add(l6);
		c.add(l7);c.add(l8);
		c.add(bback);c.add(bdone);
		
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent arg)
	{
		if(arg.getSource()==bdone)
		{
			SearchCus ob1=new SearchCus();
			String  mail=cusid.getText();
			int k=ob1.searchName(mail);
			String  carn=carid.getText();
			GetRate obj3=new GetRate();
			String hrate = obj3.GetRate(carn);
			SearchCar ob2=new SearchCar();
			int v=ob2.searchNo(carn);
			SearchAvailableCars ob5=new SearchAvailableCars();
			int z=ob5.searchName(carn);
			if(k!=-1&&v!=-1&&z==-1)//cus exists and car exists and if car has been booked 
			{
				double hrrt = Double.parseDouble(hrate);
				double hrs=Double.parseDouble(thrs.getText());
				double amt=hrs*hrrt;
				JOptionPane.showMessageDialog(this, "Amount is"+amt);
				RegCollection r= new RegCollection(amt,cmodl.getText(),carn);
				SearchCar ob4=new SearchCar();
				int f=ob4.searchModl(cmodl.getText());
				RegCar ra=new RegCar(cmodl.getText(),hrate,"Y",carid.getText());
				new UpdateUnavailableToAvailable(ra,f);
				 new AddCollInfo(r);
				 carid.setText(""); 
					cusid.setText("");
					thrs.setText("");
					cmodl.setText("");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Enter proper car no/ cus id");
				carid.setText(""); 
				cusid.setText("");
				thrs.setText("");
				cmodl.setText("");
			}
			
		}
		if(arg.getSource()==bback)
		{
			new OperatorPanel("Welcome to operator panel");
			setVisible(false);
		}	
	}
}