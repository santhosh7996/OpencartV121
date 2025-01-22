package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	
	@FindBy(xpath= "//input[@id='input-email']")
	WebElement txtemailadd;
	
	@FindBy(xpath= "//input[@id='input-password']")
	WebElement txtpswd;
	
	
	
	@FindBy(xpath= "//input[@value='Login']")
	WebElement Login_btn;
	
	public void setemail(String email)
	{
		txtemailadd.sendKeys(email);
	}
	
	
	public void setpswd(String pswd)
	{
		txtpswd.sendKeys(pswd);
	}
	
	public void clickloginbtn()
	{
		Login_btn.click();
	}


}
