package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductQuantity_Cart_Page;

public class ProductQuantity_Cart_Step {
	
	WebDriver driver;
	ProductQuantity_Cart_Page productQuantityPage;
	Hooks hooks;
	
	public ProductQuantity_Cart_Step() {
		hooks = new Hooks();
		productQuantityPage = new ProductQuantity_Cart_Page(Hooks.driver);
	}
	
	@When("The user clicks on 'View Product' of the first product under FEATURES ITEMS")
	public void the_user_scrolling_to_FEATURES_ITEMS_and_clicks_on_View_Product() {
		productQuantityPage.clickOnViewProduct();
	}
	
	@And("The user is increasing the product quantity to {string}")
	public void the_user_is_increasing_the_product_quantity(String quantity) {
		productQuantityPage.enterProductQuantity(quantity);
	}
	
	@And("The user clicks on Add To Cart button and clicks on view cart link in the pop-up")
	public void the_user_clicks_on_Add_To_Cart_button_and_clicks_on_view_cart_link() {
		productQuantityPage.clickOnAddToCartBtn();
		productQuantityPage.clickOnViewCartLink();
	}
	
	@Then("The user should land on cart page and able to view the product with exact quantity")
	public void the_user_should_land_on_cart_page_and_able_to_view_the_product_with_exact_quantity() {
		productQuantityPage.getTheProductCount();
	}
}	
