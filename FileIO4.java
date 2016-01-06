package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO4 
{
	ArrayList<RegBookedCar> alist;
	
	public ArrayList<RegBookedCar> readFile()
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Regi8.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   alist=(ArrayList<RegBookedCar>)oin.readObject();
		}catch(Exception e)
		 {
			 alist=new ArrayList<RegBookedCar>();//when Regi.dat is not present.. den creating a blank arrayList .. and passing it
		 }
		
		 return alist;
	}
	
	public void writeFile(ArrayList<RegBookedCar> alist1)
	{
		try	
		{
		    FileOutputStream fout=new FileOutputStream("Regi8.dat");
		    ObjectOutputStream oout=new ObjectOutputStream(fout);
		    oout.writeObject(alist1);
		}catch(Exception e){}
	}
}