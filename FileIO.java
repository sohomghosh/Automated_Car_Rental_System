package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO 
{
	ArrayList<RegData> alist;
	
	public ArrayList<RegData> readFile()
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Regi.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   alist=(ArrayList<RegData>)oin.readObject();
		}catch(Exception e)
		 {
			 alist=new ArrayList<RegData>();//when Regi.dat is not present.. den creating a blank arrayList .. and passing it
		 }
		
		 return alist;
	}
	
	public void writeFile(ArrayList<RegData> alist1)
	{
		try	
		{
		    FileOutputStream fout=new FileOutputStream("Regi.dat");
		    ObjectOutputStream oout=new ObjectOutputStream(fout);
		    oout.writeObject(alist1);
		}catch(Exception e){}
	}
}