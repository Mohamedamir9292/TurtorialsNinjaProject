package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePage;
import pageObjectClasses.LoginClass;
import pageObjectClasses.MyAccountClass;
import testBase.BaseClass;
import utilities.Data_Providers;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider = "LoginData", dataProviderClass = Data_Providers.class, groups = "DataDriven")
	public void verifyLoginDDT(String email, String password, String expected) {
		
		logger.info("****Starting login test****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// pass valid email and password 
		LoginClass login = new LoginClass(driver);
		login.setEmail(email);
		login.setPassword(password);
		login.clickLogin();
		
		// verifying if login was successful 
		MyAccountClass myAccount = new MyAccountClass(driver);
		boolean targetPage = myAccount.doesMyAccountExist();
		
		/* if data is valid and login was successful then test passed
		 * 						login was unsuccessful then test failed
		 * if data is invalid and login was unsuccessful then test passed
		 * 						login was successful then test failed
		 */			
		
		if(expected.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				Assert.assertTrue(true);
				myAccount.clickLogOut();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(expected.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				myAccount.clickLogOut();
				Assert.assertTrue(false);
			}
		}
		else {
			Assert.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****finished login test****");
		
		
		
		
	}
}
