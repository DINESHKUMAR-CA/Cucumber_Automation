package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder_Page {

	WebDriver driver;
	Register_User_Page registerUserPage;

	public PlaceOrder_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
		registerUserPage = new Register_User_Page(driver);
	}

	@FindBy(xpath = "//section[@id=\"cart_items\"]//section//a[contains(@class,'check_out')]")
	WebElement proceedToCheckoutBtn;

	@FindBy(xpath = "//div[@id=\"checkoutModal\"]//a[normalize-space()='Register / Login']")
	WebElement registerOrLoginTxt;

	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Address Details']")
	WebElement addressDetailsTxt;

	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Review Your Order']")
	WebElement reviewOrderTxt;

	@FindBy(xpath = "//ul[@id=\"address_delivery\"]//li[@class=\"address_firstname address_lastname\"]")
	WebElement delivery_Name;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_delivery\"]//li[@class=\"address_address1 address_address2\"][2]")
	WebElement delivery_Address;

	@FindBy(xpath = "//ul[@id=\"address_delivery\"]//li[contains(@class,\"address_city\")]")
	WebElement delivery_City_State_Zip;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_delivery\"]//li[@class=\"address_country_name\"]")
	WebElement deliver_Country;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_delivery\"]//li[@class=\"address_phone\"]")
	WebElement delivery_PhoneNum;

	@FindBy(xpath = "//ul[@id=\"address_invoice\"]//li[@class=\"address_firstname address_lastname\"]")
	WebElement billing_Name;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_invoice\"]//li[@class=\"address_address1 address_address2\"][2]")
	WebElement billing_Address;

	@FindBy(xpath = "//ul[@id=\"address_invoice\"]//li[contains(@class,\"address_city\")]")
	WebElement billing_City_State_Zip;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_invoice\"]//li[@class=\"address_country_name\"]")
	WebElement billing_Country;

	@FindBy(xpath = "//div[@class=\"row\"]//ul[@id=\"address_invoice\"]//li[@class=\"address_phone\"]")
	WebElement billing_PhoneNum;

	@FindBy(xpath = "//div[@id=\"ordermsg\"]//textarea[@name=\"message\"]")
	WebElement commentBox;

	@FindBy(xpath = "//div[@class=\"container\"]//a[normalize-space()='Place Order']")
	WebElement placeOrderBtn;

	@FindBy(name = "name_on_card")
	WebElement nameOnCard;

	@FindBy(name = "card_number")
	WebElement CardNumber;

	@FindBy(name = "cvc")
	WebElement cardCVV;

	@FindBy(name = "expiry_month")
	WebElement cardExpiryMonth;

	@FindBy(name = "expiry_year")
	WebElement cardExpiryYear;

	@FindBy(id = "submit")
	WebElement confirmOrderBtn;

	@FindBy(xpath = "//div[@id=\"success_message\"]//div[contains(text(),'placed successfully!')]")
	WebElement orderPlacedMsg;

	public void clickOnProceedToCheckoutBtn() {
		proceedToCheckoutBtn.click();
	}

	public void clickOnRegisterOrLoginTxt() {
		registerOrLoginTxt.click();
	}

	public String[] getAddressDetailsCartPage() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", addressDetailsTxt);

		String deliveryName = delivery_Name.getText();
		String deliveryAddress = delivery_Address.getText();
		String deliveryCityStateZip = delivery_City_State_Zip.getText();
		String deliveryCountry = deliver_Country.getText();
		String deliveryPhoneNum = delivery_PhoneNum.getText();
		String billingName = billing_Name.getText();
		String billingAddress = billing_Address.getText();
		String billingCityStateZip = billing_City_State_Zip.getText();
		String billingCountry = billing_Country.getText();
		String billingPhoneNum = billing_PhoneNum.getText();

		return new String[] { deliveryName, deliveryAddress, deliveryCityStateZip, deliveryCountry, deliveryPhoneNum,
				billingName, billingAddress, billingCityStateZip, billingCountry, billingPhoneNum };
	}

	public void printAddressDetails() {
		String[] addressDetails = getAddressDetailsCartPage();

		System.out.println("The user can see all the below details in AddressDetails page");
		System.out.println("=============================================================");
		System.out.println("Delivery Name: " + addressDetails[0]);
		System.out.println("Delivery Address: " + addressDetails[1]);
		System.out.println("Delivery City, State, Zip: " + addressDetails[2]);
		System.out.println("Delivery Country: " + addressDetails[3]);
		System.out.println("Delivery Phone Number: " + addressDetails[4]);
		System.out.println("Billing Name: " + addressDetails[5]);
		System.out.println("Billing Address: " + addressDetails[6]);
		System.out.println("Billing City, State, Zip: " + addressDetails[7]);
		System.out.println("Billing Country: " + addressDetails[8]);
		System.out.println("Billing Phone Number: " + addressDetails[9]);
	}

	public void enterCommentAndHitPlaceOrderBtn(String comment) {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", commentBox);

		commentBox.sendKeys(comment);
		placeOrderBtn.click();
	}

	public void enterCardDetails(String name, String number, String cvv, String month, String year) {
		nameOnCard.sendKeys(name);
		CardNumber.sendKeys(number);
		cardCVV.sendKeys(cvv);
		cardExpiryMonth.sendKeys(month);
		cardExpiryYear.sendKeys(year);

	}

	public void clickOnPayAndConfirmOrderBtn() {
		confirmOrderBtn.click();
	}
	
	public String getOrderPlacedMsg() {
		
		driver.navigate().back();	
		return orderPlacedMsg.getText();
	}
}
