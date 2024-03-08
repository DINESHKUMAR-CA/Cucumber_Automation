package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.Register_User_Page;


public class Register_User {

	public static WebDriver driver;
	Register_User_Page signUpPage;
	LoginPage loginPage;
	Hooks hooks;
	
	public Register_User() {
		 hooks = new Hooks();
	     signUpPage = new Register_User_Page(Hooks.driver);
	     loginPage = new LoginPage(Hooks.driver); 
	}
	
	@When("The user clicks on Signup Login option")
	public void the_user_clicks_on_Signup_Login_option() {
		signUpPage.clickOnSignUpOption();
	}

	@Then("{string} should be visible")
	public void should_be_visible(String expectedText) {
		
		String actualText = signUpPage.getNewUserSignUpText();
		Assert.assertEquals(expectedText, actualText, "Expected Text: " + expectedText + "is not visible");
	}

	@And("The user enters the name as {string} and email address as {string}")
	public void the_user_enters_the_name_as_and_email_address(String UserName, String UserEmail) {
		signUpPage.enterNameAndEmail(UserName, UserEmail);
	}
	
	@And("The user clicks the {string} button")
	public void the_user_clicks_the_button(String string) {
		signUpPage.clickOnSignUpBtn();
	}

	@Then("{string} should be visible on the page")
	public void should_be_visible_on_the_page(String expectedText) {
		String actualText = signUpPage.getEnterAccountInformationText();
		Assert.assertEquals(expectedText, actualText, "Expected Text: " + expectedText + " is not visible");
	}

	@And("The user selects Tittle as Mr")
	public void the_user_selects_tittle_as_mr() {
		signUpPage.selectGender();
	}

	@And("The user provide the password as {string}")
	public void the_user_provide_the_password_as(String userPassword) {
		signUpPage.enterPassword(userPassword);
	}

	@And("The user selects the Date of Birth")
	public void the_user_selects_the_date_of_birth() {
		signUpPage.selectDOBDay();
		signUpPage.selectDOBMonth();
		signUpPage.selectDOBYear();
	}

	@Then("The user selects the {string} and 'Receive special offers from our partners!'checkboxs")
	public void the_user_selects_the_and_receive_special_offers_from_our_partners_checkboxs(String string) {
		signUpPage.selectCheckBox();
	}

	@And("The user provides the first name as {string} and last name as {string} and company as {string}")
	public void the_user_provides_first_last_company_names(String userFirstName, String userLastName, String userCompanyName) {
		signUpPage.enterFirstLastCompanyNames(userFirstName, userLastName, userCompanyName);
	}

	@And("The user provides the address as {string} Selects the country and enters the mobile number as {string}")
	public void the_user_provides_the_address_and_selects_the_country(String userAddress, String userMobileNum) {
		signUpPage.enterAddress(userAddress);
		signUpPage.selectCountry();
		signUpPage.enterMobileNumber(userMobileNum);
	}

	@And("The user provides the state as {string} and {string} as city and {string} as zipcode")
	public void the_user_provides_the_state_city_and_zipcode(String userState, String userCity,
			String userZipcode) {
		signUpPage.enterState(userState);
		signUpPage.enterCity(userCity);
		signUpPage.enterZipcode(userZipcode);
	}

	@And("The user clicks on {string} button")
	public void the_user_clicks_on_Create_Account_button(String string) {
		signUpPage.clickOnCreateAccountBtn();
	}
	
	@Then("{string} message should be visible to user")
	public void account_created_message_should_be_visible(String expectedMessage) {
		String actulaMessage = signUpPage.getAccountCreatedMessageTxt();
		assert actulaMessage.contains(expectedMessage) : "Expected Message not found: " + expectedMessage;
	}

	@When("The user clicks {string} button")
	public void the_user_clicks_on_Continue_button(String string) {
		signUpPage.clickOnContinueBtn();
	}

	@Then("{string} should be visible in the homepage")
	public void should_be_visible_in_homepage(String expectedMessage) {
		@SuppressWarnings("unused")
		String actualMessage = signUpPage.getLoggedInUserName();
		signUpPage.compareLoggedInUsername(expectedMessage);
	}
	
	@When("The user clicks the {string} option")
	public void the_user_clicks_on_the_delete_account_option(String string) {
		signUpPage.clickOnDeteleAccount();
	}
	
	@Then("{string} mesaage should be visible")
	public void account_deleted_message_should_be_visible(String expectedMessage) {
		
		boolean isMessageVisible = signUpPage.isAccountDeletedMsgTxtVisible();
		Assert.assertTrue(isMessageVisible, "Account deleted message is not visible");
		
		String actualMesaage = signUpPage.getAccountDeletedMsgTxt();
		Assert.assertEquals(expectedMessage, actualMesaage, "Incorrect Message Displayed");
	}
	
	@And("The user clicks the Continue button in Account Deleted page")
	public void the_user_clicks_on_continue_in_account_deleted_page() {
		signUpPage.clickOnDeletedContinueBtn();
	}
	
	
}
