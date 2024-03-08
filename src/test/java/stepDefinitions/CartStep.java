package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.CartPage;

public class CartStep {
	
	WebDriver driver;
	CartPage cartPage;
	Hooks hooks;
	
	public CartStep() {
		hooks = new Hooks();
		cartPage = new CartPage(Hooks.driver);
	}
	
	@When("The user clicks on cart option")
	public void the_user_clicks_on_cart_option() {
		cartPage.clickOnCartOption();
	}

}
