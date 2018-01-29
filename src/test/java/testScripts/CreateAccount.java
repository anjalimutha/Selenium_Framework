/*
 * This is a basic test case to create account on Amazon
 * */
package testScripts;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.xerces.util.URI.MalformedURIException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InvokeBrowser.InvokeBrowserSettings;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.TemporaryFilesystem;



public class CreateAccount {
	
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
	public void TC_01_CreateAccount() {
		
		String cust = RandomStringUtils.randomAlphabetic(10);
		String email=RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
		
		Actions action = new Actions(driver);
		WebElement element= driver.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[@class='nav-a'][contains(text(),'Start here.')]")).click();
		driver.findElement(By.xpath("//input[@id='ap_customer_name']")).sendKeys(cust);
		driver.findElement(By.xpath("//input[@id='ap_email'][@type='email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='ap_password'][@type='password']")).sendKeys("abcd123");
		driver.findElement(By.xpath("//input[@id='ap_password_check'][@type='password'][@name='passwordCheck']")).sendKeys("abcd123");
		driver.findElement(By.xpath("//input[@type='submit'][@id='continue']")).click();
		
		//driver.findElement(By.xpath("//div[@id='hud-customer-name']/div/a[contains(text(),'\"+cust+\"')]")).isDisplayed();
		
		
	}
	
}
