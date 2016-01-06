package p1;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.*;
import java.util.*;

public class DisplayFromFile extends JFrame {
	
	public DisplayFromFile()
	{
		super("Display All Information");
		String heading[]={ "Name", "Customer Mail id", "Destination","Address","Ph no." };
		String data[][] = new String[100][5];
		ArrayList<RegData> list;//=new ArrayList<RegData>();
		try
		{
			FileIO obj = new FileIO();
			list = obj.readFile();
			int r = 0;
			for (RegData re : list) {
				data[r][0] = re.getNm();
				data[r][1] = re.getMail();
				data[r][2] = re.getPass();
				data[r][3] = re.getAdd();
				data[r][4] = re.getPh();
				

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
	public static void main(String args[])
	{
		new DisplayFromFile();
	}
}