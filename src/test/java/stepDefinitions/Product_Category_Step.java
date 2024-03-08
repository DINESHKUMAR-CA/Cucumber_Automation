package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Product_Category_Page;

public class Product_Category_Step {
	
	WebDriver driver;
	Product_Category_Page productCategoryPage;
	Hooks hooks;
	
	public Product_Category_Step() {
		hooks = new Hooks();
		productCategoryPage = new Product_Category_Page(Hooks.driver);
	}
	
	@Then("The user scrolls to CATEGORY section")
	public void Then_The_user_scrolls_to_CATEGORY_section() {
		productCategoryPage.scrollToCategorysection();
	}

	@When("The user clicks on WOMEN under CATEGORY section and select SAREE")
	public void When_The_user_clicks_on_WOMEN_under_CATEGORY_section_and_select_SAREE() {
		productCategoryPage.clickOnWomenCategory();
	}

	@Then("The user should navigate to category page and able to see {string}")
	public void Then_The_user_should_navigate_to_category_page_and_able_to_see_WOMEN_TOPS_PRODUCTS(String expectedText) {
		String actualText = productCategoryPage.getSareeProductsText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText + " -----> This is the text that we expected");
	}

	@And("The user clicks on MEN under CATEGORY section and select Tshirt")
	public void And_The_user_clicks_on_MEN_under_CATEGORY_section_and_select_Tshirt() {
		productCategoryPage.clickOnMenCategory();
	}

	@Then("The user should be navigate to sub category page and able to see {string}")
	public void Then_The_user_should_be_navigate_to_sub_category_page_and_able_to_see_MEN_TSHIRTS_PRODUCTS(String expectedText) {
		String actualText = productCategoryPage.getMenTshirtProductsText();
		Assert.assertEquals(actualText, expectedText);
		System.out.println(actualText + " -----> This is the text that we expected");
	}

}
