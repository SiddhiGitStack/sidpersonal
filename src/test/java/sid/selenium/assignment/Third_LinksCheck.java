package sid.selenium.assignment;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Third_LinksCheck extends BaseTest{
	
	
	@Test(priority=0)
	public void linksCheck()
	{
		BasePO po= new BasePO(driver);
		
		driver.get("https://flipkart.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		System.out.println("total number of links " + po.getTotalLinks());
		
		po.getLinkInfo();
		
	}

}
