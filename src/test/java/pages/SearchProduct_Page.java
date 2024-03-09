package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct_Page {

	WebDriver driver;

	public SearchProduct_Page(WebDriver IDriver) {

		driver = IDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_product")
	WebElement searchBox;

	@FindBy(id = "submit_search")
	WebElement searchicon;

	@FindBy(xpath = "//div[@class='productinfo text-center']//p[contains(text(),'Cotton Mull Embroidered Dress')]")
	WebElement searchedProductName;
	
	@FindBy(xpath = "//div[@class='productinfo text-center']//p[contains(text(),'T-Shirt')]")
	List<WebElement> searchedProductNames;

	public void enterProductNameOnSearchBox(String productName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchBox);
		searchBox.clear();
		searchBox.sendKeys(productName);
	}

	public void clickOnSearchIcon() {
		searchicon.click();
	}

	public String getSearchedProductName() {
		return searchedProductName.getText();
	}
	
	public List<String> getAllSearchedProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement productNameElement : searchedProductNames) {
            productNames.add(productNameElement.getText().trim());
        }
        return productNames;
    }
}
