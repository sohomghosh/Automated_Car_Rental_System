package p1;

import java.util.ArrayList;

public class UpdataAvailableToUnvailable
{
	ArrayList<RegCar> list1;
	
	public UpdataAvailableToUnvailable(RegCar rg,int index)
	{
		FileIO3 obj = new FileIO3();
		
		list1 = obj.readFile();
		
	    list1.set(index, rg);
	    
	    obj.writeFile(list1);
		 
	}
}