package p1;

import java.util.ArrayList;

public class UpdateHourlyRate 
{
	ArrayList<RegCar> list1;
	ArrayList<RegBookedCar> list2;
	public UpdateHourlyRate(RegCar rg,int index)
	{
		FileIO3 obj = new FileIO3();
		
		list1 = obj.readFile();
		
	    list1.set(index, rg);
	    
	    obj.writeFile(list1);	 
	}
}