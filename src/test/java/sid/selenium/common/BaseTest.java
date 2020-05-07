package sid.selenium.common;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import sid.selenium.commonutills.ReadConfig;

public class BaseTest {
	
	ReadConfig obj=new ReadConfig();
	
	public static WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	public String url=obj.getURL();
	
	
	@BeforeClass
	public static void  startTest()
	{
		report= new ExtentReports(System.getProperty("user.dir")+"/test-output/html/ExtentReportCheck.html");
		test=report.startTest("extent report");
		
	}
	
	@AfterClass
	public static void endTest()
	{
		report.endTest(test);
		report.flush();
	}
	
	public static String captureSS(WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File dest=new File("src/../BImages/"+System.currentTimeMillis()+".png");
		String path=dest.getAbsolutePath();
		FileUtils.copyFile(src, dest);
		
		return path;
		
	}
	@BeforeMethod
	public void setup()
	{
		if(obj.getBrowser().equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", obj.getChromeDriver());
			driver=new ChromeDriver();
			
		}
		if(obj.getBrowser().equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", obj.getFirefoxDriver());
			driver=new FirefoxDriver();
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

	
	
}
