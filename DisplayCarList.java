package p1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class DisplayCarList extends JFrame 
{
	
	public DisplayCarList()
	{
		super("Display All");
		String heading[]={"Model","Number","Rate per hour","Availability"};
		
		String data[][]=new String[100][4];
		ArrayList<RegCar> list;//=new ArrayList<RegData>();
		try
		{
			FileIO3 obj = new FileIO3();
			list = obj.readFile();
			
			int r=0;
			for(RegCar re : list)
			{
				data[r][0]=re.getName();
				data[r][1]=re.getId();
				data[r][2]=re.getRate();
				data[r][3]=re.getAvail();
				r++;
			}
			
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("All Car Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(475, 475);
			setLocation(865, 175);
			setVisible(true);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		new DisplayCarList();
	}
}
