package sid.selenium.assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import sid.selenium.common.BasePO;
import sid.selenium.common.BaseTest;

public class Sixth_DragDrop extends BaseTest {
	
	@Test
	public void dragDrop() throws InterruptedException, IOException
	{
		BasePO po=new BasePO(driver);
		
		//launch url
		driver.get("http://jqueryui.com/droppable/");
		// pageload timeout
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//maximize window
		driver.manage().window().maximize();
		WebElement webFrame = driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(webFrame);
		
		WebElement item=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act=new Actions(driver);
		
		// before drop
		test.log(LogStatus.PASS, "Text before drop ");
		
		System.out.println("Text before drop "+target.getText());
		String colourBeforeDnD = target.getCssValue("color");
		
		act.moveToElement(item).clickAndHold().dragAndDrop(item, target).release().build().perform();
		
		// after drop
		System.out.println("Text after drop "+target.getText());
		
		String colorAfterDnD = target.getCssValue("color");
		
		System.out.println("Color before Drag and Drop : "+ colourBeforeDnD);
		
		System.out.println("Color after Drag and Drop : "+ colorAfterDnD);
				
		Thread.sleep(3000);
		test.log(LogStatus.PASS, test.addScreenCapture(captureSS(driver))+"Test Paased");
	}

}
