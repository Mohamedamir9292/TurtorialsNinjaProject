package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectClasses.HomePage;
import pageObjectClasses.LoginClass;
import pageObjectClasses.SearchProduct;
import testBase.BaseClass;

public class TC003_SearchProduct extends BaseClass{
	
	
	
	@Test(groups = {"Sanity", "Master"})
	public void searchForProduct() throws InterruptedException {
		
		logger.info("****Starting product search test****");
		
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
		SearchProduct searchProduct = new SearchProduct(driver);
		searchProduct.typeProductToSearch("mac");
		searchProduct.clickSearchButton();
		Assert.assertTrue(searchProduct.validateProduct());
		
		logger.info("*****Finished product search test*****");
		
	}
	
	
	
}
