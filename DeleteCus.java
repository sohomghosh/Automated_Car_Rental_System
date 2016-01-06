package p1;

import java.util.ArrayList;

public class DeleteCus
{
ArrayList<RegData> list1;
	
	public DeleteCus(int index)
	{
		FileIO obj = new FileIO();
		
		list1 = obj.readFile();
			
		list1.remove(index);
		
		obj.writeFile(list1);
	
	}	


}
