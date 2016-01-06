package p1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SearchCusDisp extends JFrame 
{
	public SearchCusDisp(int index)
	{
		super("Search Window");
		String heading[]={"Name", "Customer Mail id", "password","Address","Ph no."};
		String data[][]=new String[100][5];
		ArrayList<RegData> list6;
		try
		{
			FileIO obj = new FileIO();
			list6 = obj.readFile();
			RegData re = list6.get(index);
			
			data[0][0]=re.getNm();
			data[0][1]=re.getMail();
			data[0][2]=re.getPass();
			data[0][3]=re.getAdd();
			data[0][4]=re.getPh();
					
			Container con=getContentPane();
			con.setLayout(new BorderLayout());
			
			JTable datatable=new JTable(data, heading);
			JScrollPane jsp=new JScrollPane(datatable);
			
			con.add(new JLabel("Information Details"),BorderLayout.NORTH);
			con.add(jsp,BorderLayout.CENTER);
			
			setSize(650, 300);
			
			setLocation(200, 200);
			setVisible(true);
				
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	
}
