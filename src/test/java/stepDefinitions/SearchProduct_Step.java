package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

import org.junit.Assert;
import pages.SearchProduct_Page;

public class SearchProduct_Step {

	WebDriver driver;
	SearchProduct_Page searchProductPage;
	Hooks hooks;

	public SearchProduct_Step() {
		hooks = new Hooks();
		searchProductPage = new SearchProduct_Page(Hooks.driver);
	}

	@And("The user enters {string} in the search box")
	public void the_User_Enters_A_ProductName_In_The_SearchInput(String itemName) {
		searchProductPage.enterProductNameOnSearchBox(itemName);
	}

	@And("The user clicks on search icon")
	public void th_user_clicks_on_search_icon() {
		searchProductPage.clickOnSearchIcon();
	}

	@Then("The searched product {string} should be visible")
	public void The_searched_product_should_be_visible(String expectedproductName) {
		String actualProductname = searchProductPage.getSearchedProductName();
		Assert.assertEquals(expectedproductName, actualProductname);
		System.out.println("The actual product name that we got after searching is: " + actualProductname);
	}

	@And("The user clears the searchbox and searches with {string}")
	public void the_user_clears_the_searchbox_and_searches_with_TShirts(String productName) {
		searchProductPage.enterProductNameOnSearchBox(productName);
	}

	@Then("All the products related to T-shirt should be visible")
	public void All_the_products_related_to_search_should_be_visible() {
		List<String> actualProductNames = searchProductPage.getAllSearchedProductNames();
		
		System.out.println("Below are the displayed products in products page\n======================================");
		
		for (String productName : actualProductNames) {
			System.out.println(productName);
		}
	}

}
