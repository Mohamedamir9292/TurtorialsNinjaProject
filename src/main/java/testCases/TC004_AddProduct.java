package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.AddProduct;
import pageObjectClasses.HomePage;
import pageObjectClasses.LoginClass;
import testBase.BaseClass;

public class TC004_AddProduct extends BaseClass{
	
	@Test(groups = {"Sanity", "Master"})
	public void addProduct() throws InterruptedException {
	
	logger.info("****Starting Adding Product Test****");
	
	// click myAccount in the homepage and then click login
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	// pass valid email and password 
	LoginClass login = new LoginClass(driver);
	login.setEmail(p.getProperty("email"));
	login.setPassword(p.getProperty("password"));
	login.clickLogin();
	Thread.sleep(3000);
	
	AddProduct ad = new AddProduct(driver);
	ad.clickOnDesktopTab();
	ad.clickOnProduct();
	ad.addToCart();
	ad.openShoppingCart();
	Assert.assertTrue(ad.verifyItemOnCart());
	
	logger.info("****Finished Adding Product Test****");
	
	
	}
}
