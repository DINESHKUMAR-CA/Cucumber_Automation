package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public ProductDetailsPage(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);	
		
	}
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement productsOption;
	
	@FindBy(xpath = "//div[@class=\"features_items\"]/child::div[contains(@class,'col-sm')]")
	List<WebElement> productsList;
	
	@FindBy(xpath = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]")
	WebElement viewProduct;
	
	@FindBy(xpath = "//div[contains(@class,'category-tab')]//child::div//child::a[normalize-space()='Write Your Review']")
	WebElement writeReviewTxt;
	
	@FindBy(xpath = "//h2[normalize-space()='Blue Top']")
	WebElement productName;
	
	@FindBy(xpath = "//span[normalize-space()='Rs. 500']")
	WebElement productPrice;
	
	@FindBy(xpath = "//h2[normalize-space()='Category']")
	WebElement category;
	
	@FindBy(xpath = "//div[@class='product-details']//p[2]")
	WebElement productAvailability;
	
	@FindBy(xpath = "//b[normalize-space()='Condition:']")
	WebElement productCondition;
	
	@FindBy(xpath = "//b[normalize-space()='Brand:']")
	WebElement productBrand;
	
	public void clickOnProductOption() {
		productsOption.click();
	}
	public boolean areAllProductsVisible() {
        return productsList.size() > 0;
    }
	
	public int getProductCount() {
		return productsList.size();
	}
	
	public void clickOnViewproduct() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		viewProduct.click();
	}
	
	public boolean isProductDetailsPageVisible() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.visibilityOf(writeReviewTxt)).isDisplayed();
	}
	
	public String getwriteReviewTxt() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", writeReviewTxt);
		return writeReviewTxt.getText();
	}
	
	public boolean isProductNameVisible() {
        return productName.isDisplayed();
    }

    public boolean isProductPriceVisible() {
        return productPrice.isDisplayed();
    }

    public boolean isCategoryVisible() {
        return category.isDisplayed();
    }

    public boolean isProductAvailabilityVisible() {
        return productAvailability.isDisplayed();
    }

    public boolean isProductConditionVisible() {
        return productCondition.isDisplayed();
    }

    public boolean isProductBrandVisible() {
        return productBrand.isDisplayed();
    }
	
	
}
