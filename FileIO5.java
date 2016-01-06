package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIO5 
{
	ArrayList<RegCollection> alist;
	
	public ArrayList<RegCollection> readFile()
	{
		try
		{
		   FileInputStream fin=new FileInputStream("Regi9.dat");
		   ObjectInputStream oin=new ObjectInputStream(fin);
		   alist=(ArrayList<RegCollection>)oin.readObject();
		}catch(Exception e)
		 {
			 alist=new ArrayList<RegCollection>();//when Regi.dat is not present.. den creating a blank arrayList .. and passing it
		 }
		
		 return alist;
	}
	
	public void writeFile(ArrayList<RegCollection> alist1)
	{
		try	
		{
		    FileOutputStream fout=new FileOutputStream("Regi9.dat");
		    ObjectOutputStream oout=new ObjectOutputStream(fout);
		    oout.writeObject(alist1);
		}catch(Exception e){}
	}
}