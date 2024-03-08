package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	
	public CartPage(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]//a[normalize-space()='Cart']")
	WebElement cartOption;
	
	public void clickOnCartOption() {
		cartOption.click();
	}
	
}
