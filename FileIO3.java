package p1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO3
{

ArrayList<RegCar> alist;
	
	public ArrayList<RegCar> readFile()
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Regi2.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   alist=(ArrayList<RegCar>)oin.readObject();
		}catch(Exception e)
		 {
			 alist=new ArrayList<RegCar>();
		 }
		
		 return alist;
	}
	public void writeFile(ArrayList<RegCar> list4)
	{
		try	
		{
		    FileOutputStream fout=new FileOutputStream("Regi2.dat");
		    ObjectOutputStream oout=new ObjectOutputStream(fout);
		    oout.writeObject(list4);
		}catch(Exception e){}
	}

}
