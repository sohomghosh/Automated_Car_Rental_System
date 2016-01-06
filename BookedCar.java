package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class BookedCar
{
    ArrayList<RegBookedCar> list4;
    ArrayList<RegCollection> list5;
	
	public BookedCar(RegBookedCar rg1)
	{
		FileIO4 objfile = new FileIO4();
		
		list4 = objfile.readFile();
		
		list4.add(rg1);
		
		objfile.writeFile(list4);

	}
	public BookedCar(RegCollection rg2)
	{
		FileIO5 objfile = new FileIO5();
		
		list5 = objfile.readFile();
		
		list5.add(rg2);
		
		objfile.writeFile(list5);

	}

}