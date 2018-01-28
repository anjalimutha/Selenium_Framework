package testScripts;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;



public class CreateAccount {
	
	//WebDriver driver;
	@Test
	public void TC_01() {
		System.setProperty("webdriver.chrome.driver","//Users//anjalimutha//Downloads//chromedriver");
		String baseUrl = "https://www.amazon.com/";	
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		String cust = RandomStringUtils.randomAlphabetic(10);
		String email=RandomStringUtils.randomAlphanumeric(8) + "@gmail.com";
		
		driver.manage().window().maximize();
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
