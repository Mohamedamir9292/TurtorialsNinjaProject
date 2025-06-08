package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SearchProduct extends BasePage{

	public SearchProduct(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(name="search")
	WebElement txt_search;
	
	@FindBy(xpath="//span[@class=\"input-group-btn\"]/button")
	WebElement btn_search;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[3]/div[3]/div/div[1]/a/img")
	WebElement img_product;
	
	public void typeProductToSearch(String product) {
		txt_search.sendKeys(product);
	}
	
	public void clickSearchButton() {
		btn_search.click();
	}
	
	public boolean validateProduct() {
		boolean productDisplayed = img_product.isDisplayed();
		return productDisplayed;
		
	}
}
