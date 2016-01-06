package p1;

import java.io.Serializable;

public class RegCollection implements Serializable
{
	private double amt;private String model; private String id;

	public RegCollection(double amt, String model, String id)
	{
		super();
		this.amt=amt;
		this.id=id;
		this.model=model;
	}
	public double getAmt() 
	{
		return amt;
	}
	public void setAmt(double amt)
	{
		this.amt = amt;
	}
	public String getModel()
	{
		return model;
	}
	public void setModel(String model)
	{
		this.model = model;
	}
	public String getId() 
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}	
}