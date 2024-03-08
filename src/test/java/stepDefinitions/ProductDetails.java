package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;

public class ProductDetails {

	WebDriver driver;
	ProductDetailsPage productsPage;
	Hooks hooks;

	public ProductDetails() {
		hooks = new Hooks();
		productsPage = new ProductDetailsPage(Hooks.driver);

	}

	@And("The user clicks on Products option in the homepage")
	public void the_user_clicks_on_Products_option_in_the_homepage() {
		productsPage.clickOnProductOption();
	}

	@Then("The user should be navigated to the ALL PRODUCTS page and the page title should be 'Automation Exercise - All Products'")
	public void the_user_should_be_navigated_to_the_ALL_PRODUCTS_page_and_the_page_title_should_be_Automation_Exercise_All_Products() {

	}

	@And("The user should see the products list")
	public void the_user_should_see_the_products_list() {

		boolean areAllVisible = productsPage.areAllProductsVisible();
		int productCount = productsPage.getProductCount();

		Assert.assertTrue(areAllVisible, "Not all products are visible on the product page");

		System.out.println("The user is able to see all the " + productCount + " products on the product page");
	}

	@When("The user clicks on 'View Product' of the first product")
	public void the_user_clicks_on_View_Product_of_the_first_product() {
		productsPage.clickOnViewproduct();
	}

	@Then("The user should be landed to the product detail page")
	public void the_user_should_be_landed_to_the_product_detail_page() {
		String inPDP = productsPage.getwriteReviewTxt();
		System.out.println("The user landed on PDP, I confirmed this by " + inPDP + " text in product description page");
	}

	@And("The user should see the product name, category, price, availability, condition, and brand")
	public void the_user_should_see_the_product_name_category_price_availability_condition_and_brand() {
		assertTrue(productsPage.isProductNameVisible(), "Product name is not visible");
		assertTrue(productsPage.isProductPriceVisible(), "Product price is not visible");
		assertTrue(productsPage.isCategoryVisible(), "Category is not visible");
		assertTrue(productsPage.isProductAvailabilityVisible(), "Product availability is not visible");
		assertTrue(productsPage.isProductConditionVisible(), "Product condition is not visible");
		assertTrue(productsPage.isProductBrandVisible(), "Product brand is not visible");

	}
}
