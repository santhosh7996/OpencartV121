package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void verify_login()
	{
		try
		{
		logger.info("***** Starting TC_002_LoginTest *****");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.Login();
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setemail(p.getProperty("email"));
		lp.setpswd(p.getProperty("password"));
		lp.clickloginbtn();
		
		MyAccountsPage myaccpg = new MyAccountsPage(driver);
		
		Boolean status =myaccpg.ismyaccountdisplayed();
		
		Assert.assertTrue(status);
		
		}
		
		
		
		catch (Exception e)
		{
		
			Assert.fail();
			
		}
		
		
		
		logger.info("***** Finished TC_002_LoginTest *****");
		
	}

}
