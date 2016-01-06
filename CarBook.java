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
public class CarBook extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5,l6,l7,l11,l12;
	private JTextField cusid;
	private JTextField carmodl;
	private JTextField carno;
	private JTextField hrs;
	private JButton bbook;
	private JButton bback;
	private String systime;
	private String sysdate;
	public CarBook(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(8,2));
		cusid=new JTextField(5);
		carmodl=new JTextField(10);
		carno=new JTextField(10);
		hrs=new JTextField(10);
		bbook=new JButton("BOOK");
		bbook.addActionListener(this);
		
		bback=new JButton("BACK");
		bback.addActionListener(this);
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l1=new JLabel("Enter Customer mail Id:");
		l1.setFont(f1);
		l1.setForeground(Color.RED);
		
		l2=new JLabel("Enter Car Model");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		
		l3=new JLabel("Enter Car No.");
		l3.setFont(f1);
		l3.setForeground(Color.RED);
		
		l5=new JLabel("Enter No. Of Hours");
		l5.setFont(f1);
		l5.setForeground(Color.RED);
		
		l6=new JLabel("System Date");
		l6.setFont(f1);
		l6.setForeground(Color.RED);
		
		l7=new JLabel("System Time");
		l7.setFont(f1);
		l7.setForeground(Color.RED);
		Calendar cal = Calendar.getInstance();
		
        String chr = ""+cal.get(Calendar.HOUR_OF_DAY);
	    String cmin = ""+cal.get(Calendar.MINUTE);
	    String csec =""+cal.get(Calendar.SECOND);
	    systime = chr+":"+cmin+":"+csec;
	    
		l11=new JLabel(systime);
		Date dt = new Date();
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    	String dateonly = df.format(dt);
    	sysdate=dateonly;
    	l12=new JLabel(sysdate);
    	ImageIcon keyhand=new ImageIcon("keyhand.jpg");
		ImageIcon ret=new ImageIcon("return.jpg");
		c.add(new JLabel(keyhand));c.add(new JLabel(ret));
		
		c.add(l1);c.add(cusid);
		c.add(l2);c.add(carmodl);
		c.add(l3);c.add(carno);
		c.add(l5);c.add(hrs);
		c.add(l6);c.add(l12);
		c.add(l7);c.add(l11);
		c.add(bback);c.add(bbook);
		setSize(475, 475);
		setLocation(465, 175);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent arg)
	{
		
		
		if(arg.getSource()==bbook)
		{
		SearchCus ob1=new SearchCus();
		String  mail=cusid.getText();
		int k=ob1.searchName(mail);
		SearchAvailableCars ob2=new SearchAvailableCars();
		String  carn=carno.getText();
		GetRate obj3=new GetRate();
		String hrate = obj3.GetRate(carn);
		SearchCar ob4=new SearchCar();
		int f=ob4.searchModl(carmodl.getText());
		int n=ob4.searchId(carno.getText());
		int v=ob2.searchName(carn);
		if(k!=-1&&v!=-1&&f!=-1&&n!=-1)//cus exists and car available
		{
			RegBookedCar r=new RegBookedCar(carno.getText(),hrate,hrs.getText(),sysdate,systime,cusid.getText());//hrate=hourlyrate
			new BookedCar(r);
			double hrrt = Double.parseDouble(hrate);
			double hr=Double.parseDouble(hrs.getText());
			double amt=hr*hrrt;
			RegCollection rr=new RegCollection(amt,carmodl.getText(),carn);//hrate=hourlyrate
			new BookedCar(rr);
			
			
				RegCar ra=new RegCar(carmodl.getText(),hrate,"N",carno.getText());
				new UpdataAvailableToUnvailable(ra,f);
			
			JOptionPane.showMessageDialog(this, "Booked successfully");
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Invalid data...please enter proper data ");
		}
		cusid.setText("");
		carmodl.setText("");
		carno.setText("");
		hrs.setText("");
		}
		if(arg.getSource()==bback)
		{
			new OperatorPanel("Operator's Panel");
			setVisible(false);
		}
	}
}