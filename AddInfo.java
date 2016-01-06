package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AddInfo
{
    ArrayList<RegData> list4;
	
	public AddInfo(RegData rg1)
	{
		FileIO objfile = new FileIO();
		
		list4 = objfile.readFile();
		
		list4.add(rg1);
		
		objfile.writeFile(list4);

	}
}