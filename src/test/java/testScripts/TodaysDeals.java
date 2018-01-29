/*
 * This is a basic test case to check today's deals and add it to the cart
 * 
 * */


package testScripts;
import java.util.concurrent.TimeUnit;
import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InvokeBrowser.InvokeBrowserSettings;

import org.openqa.selenium.io.TemporaryFilesystem;

public class TodaysDeals {
public WebDriver driver;
	
	@BeforeMethod
	@Parameters({"URL"})
	public void browserSetup(String URL) throws MalformedURIException{
		System.setProperty("webdriver.chrome.driver","//Users//anjalimutha//Downloads//chromedriver");
		InvokeBrowserSettings invokebrwsr = new InvokeBrowserSettings();
		invokebrwsr.invokeBrowser("Chrome", URL);
	}
	
	@AfterMethod
	public void cleanUp() {
		if(driver!=null) {
			TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		}
	}

	
	@Test
	public void TC_02() {
		
		
		driver.findElement(By.xpath("//a[@tabindex=49][contains(text(),'Deals')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Amazon Devices')]")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@class='a-button-text a-text-center'][1][contains(text(),'See details')]")).click();
		driver.findElement(By.xpath("//img[@class='imgSwatch'][@alt='White']")).click();
		driver.findElement(By.xpath("//span[@class='a-size-base'][contains(text(),'Fire TV Stick')]")).click();
		driver.findElement(By.xpath("//input[@name='freeTrialBBOP']")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@frameborder='0']")));
		driver.findElement(By.xpath("//button[@data-action='a-popover-close'][@aria-label='Close']")).click();
		
}
}
