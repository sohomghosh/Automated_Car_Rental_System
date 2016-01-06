package p1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class DisplayCollection extends JFrame {
	
	public DisplayCollection()
	{
		super("Displaying collection");
		String heading[]={"car model","car id", "Amount"};
		String data[][]=new String[100][3];
		ArrayList<RegCollection> list;//=new ArrayList<RegData>();
		try
		{
			FileIO5 obj = new FileIO5();
			list = obj.readFile();
			
			int r=0;
			for(RegCollection re : list)
			{
				data[r][0]=re.getModel();
				data[r][1]=re.getId();
				data[r][2]=re.getAmt()+"";
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(650, 175);
			
			setLocation(365, 0);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}