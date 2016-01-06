package p1;

import java.io.Serializable;

public class RegData implements Serializable 
{
	private String nm;
	private String mail;
	private String pass;
	private String add;
	private String ph;
	public RegData(String nm, String mail, String pass, String add, String ph )
	{
		super();
		this.nm = nm;
		this.mail = mail;
		this.pass = pass;
		this.add = add;
		this.ph = ph;	
	}
	public String getNm()
	{
		return nm;
	}
	public void setNm(String nm) 
	{
		this.nm = nm;
	}
	public String getMail() 
	{
		return mail;
	}
	public void setMail(String mail) 
	{
		this.mail = mail;
	}
	public String getPass() 
	{
		return pass;
	}
	public void setPass(String pass) 
	{
		this.pass = pass;
	}
	public String getAdd() 
	{
			return add;
	}
	public void setAdd(String add) 
	{
		this.add = add;
	}
	public String getPh() 
	{
		return ph;
	}
	public void setPh(String ph) 
	{
		this.ph = ph;
	}
}
