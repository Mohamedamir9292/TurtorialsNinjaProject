package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.AccountRegistrationPage;
import pageObjectClasses.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
		
	@Test(groups = {"Regression", "Master"})
	public void verifyAccountRegistration() {
		
		logger.info("****Starting TC001_AccountRegistrationTest*****");
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("****Click MyAccount****");
		hp.clickRegister();
		logger.info("****Click Register****");
		
		String password = randomPassword();
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		logger.info("****Passing Customer info****");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com"); // randomly generated email
		regpage.setTelephone(randomNumber());
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("****Validating expected msg****");
		String conMsg = regpage.getConfirmationMsg();
		Assert.assertEquals(conMsg, "Your Account Has Been Created!");
		logger.info("****Finished Testing****");
	}
	
	

}
