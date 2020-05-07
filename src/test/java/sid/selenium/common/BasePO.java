package sid.selenium.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePO {
	
	public WebDriver driver;
	
	
	public BasePO(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//span[contains(text(),'Create an account')]")
	public WebElement fbSignupHeading;
	
	@FindBy(name="firstname")
	public WebElement firstname;
	
	@FindBy(name="lastname")
	public WebElement lastname;
	
	@FindBy(name="reg_email__")
	public WebElement fbEmail;
	
	@FindBy(name="reg_passwd__")
	public WebElement fbPasswod;
	
	@FindBy(name="birthday_day")
	public WebElement fbBirthday;
	
	@FindBy(name="birthday_month")
	public WebElement fbBirthMonth;
	
	@FindBy(name="birthday_year")
	public WebElement fbBirthyear;
	
	@FindBy(name="websubmit")
	public WebElement fbSubmit;
	
	int index;
	public String getTitle()
	{
		String title=driver.getTitle().toString();
		return title;
		
	}


	public String getCurrentURL() {
		String currentURL=driver.getCurrentUrl();
		return currentURL;
	}
	
	public void navigateTo(String url)
	{
		driver.navigate().to(url);
	}


	public void fbSignup() throws InterruptedException {
		firstname.sendKeys(getRandomString(1,5));
		lastname.sendKeys(getRandomString(1,5));
		fbEmail.sendKeys("testuser@test.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='u_0_u']")).sendKeys("testuser@test.com");
		fbPasswod.sendKeys("letmein1");
		
		Select bDay=new Select(fbBirthday);
				bDay.selectByIndex(getRandomNum(1,31));
		Select bMon=new Select(fbBirthMonth);
				bMon.selectByIndex(getRandomNum(1,12));
		Select bYear=new Select(fbBirthyear);
				bYear.selectByIndex(getRandomNum(18,40));
				
		int genOption=getRandomNum(1,2);
		driver.findElement(By.xpath("//input[@type='radio' and @value='"+genOption+"']")).click();
		
		fbSubmit.click();
		
	}
	
	public String getRandomString(int min, int max)
	{
		String str="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		int len=str.length()-1;
		String randomStr = null;
		
		
		for (int i=0;i<len;i++)
		{
			index=(int)((Math.random()*max-min+1)+min) ;
			randomStr=randomStr+str.charAt(index);
		}
		return randomStr;
	}
	
	public int getRandomNum(int min, int max)
	{
		index=(int)((Math.random()*max-min+1)+min) ;
		return index;
	}


	public int getTotalLinks() {
		
	List<WebElement> ls=driver.findElements(By.tagName("a"));
	
	return ls.size();
	
		
	}


	public void getLinkInfo() {
		List<WebElement> ls=driver.findElements(By.tagName("a"));
		for (int i=0;i<ls.size();i++)
		{
		System.out.println("Links Url: "+ls.get(i).getAttribute("href"));
		System.out.println("Links Text: "+ls.get(i).getText());
		}
		
		
	}


	public void searchProduct() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Apple Watches");
		
		Select category=new Select(driver.findElement(By.xpath("//select[@id='gh-cat']")));
		category.selectByVisibleText("Consumer Electronics");

		
		driver.findElement(By.xpath("//input[@type='submit' and @id='gh-btn']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("srp-river-results")).getText());
		
	}


	public void getNthProductDetails() {
		int i=getRandomNum(1,15);
		System.out.println("getting details of "+ i +"product= "+driver.findElement(By.xpath("//div[@id='srp-river-results']//ul//li["+i+"]")).getText());
		
		
	}


	public void childwindow() throws Exception {
		 driver.switchTo().defaultContent();
		  String errorMsg="Unable to Open child window";
	        try
	        {
	            int n = driver.getWindowHandles().size();
	            System.out.println("Window size is :"+n);
	            if(n==2)
	            {
	            	String winHandleAfter = driver.getWindowHandle();

	            	 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).getText());
	 	            
	                 driver.findElement(By.xpath("//input[@type='email' and @id='identifierId']")).sendKeys("siddhi.mohan@gmail.com");
	                 driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
	                 
	                 System.out.println(driver.findElement(By.xpath("//span[contains(text(),'Welcome')]")).getText());
	            }
	            else
	            {
	                throw new Exception(errorMsg);
	            }
	        }
	        catch(Exception e)
	        {
	            throw new Exception("Unable to open  child Window");
	        }
		
	}
}
