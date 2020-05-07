package sid.selenium.assignment;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class First_BrowserCommands extends BaseTest {
	
	
	@Test
	public void browserCommands() throws InterruptedException
	{
		BasePO po=new BasePO(driver);
		
		//launch url
		driver.get(url);
		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		Thread.sleep(4000);
		//verify browser title
		String title=po.getTitle();
		System.out.println(title);
		String expectedTitle="QA Automation Tools Trainings and Tutorials | QA Tech Hub";
		Assert.assertEquals(title, expectedTitle);
		System.out.println("First check case passed");
		
		driver.navigate().to("https://www.facebook.com");
		//back
		driver.navigate().back();
		
		System.out.println("Current URL "+po.getCurrentURL());
		
		//forward
		driver.navigate().forward();
		
		//reload
		driver.navigate().refresh();
		
			
	}

}
