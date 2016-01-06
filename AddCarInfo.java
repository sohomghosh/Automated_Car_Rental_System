package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class AddCarInfo
{

	 ArrayList<RegCar> list4;
		
		public AddCarInfo(RegCar rg1)
		{
			FileIO3 objfile = new FileIO3();
			
			list4 = objfile.readFile();
			
			list4.add(rg1);
			
			objfile.writeFile(list4);

		}
	}


