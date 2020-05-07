package sid.selenium.assignment;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Fourth_eBayProductSearch extends BaseTest {
	
	@Test
	public void ebaySearch() throws InterruptedException
	{
		BasePO po= new BasePO(driver);
		
		driver.get("https://in.ebay.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		po.searchProduct();
		
		po.getNthProductDetails();
		
		
		
		
	}

}
