package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

	Properties props=null;
	FileInputStream inputstream=new FileInputStream(System.getProperty("user.dir")+"//config.properties");
	
	public ReadPropertyFile() throws IOException {
		
		props=new Properties();
		props.load(inputstream);
		
	}
	
	public String getURL()
	{
		return props.getProperty("url");
	}
	
	public String getfirstName()
	{
		return props.getProperty("firstName");
	}
	
	public String getlastName()
	{
		return props.getProperty("lastName");
	}
	
	public String getpassword()
	{
		return props.getProperty("password");
	}
	
	public String getexistingUser()
	{
		return props.getProperty("existingUser");
	}
	public String getday()
	{
		return props.getProperty("day");
	}
	public String getmonth()
	{
		return props.getProperty("month");
	}
	public String getyear()
	{
		return props.getProperty("year");
	}
	public String getaddress()
	{
		return props.getProperty("address");
	}
	public String getcity()
	{
		return props.getProperty("city");
	}
	public String getstate()
	{
		return props.getProperty("state");
	}
	public String getpin()
	{
		return props.getProperty("pin");
	}
	
	public String getcountry()
	{
		return props.getProperty("country");
	}
	
	public String getphoneNo()
	{
		return props.getProperty("phoneNo");
	}
	
	public String getAlias()
	{
		return props.getProperty("alias");
	}
	
}
