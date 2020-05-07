package sid.selenium.assignment;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Seventh_GmailCompose extends BaseTest {

	@Test
	public void composeGmail() throws InterruptedException
	{
		BasePO po=new BasePO(driver);
		
		//launch url
		driver.manage().deleteAllCookies();
		driver.get("https://www.gmail.com");
		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		
		
		//driver.findElement(By.xpath("//ul[@class='h-c-header__cta-list header__nav--ltr']//a[contains(@class,'h-c-header__nav-li-link')][contains(text(),'Sign in')]")).click();
		
	//	Set<String> s1 = driver.getWindowHandles();
		//Iterator<String> i=s1.iterator();
		
	//	String main=i.next();
		//String tab=i.next();
	//	driver.switchTo().window(tab);
		
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("siddhirao07@gmail.com");
		driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Sid@12345");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']")).click();
		
		System.out.println(driver.findElement(By.xpath("//div[@id=':pq']")).getText());
		
		
		
		
	}
	
	
}
