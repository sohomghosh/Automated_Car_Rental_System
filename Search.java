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
public class Search extends JFrame implements ActionListener
{
	private JLabel l1,l2,l3,l4,l5,l6,l11,l12;
	private JTextField hrs;
	private JButton bsearch;
	private String systime;
	private String sysdate;
	private JComboBox carname;
	public Search(String title)
	{
		super(title);
		Container c=getContentPane();
		c.setLayout(new GridLayout(6,2));
		String crnm[]={"Santro WB_12K_1324", "Alto WB_13L_1824", "NanoWB_17K_1320", "Zen WB_12J_1329", "Bolero WB_12N_1378", "Toyota WB_12N_1398", "Swift WB_18G_1524","Mercedes Benz WB_19K_1624", "Audi WB_12Q_1367","Innova WB_12K_1367","Maruti 800 WB_12D_1354"};
		carname=new JComboBox(crnm);//tcid=new JTextField(20);
		hrs=new JTextField(5);
		bsearch=new JButton("Click here to search");
		bsearch.addActionListener(this);
		
		Font f=new Font("Chiller",Font.BOLD,20);
		l1=new JLabel("SEARCH YOUR CAR HERE ");
		l1.setFont(f);
		l1.setForeground(Color.RED);
		
		Font f1=new Font("comic sans ms",Font.BOLD,14);
		l2=new JLabel("SELECT CAR ");
		l2.setFont(f1);
		l2.setForeground(Color.RED);
		
		l3=new JLabel("For how many hours you want to hire it?? ");
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
		c.add(l2);c.add(carname);
		c.add(l3);c.add(hrs);
		c.add(l4);c.add(l11);
		c.add(l5);c.add(l12);
		c.add(l6);c.add(bsearch);
		
		setSize(350, 425);
		setLocation(400,200);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

}