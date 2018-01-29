package InvokeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InvokeBrowserSettings {
	public WebDriver driver;

	
	public WebDriver invokeBrowser(String browser_name, String URL) {
		if(browser_name.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
		}
		
		else if(browser_name.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
		}
		
		else if(browser_name.equalsIgnoreCase("IE") || browser_name.equalsIgnoreCase("Internet Explorer"))
		{
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		return driver;
	}

}
