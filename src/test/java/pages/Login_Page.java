package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Login_Page(WebDriver IDriver) {
		
		driver = IDriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]//child::li/a[normalize-space()='Logout']")
	WebElement logoutBtn;
	
	@FindBy(xpath = "//div[@class='login-form']/child::h2")
	WebElement LoginToAccountTxt;
	
	@FindBy(xpath = "//form[@action=\"/login\"]//child::input[@name=\"email\"]")
	WebElement emailAddressField;
	
	@FindBy(xpath = "//form[@action=\"/login\"]/input[@name=\"password\"]")
	WebElement passwordField;
	
	@FindBy(css = "button[data-qa='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//form[@action=\"/login\"]/p")
	WebElement invalidEmailPwdErrorMsg;
	
	public void clickOnLogoutBtn() {
		logoutBtn.click();
	}
	
	public boolean isLoginToYourAccountTxtVisible() {
		
		return wait.until(ExpectedConditions.visibilityOf(LoginToAccountTxt)).isDisplayed();
	}
	
	public String getLoginToYourAccountTxt() {
		return LoginToAccountTxt.getText();
	}
	
	public void enterEmailAndPassword(String userEmail, String userPassword) {
		emailAddressField.sendKeys(userEmail);
		passwordField.sendKeys(userPassword);
	}
	
	public void clickOnLoginBtn() {
		loginBtn.click();
	}
	
	public boolean isInvalidEmailPwdErrorMsgVisible() {
		
		return wait.until(ExpectedConditions.visibilityOf(invalidEmailPwdErrorMsg)).isDisplayed();
	}
	
	public String getInvalidEmailPwdErrorMsg() {
		return invalidEmailPwdErrorMsg.getText();
	}
}
