package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Product_Brand_Page {
	

	WebDriver driver;
	WebDriverWait wait;

	public Product_Brand_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(05));
	}
	
	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Brands']")
	WebElement brands;

	@FindBy(xpath = "//a[@href='/brand_products/Babyhug']")
	WebElement babyHug;
	
	@FindBy(xpath = "//a[@href=\"/brand_products/Kookie Kids\"]")
	WebElement kookieKids;
	
	public void scrollToBrandsInCategory() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", brands);
		
	}
	
	public String clickOnBABYHUGUnderBrands() {
		
		babyHug.click();
		return driver.getTitle();
	}
	
	public void clickOnKOOKIEKIDSUnderBrands() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", brands);
		kookieKids.click();
		
	}
	
	public String getKOOKIEKIDSBrandPageTitle() {
		return driver.getTitle();
	}
}
