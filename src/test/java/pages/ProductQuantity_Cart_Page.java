package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductQuantity_Cart_Page {

	WebDriver driver;
	Product_Cart_Page productCartPage;
	WebDriverWait wait;

	public ProductQuantity_Cart_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
		productCartPage = new Product_Cart_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	}

	@FindBy(xpath = "//div[@class=\"features_items\"]//h2[normalize-space()=\"Features Items\"]")
	WebElement featureItems;

	@FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
	WebElement viewProduct;

	@FindBy(id = "quantity")
	WebElement quantityTxtBox;

	@FindBy(xpath = "//div[@class=\"product-information\"]//span//button[normalize-space()='Add to cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@id=\"cartModal\"]//u[text()='View Cart']")
	WebElement viewCartLink;

	@FindBy(xpath = "//tbody//td[@class=\"cart_quantity\"]//button")
	WebElement productQnty;

	public void clickOnViewProduct() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", featureItems);
		viewProduct.click();
	}

	public void enterProductQuantity(String quantity) {

		quantityTxtBox.clear();
		quantityTxtBox.sendKeys(quantity);	

	}

	public void clickOnAddToCartBtn() {
		addToCartBtn.click();
	}

	public void clickOnViewCartLink() {

		wait.until(ExpectedConditions.visibilityOf(viewCartLink));
		viewCartLink.click();
	}

	public void getTheProductCount() {
		
		driver.navigate().back();
		
		int userSetQuantity = Integer.parseInt(quantityTxtBox.getAttribute("value"));
		
		driver.navigate().forward();

		String productCountText = productQnty.getText();
		int productCountInCart = Integer.parseInt(productCountText);

		if (userSetQuantity == productCountInCart) {
			System.out
					.println("Yes, The product quantity set by the user is "+userSetQuantity+ " and it's matches the product quantity in the Cart page " + productCountInCart);
		} else {
			System.out.println(
					"No, The product quantity set by the user is "+userSetQuantity+" and it does not match the product quantity in the Cart page");
		}
	}
}
