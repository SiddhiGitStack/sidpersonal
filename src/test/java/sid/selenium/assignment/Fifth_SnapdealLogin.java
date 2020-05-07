package sid.selenium.assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Fifth_SnapdealLogin extends BaseTest {
	
	@Test
	public void snapdealLogin() throws Exception
	{
		BasePO po= new BasePO(driver);
		
		driver.get("http://www.snapdeal.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement signin=driver.findElement(By.xpath("//div[@class='accountInner']//span[contains(text(),'Sign In')]"));
		
		Actions act=new Actions(driver);
		
		act.moveToElement(signin).clickAndHold().build().perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'login')]")).click();	
		
		driver.switchTo().frame("loginIframe");
		//driver.findElement(By.xpath("googleUserLogin")).sendKeys("siddhi.mohan@gmail.com");
		driver.findElement(By.id("googleUserLogin")).click();
	
		 Set<String> s1=driver.getWindowHandles();
		 Iterator<String> i1=s1.iterator();
		 String MainWindow=i1.next();
	            String ChildWindow=i1.next();
	            driver.switchTo().window(ChildWindow);	
	         
	            Thread.sleep(2000);
	            
	            System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).getText());
	            
                driver.findElement(By.xpath("//input[@type='email' and @id='identifierId']")).sendKeys("siddhi.mohan@gmail.com");
                driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
                
                System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Welcome')]")).getText());
             // Closing the Child Window.
                driver.close();		
                
	       
		// Switching to Parent window i.e Main Window.
         driver.switchTo().window(MainWindow);	
		
		
	}

}
