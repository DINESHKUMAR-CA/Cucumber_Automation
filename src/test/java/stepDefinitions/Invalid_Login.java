package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import pages.Login_Page;
import pages.Register_User_Page;

public class Invalid_Login {
	
	WebDriver driver;
	Login_Page loginpage;
	Register_User_Page signUpPage;
	
	Hooks hook;
	
	public Invalid_Login() {
		loginpage = new Login_Page(driver);
		signUpPage = new Register_User_Page(driver);
	}
	
	@Before
	public void setup() {
		loginpage = new Login_Page(Hooks.driver);
	}
	
	@Then("{string} error message should be visible")
    public void error_message_should_be_visible(String expectedErrorMessage) {
		String actualErrorMessage = loginpage.getInvalidEmailPwdErrorMsg();
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
		System.out.println("The actual message is: " + actualErrorMessage + " and expected is: " + expectedErrorMessage);
		
    }
}
