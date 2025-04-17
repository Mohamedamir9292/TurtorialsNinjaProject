package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePage;
import pageObjectClasses.LoginClass;
import pageObjectClasses.MyAccountClass;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups = {"Sanity", "Master"})
	public void verifyLogin() {
		
		
		logger.info("****Starting login test****");
		try
		{
		// click myAccount in the homepage and then click login
		
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		// pass valid email and password 
		LoginClass login = new LoginClass(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("password"));
		login.clickLogin();
		
		// verifying if login was successful 
		MyAccountClass myAccount = new MyAccountClass(driver);
		boolean targetPage = myAccount.doesMyAccountExist();
		//Assert.assertEquals(targetPage, true, "login failed"); // this will work
		Assert.assertTrue(targetPage);							 // this will work too
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("****Finished login test****");
		
	}

	
}
