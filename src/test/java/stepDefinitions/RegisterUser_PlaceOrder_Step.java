package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pages.RegisterUser_PlaceOrder_Page;

public class RegisterUser_PlaceOrder_Step {
	
	WebDriver driver;
	RegisterUser_PlaceOrder_Page RegisterUserPlaceOrder;
	Hooks hooks;

	public RegisterUser_PlaceOrder_Step() {
		hooks = new Hooks();
		RegisterUserPlaceOrder = new RegisterUser_PlaceOrder_Page(Hooks.driver);
	}
	
	@Then("The cart page title should be {string}")
	public void the_cart_page_title_should_change(String expectedTitle) {
		
		String actualTitle = RegisterUserPlaceOrder.getCartPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle + " =======> This is the title that we expected");
	}
}
