package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration()
	{
		try
		{
		logger.info("***** Starting TC001_AccountRegistrationTest *****");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.ClickRegister();
		logger.info("Clicked on register Link.. ");
		
		AccountRegistrationPage arp= new AccountRegistrationPage(driver);
		
		
		logger.info("Providing customer details.. ");
		String randompswd = randomAlphaNumeric();
		arp.setFirstName(randomString().toUpperCase());
		arp.setLastName(randomString().toUpperCase());
		arp.setEmail(randomString()+"@gmail.com");
		arp.setTel(randomeNumber());
		
		arp.setPswd(randompswd);
		arp.setConfirmPswd(randompswd);
		
		arp.setPrivacyPolicy();
		arp.clickContinue();
		
		logger.info("validating expected message.. ");
		String confmsg = arp.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.error("Test Failed.. ");
			logger.debug("Debug logs ");
			Assert.assertTrue(false);
		}
		
		}
		
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
		
		logger.info("***** Finished TC001_AccountRegistrationTest *****  ");
		
				
	}
	
	
	

}
