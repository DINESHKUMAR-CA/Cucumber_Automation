package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;
import pages.Cart_Page;

public class CartStep {
	
	WebDriver driver;
	Cart_Page cartPage;
	Hooks hooks;
	
	public CartStep() {
		hooks = new Hooks();
		cartPage = new Cart_Page(Hooks.driver);
	}
	
	@When("The user clicks on cart option")
	public void the_user_clicks_on_cart_option() {
		cartPage.clickOnCartOption();
	}

}
