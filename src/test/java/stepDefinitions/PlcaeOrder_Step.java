package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.PlaceOrder_Page;

public class PlcaeOrder_Step {
	
	WebDriver driver;
	PlaceOrder_Page placeOrderPage;
	Hooks hooks;

	public PlcaeOrder_Step() {
		hooks = new Hooks();
		placeOrderPage = new PlaceOrder_Page(Hooks.driver);
	}
	
	@And("The user clicks on Proceed To Checkout button in the cart page")
	public void the_user_clicks_on_Proceed_To_Checkout_button() {
		
		placeOrderPage.clickOnProceedToCheckoutBtn();
	}
	
	@Then("The user clicks on Register_Login link on checkout pop-up")
	public void the_user_clicks_on_Register_Login_link() {
		
		placeOrderPage.clickOnRegisterOrLoginTxt();
	}
	
	@And("The user should able to see the Delivey and Billing Address Details")
	public void the_user_should_able_to_see_the_Delivey_and_Billing_Address() {
		
		placeOrderPage.printAddressDetails();
	}
	
	@And("The user enters description {string} in comment text area and clicks Place Order")
	public void the_user_enters_description_in_comment_text_area_and_clicks_Place_Order(String comment) {
		
		placeOrderPage.enterCommentAndHitPlaceOrderBtn(comment);
	}
	
	@And("The user enters card Detail name as {string} number as {string} cvv as {string} expiry month and year as {string} and {string}")
	public void the_user_enters_card_Detail_name_number_cvv_expiry_month_and_year(String name, String number, String cvv, String month, String year) {
		
		placeOrderPage.enterCardDetails(name, number, cvv, month, year);
	}
	
	@And("The user clicks on Pay and Confirm order and {string} should display after placing an order")
	public void confirmation_message_should_display_after_placing_an_order(String expectedMessage) {
		
		placeOrderPage.clickOnPayAndConfirmOrderBtn();
		
		String actualMessage = placeOrderPage.getOrderPlacedMsg();
		Assert.assertEquals(actualMessage, expectedMessage);
		
		System.out.println(actualMessage+ " ---> This is the message that we got after placing an order");
	}
}
