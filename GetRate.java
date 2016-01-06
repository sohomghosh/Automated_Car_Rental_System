package p1;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class GetRate extends JFrame 
{
	
	public String GetRate(String id)
	{String hrate = null;
		ArrayList<RegCar> list;//=new ArrayList<RegData>();
		FileIO3 obj = new FileIO3();
		list = obj.readFile();	
		int r=0;
		for(RegCar re : list)
		{
			if(id.equalsIgnoreCase(re.getId()))
			{
				hrate=re.getRate();
				break;
			}				
		}
		return hrate;
	}
}
