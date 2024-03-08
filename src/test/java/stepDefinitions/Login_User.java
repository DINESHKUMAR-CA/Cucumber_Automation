package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Login_User {

	WebDriver driver;
	LoginPage loginpage;
	Hooks hook;

	public Login_User() {
		loginpage = new LoginPage(driver);
	}

	@Before
	public void setup() {
		loginpage = new LoginPage(Hooks.driver);
	}

	@When("The user clicks on Logout option in homepage")
	public void the_user_clicks_on_logout_option_in_homepage() {
		loginpage.clickOnLogoutBtn();
	}

	@Then("{string} should be visible in Login page")
	public void login_to_your_account_should_be_visible(String expectedText) {

		String actualText = loginpage.getLoginToYourAccountTxt();
		Assert.assertEquals(expectedText, actualText, "Expected Text: " + expectedText + " is not visible");
	}

	@And("The user enters the Email as {string} and password as {string}")
	public void the_user_enters_the_email_as_and_password_as(String email, String password) {
		loginpage.enterEmailAndPassword(email, password);
	}

	@And("The user clicks on Login button")
	public void the_user_clicks_on_login_button() {
		loginpage.clickOnLoginBtn();
	}
}
