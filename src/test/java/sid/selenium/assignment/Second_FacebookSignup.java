package sid.selenium.assignment;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import junit.framework.Assert;
import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Second_FacebookSignup extends BaseTest {
	
	@Test
	public void signup() throws InterruptedException
	{
		BasePO po=new BasePO(driver);
		
		po.navigateTo("http://www.fb.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		String actualURL=po.getCurrentURL();
		String expectedURL="https://www.facebook.com/";
		System.out.println(actualURL);
		Assert.assertEquals(expectedURL, actualURL);	
		System.out.println(" Check1 passed");
		String expected="Create an account";
		Assert.assertEquals("Signup heading matched",expected, po.fbSignupHeading.getText());
		
		po.fbSignup();
		
		
		
		
	}

}
