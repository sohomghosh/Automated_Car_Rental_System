package p1;

import java.util.ArrayList;;

public class TotalMoneyCalculate
{
 	private ArrayList<RegCollection> list2;
	double money=0.0;
	public double TotalMoneyCalculate()
	{
		try
		{
			FileIO5 obj = new FileIO5();
			list2 = obj.readFile();				
			for(int p=0; p<list2.size(); p++)
			{
					money=money+list2.get(p).getAmt();  		
			}
			 
			return(money);
		}catch(Exception e)
		 {
			return(-1);
		 }		
	}
}