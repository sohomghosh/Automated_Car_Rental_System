package p1;

import java.util.ArrayList;;

public class SearchAvailableCars
{
 	private ArrayList<RegCar> list8;
	private int f = -1;
	
	public int searchName(String av)
	{
		try
		{
			FileIO3 obj = new FileIO3();
			list8 = obj.readFile();
							
			for(int p=0; p<list8.size(); p++)
			{
				if(av.equals(list8.get(p).getId()))
				{
					if("Y".equals(list8.get(p).getAvail()))
					{
					   f = p;
					   break;
					}
				}	
			}
			 
			return(f);
					
		}catch(Exception e)
		 {
			
			return(-1);
			
		 }
			
	}
}