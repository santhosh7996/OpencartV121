package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;
import utilities.DataProviders;




public class TC003_LoginTestDDT extends BaseClass {
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="datadriven") //getting dataprovider from the different class 
	public void verify_DDTlogin(String email, String pswd, String exp)
	{
		try
		{
		logger.info("***** Starting TC_003_LoginTestDDT  *****");
		HomePage hp = new HomePage(driver);
		hp.ClickMyAccount();
		hp.Login();
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setemail(email);
		lp.setpswd(pswd);
		lp.clickloginbtn();
		
		/*Data is valid - login success-test pass -logout
		 * Data is valid - login unsuccess-test failed
		 * 
		 * Data is invalid - login success-test fail -logout
		 * Data is invalid - login unsuccess-test pass
		 * 
		 */

		
		
		
		
		MyAccountsPage myaccpg = new MyAccountsPage(driver);
		
		Boolean status =myaccpg.ismyaccountdisplayed();
		
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(status==true)
			{
				myaccpg.clicklogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(status==true)
			{
				myaccpg.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
			
		}

		
		}
		
		
		
		catch (Exception e)
		{
		
			Assert.fail();
		}
		
		
		
		logger.info("***** Finished TC_003_LoginTestDDT*****");
		
	}

	
	

}
