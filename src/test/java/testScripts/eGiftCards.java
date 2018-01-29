package testScripts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InvokeBrowser.InvokeBrowserSettings;

import org.openqa.selenium.io.TemporaryFilesystem;



public class eGiftCards {
	
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
	public void TC_02_eGiftCards() throws Exception{
		
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Gift Cards')]")).click();
		driver.findElement(By.xpath("//img[@alt='eGift']")).click();
		driver.findElement(By.xpath("//button[@id='gc-customization-type-button-Animated']")).click();
		driver.findElement(By.xpath("//img[@id='gc-mini-picker-design-swatch-image-2']")).click();
		driver.findElement(By.xpath("//input[@id='gc-order-form-custom-amount']")).click();
		driver.findElement(By.xpath("//input[@id='gc-order-form-custom-amount']")).sendKeys("100");
		driver.findElement(By.xpath("//button[@id='gc-delivery-mechanism-button-MobileSMS-announce']")).click();
		driver.findElement(By.xpath("//input[@id='gc-order-form-recipients-sms-input']")).sendKeys("7157777777");
		driver.findElement(By.xpath("//input[@id='gc-order-form-sms-senderName']")).sendKeys("Jack");
		driver.findElement(By.xpath("//input[@id='gc-buy-box-atc']")).click();
		driver.findElement(By.xpath("//a[@id='hlb-ptc-btn-native']")).click();
		
		
	}
}