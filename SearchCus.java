package p1;

import java.util.ArrayList;;

public class SearchCus
{
 	private ArrayList<RegData> list2;
	private int f = -1,q=-1;
	
	public int searchName(String id)
	{
		try
		{
			FileIO obj = new FileIO();
			list2 = obj.readFile();
							
			for(int p=0; p<list2.size(); p++)
			{
				if(id.equals(list2.get(p).getMail()))
				{
					   f = p;
					   break;
				}	
			}
			 
			return(f);
					
		}catch(Exception e)
		 {
			
			return(-1);
			
		 }
			
	}
	public int searchPh(String ph)
	{
		try
		{
			FileIO obj = new FileIO();
			list2 = obj.readFile();
							
			for(int p=0; p<list2.size(); p++)
			{
				if(ph.equals(list2.get(p).getPh()))
				{
					   q = p;
					   break;
				}	
			}
			 
			return(q);
					
		}catch(Exception e)
		 {
			
			return(-1);
			
		 }
			
	}

}