package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AddCollInfo
{
    ArrayList<RegCollection> list4;
	
	public AddCollInfo(RegCollection rg1)
	{
		FileIO5 objfile = new FileIO5();
		
		list4 = objfile.readFile();
		
		list4.add(rg1);
		
		objfile.writeFile(list4);

	}
}