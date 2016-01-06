package p1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class ShowAvailableCars extends JFrame 
{
		public ShowAvailableCars()
		{
			super("Display Available Cars");
			String heading[]={"Model","Hourly Rate","Car Id"};
			String data[][]=new String[100][3];
			ArrayList<RegCar> list;
			try
			{
				FileIO3 obj = new FileIO3();
				list = obj.readFile();
			int r=0;
			for(RegCar re : list)
			{
				
					if(re.getAvail().equalsIgnoreCase("Y"))
					{
						data[r][0]=re.getName();
						data[r][1]=re.getRate();
						data[r][2]=re.getId();
					}
					r++;
				}
				
				Container con=getContentPane();
				con.setLayout(new BorderLayout());
				
				JTable datatable=new JTable(data, heading);
				JScrollPane jsp=new JScrollPane(datatable);
				
				con.add(new JLabel("All Registration Details"),BorderLayout.NORTH);
				con.add(jsp,BorderLayout.CENTER);
				
				setSize(475, 475);
				setLocation(865, 175);
				setVisible(true);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
