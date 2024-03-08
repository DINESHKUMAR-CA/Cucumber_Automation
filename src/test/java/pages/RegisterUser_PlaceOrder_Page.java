package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUser_PlaceOrder_Page {
	
	WebDriver driver;
	WebDriverWait wait;

	public RegisterUser_PlaceOrder_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	public String getCartPageTitle() {
		return driver.getTitle();
	}
}
