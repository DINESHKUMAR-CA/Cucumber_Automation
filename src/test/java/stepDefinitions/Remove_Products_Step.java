package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Remove_Products_Page;

public class Remove_Products_Step {
	
	WebDriver driver;
	Remove_Products_Page removeproductsPage;
	Hooks hooks;

	public Remove_Products_Step() {
		hooks = new Hooks();
		removeproductsPage = new Remove_Products_Page(Hooks.driver);
	}
	
	@And("The added products should be available in the cart page and the user clicks on X button on particluar product")
	public void the_added_products_should_be_avaialbale_in_the_cart_page() {
		removeproductsPage.verifyAndRemoveCartItems();
	}
	
	@Then("The particular product should be removed from cart")
	public void the_particular_should_be_removed_from_cart() {
		
	}
}
