package testScripts;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import InvokeBrowser.InvokeBrowserSettings;
import Pages.CreateAccountPage;

public class VerifyCreateAccount {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"URL"})
	public void browserSetup(String URL){
		System.setProperty("webdriver.chrome.driver","//Users//anjalimutha//Downloads//chromedriver");
		InvokeBrowserSettings invokebrwsr = new InvokeBrowserSettings();
		driver = invokebrwsr.invokeBrowser("Chrome", URL);
	}
	
	@AfterMethod
	public void cleanUp(){
		if(driver!=null) {
			TemporaryFilesystem.getDefaultTmpFS().deleteTemporaryFiles();
			driver.manage().deleteAllCookies();
			driver.close();
			driver.quit();
		}
	}
	
	@Test
	public void checkCreateAccount() {
		
		CreateAccountPage CreateAcc=PageFactory.initElements(driver, CreateAccountPage.class);
		String cust = RandomStringUtils.randomAlphabetic(10);
		String email=RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
		
		CreateAcc.CreateAcc(cust,email,"abcd123");
		
		
		
	}

}
