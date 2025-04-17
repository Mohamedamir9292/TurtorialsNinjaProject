package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	// initiate WebElements:
	@FindBy(name = "firstname")
	WebElement txtFirstname;
	@FindBy(name = "lastname")
	WebElement txtLastname;
	@FindBy(name = "email")
	WebElement txtEmail;
	@FindBy(name = "telephone")
	WebElement txtTelephne;
	@FindBy(name = "password")
	WebElement txtPassword;
	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;
	@FindBy(name = "agree")
	WebElement chkPolicy;
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	// create a method for each WebElement:
	public void setFirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	public void setLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtTelephne.sendKeys(telephone);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void setConfirmPassword(String confirmpwd) {
		txtConfirmPassword.sendKeys(confirmpwd);
	}
	public void setPrivacyPolicy() {
		chkPolicy.click();
	}
	public void clickContinue() {
		btnContinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirmation.getText());
		}
		catch(Exception e){
			return(e.getMessage());
		}
	}
	

}
