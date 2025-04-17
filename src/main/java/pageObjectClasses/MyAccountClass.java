package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountClass extends BasePage{

	public MyAccountClass(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement headerMsg;
	
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement lnkLogOut;
	
	
	
	public boolean doesMyAccountExist() {
		try
		{
			return (headerMsg.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogOut() {
		lnkLogOut.click();
	}

}
