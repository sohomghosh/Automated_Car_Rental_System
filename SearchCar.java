package p1;

import java.util.ArrayList;;
public class SearchCar 
{
 	private ArrayList<RegCar> list2;
	private int f = -1;
	
	public int searchNo(String no)
	{
		try
		{
			FileIO3 obj = new FileIO3();
			list2 = obj.readFile();
							
			for(int p=0; p<list2.size(); p++)
			{
				if(no.equals(list2.get(p).getId()))
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
	public int searchModl(String modl)
	{
			try
			{
				FileIO3 obj = new FileIO3();
				list2 = obj.readFile();
								
				for(int p=0; p<list2.size(); p++)
				{
					if(modl.equals(list2.get(p).getName()))
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
	public int searchId(String id)
	{
			try
			{
				FileIO3 obj = new FileIO3();
				list2 = obj.readFile();
								
				for(int p=0; p<list2.size(); p++)
				{
					if(id.equals(list2.get(p).getId()))
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
}
