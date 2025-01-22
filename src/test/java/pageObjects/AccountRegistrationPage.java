package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends Basepage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		}
	
	@FindBy(xpath ="//input[@id='input-firstname']")
	WebElement txtFstname;
	
	@FindBy(xpath ="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath ="//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath ="//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath ="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath ="//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath ="//input[@name='agree']")
	WebElement chkdpolicy;
	
	@FindBy(xpath ="//input[@Value='Continue']")
	WebElement btncontinue;
	
	@FindBy(xpath ="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}

	public void setTel(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPswd(String pswd)
	{
		txtPassword.sendKeys(pswd);
	}
	
	public void setConfirmPswd(String cpswd)
	{
		txtConfirmPassword.sendKeys(cpswd);
	}
	
	public void setPrivacyPolicy()
	{
		chkdpolicy.click();
	}
	
	
	public void clickContinue()
	{
		btncontinue.click();
	}
	
	
	public String getConfirmationMsg()
	{
		try
		{
		return (msgConfirmation.getText());
		}
		
		catch (Exception e)
		{
			return (e.getMessage());
		}
	}

	
	

}
