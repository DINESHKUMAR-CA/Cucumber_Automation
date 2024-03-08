package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubscriptionPage;

public class SubscriptionStep {

	WebDriver driver;
	SubscriptionPage subscriptionPage;
	Hooks hooks;

	public SubscriptionStep() {
		hooks = new Hooks();
		subscriptionPage = new SubscriptionPage(Hooks.driver);
	}
	
	@When("The user scroll down to the footer")
	public void the_user_scroll_down_to_the_footer() {
		subscriptionPage.scrollToSubscriptiontxt();
	}
	
	@Then("The user should able to view the {string}")
	public void the_user_should_able_to_view_the_subscription(String expectedsubScriptionText) {
		String displayedsubscriptiontext = subscriptionPage.getSubscriptionTxt();
		System.out.println("The user is able to view the " + displayedsubscriptiontext + " in the footer");
	}

	@And("The user enters their email {string} and clicks the right arrow button")
	public void the_User_Enters_their_email_and_clicks_the_right_arrow_Button(String email) {
		subscriptionPage.enterSubscriptionEmail(email);
		subscriptionPage.clickOnEmailArrow();
	}

	@Then("The success message {string} should be visible")
	public void the_success_message_should_be_visible(String expectedMessage) {
		String actualMessage = subscriptionPage.getDisplayedSuccessMessage();
		Assert.assertEquals(expectedMessage, actualMessage);
		System.out.println("Expected Message: "+expectedMessage+" Actual Message: "+actualMessage);
	}
}
