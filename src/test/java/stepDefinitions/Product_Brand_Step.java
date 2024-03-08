package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Product_Brand_Page;

public class Product_Brand_Step {
	
	WebDriver driver;
	Product_Brand_Page productBrandPage;
	Hooks hooks;

	public Product_Brand_Step() {
		hooks = new Hooks();
		productBrandPage = new Product_Brand_Page(Hooks.driver);
	}

    @When("The user scrolls to Brands and selects BABYHUG")
    public void the_user_scrolls_to_Brands_and_selects_BABYHUG() {
    	productBrandPage.scrollToBrandsInCategory();
    	productBrandPage.clickOnBABYHUGUnderBrands();
    }

    @Then("The page Title should be {string}")
    public void the_page_Title_should_be_Automation_Exercise_Babyhug_Products(String expectedTitle) {
    	String actualTitle = productBrandPage.clickOnBABYHUGUnderBrands();
    	Assert.assertEquals(actualTitle, expectedTitle);
    	System.out.println(actualTitle + " ------> This is the title we expected");
    }

    @When("The user clicks on KOOKIE KIDS brand")
    public void the_user_clicks_on_KOOKIE_KIDS_brand() {
    	productBrandPage.clickOnKOOKIEKIDSUnderBrands();
    }

    @Then("The user should land on KOOKIE KIDS PRODUCTS pages and the page title should be {string}")
    public void the_user_should_land_on_KOOKIE_KIDS_PRODUCTS_pages_and_the_page_title_should_match(String expectedTitle) {
    	String actualTitle = productBrandPage.getKOOKIEKIDSBrandPageTitle();
    	Assert.assertEquals(actualTitle, expectedTitle);
    	System.out.println(actualTitle + " ------> This is the title we expected");
    	
    }
}
