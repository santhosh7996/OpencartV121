package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Basepage {
	
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath= "//span[@class='caret']")
	WebElement MyAccount; 
	
	@FindBy(xpath= "//a[normalize-space() ='Register']")
	WebElement Register; 
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	public void ClickMyAccount()
	{
		MyAccount.click();
	}
	
	public void ClickRegister()
	{
		Register.click();
	}
	
	public void Login()
	{
		Login.click();
		
	}


}
