package testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InvokeBrowser.InvokeBrowserSettings;

import org.openqa.selenium.io.TemporaryFilesystem;



public class Orders {
	
	public WebDriver driver;
	
	@BeforeMethod
	@Parameters({"URL"})
	public void browserSetup(String URL){
		System.setProperty("webdriver.chrome.driver","//Users//anjalimutha//Downloads//chromedriver");
		InvokeBrowserSettings invokebrwsr = new InvokeBrowserSettings();
		driver = invokebrwsr.invokeBrowser("Chrome", URL);
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
	public void TC_02_Orders() throws Exception{
		driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Orders')]")).click();
		
		
	}
}