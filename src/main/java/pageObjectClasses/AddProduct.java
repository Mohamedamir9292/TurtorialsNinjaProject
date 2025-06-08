package pageObjectClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddProduct extends BasePage{

	public AddProduct(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(linkText="Desktops")
	WebElement btn_desktops_tab;
	
	@FindBy(linkText="Mac (1)")
	WebElement btn_mac_product;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]")
	WebElement btn_addToCart;
	
	@FindBy(xpath="//span[text()=\"Shopping Cart\"]")
	WebElement btn_shoppingCart;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/table")
	WebElement itemOnCart;
	
	public void clickOnDesktopTab() {
		btn_desktops_tab.click();
	}

	public void clickOnProduct() {
		btn_mac_product.click();
	}
	
	public void addToCart() {
		btn_addToCart.click();
	}
	
	public void openShoppingCart() {
		btn_shoppingCart.click();
	}
	
	public boolean verifyItemOnCart() {
		boolean verifyCart = itemOnCart.isDisplayed();
		return verifyCart;
	}
}

