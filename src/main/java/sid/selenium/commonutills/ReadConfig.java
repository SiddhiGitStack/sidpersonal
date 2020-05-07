package sid.selenium.commonutills;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties po=new Properties();
	
	public ReadConfig()
	{
		try
		{
			File src=new File("./src/main/resource/properties/config.properties");
			FileInputStream fis= new FileInputStream(src);
			po.load(fis);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
	}
	
	
	public String getBrowser()
	{
		return po.getProperty("browser");
	}

	public String getURL()
	{
		return po.getProperty("url");
	}

	public String getChromeDriver()
	{
		return po.getProperty("chromeDriver");
	}

	public String getFirefoxDriver()
	{
		return po.getProperty("firefoxDriver");
	}

	
}
