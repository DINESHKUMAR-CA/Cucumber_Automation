package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubscriptionPage {

	WebDriver driver;

	public SubscriptionPage(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"single-widget\"]//h2")
	WebElement subscriptionTxt;

	@FindBy(id = "susbscribe_email")
	WebElement subscriptionEmail;

	@FindBy(id = "subscribe")
	WebElement emailArrow;

	@FindBy(xpath = "//div[@class=\"alert-success alert\"]")
	WebElement successMessage;

	public void scrollToSubscriptiontxt() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", subscriptionTxt);
	}

	public String getSubscriptionTxt() {
		return subscriptionTxt.getText();
	}

	public void enterSubscriptionEmail(String email) {
		subscriptionEmail.sendKeys(email);
	}

	public void clickOnEmailArrow() {
		emailArrow.click();
	}

	public String getDisplayedSuccessMessage() {
		return successMessage.getText();
	}
}
