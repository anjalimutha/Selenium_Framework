package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateAccountPage {
	
	WebDriver driver;
	
	public CreateAccountPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	
	
	@FindBy(how=How.XPATH,using = "//span[@class='nav-line-2'][contains(text(),'Account & Lists')]")
	WebElement AccountandList;
	
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Start here.')]")
	WebElement StartHere;
	
	@FindBy(how=How.XPATH,using="//input[@id='ap_customer_name']")
	WebElement Name;
	
	@FindBy(how=How.XPATH,using="//input[@id='ap_email'][@type='email']")
	WebElement Email;
	
	@FindBy(how=How.XPATH,using="//input[@id='ap_password'][@type='password']")
	WebElement passwrd;
	
	@FindBy(how=How.XPATH,using="//input[@id='ap_password_check'][@type='password'][@name='passwordCheck']")
	WebElement confirmpasswrd;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit'][@id='continue']")
	WebElement Continue;
	
	
	public void CreateAcc(String uname,String email,String pass){
		Actions action = new Actions(driver);
		action.moveToElement(AccountandList).build().perform();

		StartHere.click();
		Name.sendKeys(uname);
		Email.sendKeys(email);
		passwrd.sendKeys(pass);
		confirmpasswrd.sendKeys(pass);
		Continue.click();	
	}
}
