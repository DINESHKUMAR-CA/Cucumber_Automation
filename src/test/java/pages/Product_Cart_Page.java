package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Cart_Page {

	WebDriver driver;
	WebDriverWait wait;

	public Product_Cart_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	@FindBy(xpath = "//div[@class=\"features_items\"]//h2[normalize-space()='All Products']")
	WebElement allProducts;

	@FindBy(xpath = "//div[@class=\"single-products\"]//div[@class=\"productinfo text-center\"]//p[normalize-space()='Blue Top']")
	WebElement productBlueTop;

	@FindBy(xpath = "//div[@id=\"cartModal\"]//button[normalize-space()='Continue Shopping']")
	WebElement ctnShoppingBtn;

	@FindBy(xpath = "//div[@class=\"productinfo text-center\"]//p[text()='Men Tshirt']")
	WebElement productMenTshirt;

	@FindBy(xpath = "//div[@id=\"cart_info\"]//td[normalize-space()='Item']")
	public WebElement cartItem;

	public void hoverOverProduct1AndClickAddToCart() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", allProducts);

		Actions actions = new Actions(driver);
		actions.moveToElement(productBlueTop).perform();

		WebElement addToCartBtn = productBlueTop
				.findElement(By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"1\"]"));

		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();
	}

	public String clickOnContinueShoppingButton() {

		wait.until(ExpectedConditions.visibilityOf(ctnShoppingBtn));
		String ctnShoppingBtnTxt = ctnShoppingBtn.getText();
		ctnShoppingBtn.click();
		return ctnShoppingBtnTxt;
	}

	public void hoverOverProduct2AndClickAddToCart() {

		Actions actions = new Actions(driver);
		actions.moveToElement(productMenTshirt).perform();

		WebElement addToCartBtn = productBlueTop
				.findElement(By.xpath("//div[@class=\"overlay-content\"]//a[@data-product-id=\"2\"]"));

		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
		addToCartBtn.click();

	}

	public void verifyCartItems() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartItem);
		
		List<WebElement> cartItems = driver.findElements(By.xpath("//tbody//tr"));
		int productCount = cartItems.size();

		System.out.println("We found " + productCount + " products in the cart page and the details are listed below:");

		for (WebElement cartItem : cartItems) {

			String productName = cartItem.findElement(By.xpath("//tbody//td[@class=\"cart_description\"]//a")).getText();
			String totalPrice = cartItem.findElement(By.xpath("//tbody//td[@class=\"cart_total\"]")).getText();
			String quantity = cartItem.findElement(By.xpath("//tbody//td[@class=\"cart_quantity\"]//button")).getText();

			System.out.println("Product Name: " + productName);
			System.out.println("Quantity: " + quantity);
			System.out.println("Total Price: " + totalPrice);
			System.out.println("--------------------------");
		}
	}

}
