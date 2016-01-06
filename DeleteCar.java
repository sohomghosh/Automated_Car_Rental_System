package p1;

import java.util.ArrayList;

public class DeleteCar
{
ArrayList<RegCar> list1;
	
	public DeleteCar(int index)
	{
		FileIO3 obj = new FileIO3();
		
		list1 = obj.readFile();
			
		list1.remove(index);
		
		obj.writeFile(list1);
	
	}	


}
