package p1;

import java.io.Serializable;

public class RegBookedCar implements Serializable
{
	private String carname;
	private String hourlyrate;
	private String noofhrs;
	private String sysdat;
	private String systym;
	private String cusid;
	
	public RegBookedCar(String carname,String hourlyrate, String noofhrs, String sysdat, String systym, String cusid ) 
	{
		super();
		this.carname = carname;
		this.hourlyrate = hourlyrate;
		this.noofhrs = noofhrs;
		this.sysdat = sysdat;
		this.systym = systym;
		this.cusid=cusid;
	}
	public String getCusid()
	{
		return cusid;
	}
	public void setCusid(String cusid) 
	{
		this.cusid = cusid;
	}
	public String getCarname() 
	{
		return carname;
	}
	public void setCarname(String carname) 
	{
		this.carname = carname;
	}
	public String getHourlyrate()
	{
		return hourlyrate;
	}
	public void setHourlyrate(String hourlyrate) {
		this.hourlyrate = hourlyrate;
	}
	public String getNoofhrs()
	{
		return noofhrs;
	}
	public void setNoofhrs(String noofhrs)
	{
		this.noofhrs = noofhrs;
	}
	public String getSysdat()
	{
		return sysdat;
	}
	public void setSysdat(String sysdat)
	{
		this.sysdat = sysdat;
	}
	public String getSystym() 
	{
		return systym;
	}
	public void setSystym(String systym) 
	{
		this.systym = systym;
	}	
}
