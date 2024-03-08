package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Product_Cart_Page;

public class Product_Cart_Step {

	WebDriver driver;
	Product_Cart_Page paroductCartPage;
	Hooks hooks;

	public Product_Cart_Step() {
		hooks = new Hooks();
		paroductCartPage = new Product_Cart_Page(Hooks.driver);
	}

	@When("The user hover over on first product and clicks on Add to cart")
	public void The_user_hover_over_on_first_product_and_clicks_on_add_to_cart() throws InterruptedException {
		paroductCartPage.hoverOverProduct1AndClickAddToCart();
	}

	@Then("Product added pop-up should pop-up and the user click on {string}")
	public void Product_added_popup_should_pop_up_and_the_user_click_on_Continue_Shopping(String expectedBtnText) {
		String actualBtnText = paroductCartPage.clickOnContinueShoppingButton();
		Assert.assertEquals(expectedBtnText, actualBtnText);
		System.out.println("The pop-up appeared and I clicked on "+actualBtnText + " button");
	}
	
	@And("The user hover over on second product and clicks on Add to cart")
	public void The_user_hover_over_on_second_product_and_clicks_on_Addtocart() {
		paroductCartPage.hoverOverProduct2AndClickAddToCart();
	}
	
	@Then("The user should able to see both the products along with prices, quantity and total price")
	public void The_user_should_able_to_see_both_the_products_along_with_other_Details() {
		paroductCartPage.verifyCartItems();
	}

}
