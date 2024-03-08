package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register_User_Page {

	public static WebDriver driver;

	public Register_User_Page(WebDriver IDriver) {

		driver = IDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement signUpTxt;

	@FindBy(xpath = "//div[@class=\"signup-form\"]/child::h2")
	WebElement newUserSignUpTxt;

	@FindBy(name = "name")
	WebElement nameTxtField;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement emailTxtField;

	@FindBy(xpath = "//button[normalize-space()='Signup']")
	WebElement signUpBtn;
	
	@FindBy(xpath = "//form[@action=\"/signup\"]/p")
	WebElement accountExistErrorMsg;

	@FindBy(xpath = "//b[normalize-space()='Enter Account Information']")
	WebElement informationTxt;

	@FindBy(id = "id_gender1")
	WebElement gender;

	@FindBy(name = "password")
	WebElement passwordTxtField;

	@FindBy(id = "days")
	WebElement dobDay;

	@FindBy(id = "months")
	WebElement dobMonth;

	@FindBy(id = "years")
	WebElement dobYear;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckBox;

	@FindBy(id = "optin")
	WebElement specialOfferCheckBox;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "last_name")
	WebElement lastName;

	@FindBy(id = "company")
	WebElement companyName;

	@FindBy(xpath = "//div[@class=\"login-form\"]//input[@id=\"address1\"]")
	WebElement addressField;

	@FindBy(id = "country")
	WebElement countryDropdown;

	@FindBy(id = "state")
	WebElement stateField;

	@FindBy(id = "city")
	WebElement cityField;

	@FindBy(id = "zipcode")
	WebElement zipcodeField;

	@FindBy(id = "mobile_number")
	WebElement mobileNumber;

	@FindBy(xpath = "//button[normalize-space()='Create Account']")
	WebElement createAccountBtn;

	@FindBy(xpath = "//b[normalize-space()='Account Created!']")
	WebElement accountCreatedMessage;

	@FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
	WebElement continueBtn;

	@FindBy(xpath = "//a[contains(text(),'Logged')]/b")
	WebElement loggedInUserName;

	@FindBy(xpath = "//a[normalize-space()='Delete Account']")
	WebElement deleteAccountOpt;

	@FindBy(xpath = "//h2[@data-qa=\"account-deleted\"]/b")
	WebElement accountDeletedMsg;

	@FindBy(xpath = "//a[@data-qa=\"continue-button\"]")
	WebElement deletedContinueBtn;

	public void clickOnSignUpOption() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(signUpTxt));
		signUpTxt.click();
	}

	public boolean isNewUserSignUpTextVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(newUserSignUpTxt)).isDisplayed();
	}

	public String getNewUserSignUpText() {
		return newUserSignUpTxt.getText();
	}

	public void enterNameAndEmail(String name, String email) {
		nameTxtField.sendKeys(name);
		emailTxtField.sendKeys(email);
	}

	public void clickOnSignUpBtn() {
		signUpBtn.click();
	}
	
	public boolean isAccountExistErrorMsgVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOf(accountExistErrorMsg)).isDisplayed();	
	}
	
	public String getAccountExistErrorMsg() {
		return accountExistErrorMsg.getText();
	}
	
	public boolean isEnterAccountInformationTextVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(informationTxt)).isDisplayed();
	}

	public String getEnterAccountInformationText() {
		return informationTxt.getText();
	}

	public void selectGender() {
		gender.click();
	}

	public void enterPassword(String password) {
		passwordTxtField.sendKeys(password);
	}

	public void selectDOBDay() {
		Select dobday = new Select(dobDay);
		dobday.selectByIndex(11);
	}

	public void selectDOBMonth() {
		Select dobmonth = new Select(dobMonth);
		dobmonth.selectByValue("8");
	}

	public void selectDOBYear() {
		Select dobyear = new Select(dobYear);
		dobyear.selectByVisibleText("1999");
	}

	public void selectCheckBox() {
		if (!newsletterCheckBox.isSelected()) {
			newsletterCheckBox.click();
		}
		if (!specialOfferCheckBox.isSelected()) {
			specialOfferCheckBox.click();
		}
	}

	public void enterFirstLastCompanyNames(String fstName, String lstName, String company_Name) {
		firstName.sendKeys(fstName);
		lastName.sendKeys(lstName);
		companyName.sendKeys(company_Name);
	}

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	public void selectCountry() {
		Select country = new Select(countryDropdown);
		country.selectByVisibleText("United States");
	}

	public void enterState(String stateName) {
		stateField.sendKeys(stateName);
	}

	public void enterCity(String cityName) {
		cityField.sendKeys(cityName);
	}

	public void enterZipcode(String zipcode) {
		zipcodeField.sendKeys(zipcode);
	}

	public void enterMobileNumber(String mobileNum) {
		mobileNumber.sendKeys(mobileNum);
	}

	public void clickOnCreateAccountBtn() {
		createAccountBtn.click();
	}

	public boolean isAccountCreatedMessageVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(accountCreatedMessage)).isDisplayed();
	}

	public String getAccountCreatedMessageTxt() {

		return accountCreatedMessage.getText();
	}

	public void clickOnContinueBtn() {
		continueBtn.click();

	}

	public String getLoggedInUserName() {
		return loggedInUserName.getText();
	}

	public void compareLoggedInUsername(String expectedMessage) {
		String[] parts = expectedMessage.split(" ");
		String expectedUsername = parts[3];
		String actualMessage = getLoggedInUserName();

		if (actualMessage.contains(expectedUsername)) {
			System.out.println("Username matches: " + expectedUsername);
		} else {
			System.out.println("Username does not match: " + expectedUsername);
		}
	}

	public void clickOnDeteleAccount() {
		deleteAccountOpt.click();
	}

	public boolean isAccountDeletedMsgTxtVisible() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.visibilityOf(accountDeletedMsg)).isDisplayed();
	}

	public String getAccountDeletedMsgTxt() {
		return accountDeletedMsg.getText();
	}

	public void clickOnDeletedContinueBtn() {
		deletedContinueBtn.click();
	}

}
