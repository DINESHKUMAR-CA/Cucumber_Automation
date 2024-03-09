package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.ContactUs_Page;

public class ContactUs_Step {
	
	WebDriver driver;
	ContactUs_Page contactPage;
	Hooks hooks;
	
	
	public ContactUs_Step() {
		hooks = new Hooks();
		contactPage = new ContactUs_Page(Hooks.driver);
	}
	
	@And("The user clicks on the contact Us option in the homepage")
    public void click_on_contact_us_option() {
		contactPage.clickOnContactUsOption();
    }

    @Then("{string} should be visible in contact us page")
    public void get_in_touch_should_be_visible(String expectedText) {
       String actualText = contactPage.getGetInTouchTxt();
       Assert.assertEquals(expectedText, actualText);
       System.out.println("Excepted Text: "+ expectedText + " Actual Text: "+ actualText);
    }

    @And("The user enters the name as {string} and email id as {string}")
    public void enter_name_and_email(String name, String email) {
    	contactPage.enterNameAndEmail(name, email);
    }
    
	@And("The user enters subject as {string} and message as {string}")
	public void the_user_enters_the_subject_and_message(String subject, String message) {
		contactPage.enterSubjectAndMessage(subject, message);
	}

    @And("The user uploads the file")
    public void upload_file() throws InterruptedException {
    	
    	contactPage.clickOnUploadBtn();
    	Thread.sleep(10000);
    }

    @And("The user clicks on submit button")
    public void click_submit_button() {
    	contactPage.clickOnSubmitBtn();
    }

    @Then("A simple pop-up will appear and click on ok")
    public void handle_popup() {
    	contactPage.handleSimplePopUp();
    }

    @And("{string} message should be visible after submitting")
    public void verify_success_message_is_visible(String expectedMessage) {
    	String actualMessage = contactPage.getSuccessMsg();
    	Assert.assertEquals(expectedMessage, actualMessage);
    	System.out.println("Expected Message: "+ expectedMessage + "Auctual Message: " + actualMessage);
    }

    @And("The user clicks on Home button")
    public void click_home_button() {
    	contactPage.clickOnHomeButton();
    }

    @Then("The user will land on the homepage")
    public void verify_landed_to_home_page_successfully() {
    	String homeText = contactPage.getHomeOptiontext();
    	System.out.println("Successfully landed on "+ homeText + " page");
    }

	
}
