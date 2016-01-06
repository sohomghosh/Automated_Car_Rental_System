package p1;
import java.io.Serializable;
public class RegCar implements Serializable
{
	private String name;
	public String getName()
	{
		return name;
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAvail()
	{
		return avail;
	}
	public void setAvail(String avail)
	{
		this.avail = avail;
	}
	public String getRate()
	{
		return rate;
	}
	public void setRate(String rate) 
	{
		this.rate = rate;
	}
	private String avail;
	private String rate;
	private String id;
	public RegCar(String name,String rate, String avail,String id)//id=car noS
	{
		super();
		this.name=name;
		this.rate=rate;
		this.avail=avail;
		this.id=id;
	}
}