package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Category_Page {

	WebDriver driver;

	public Product_Category_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Category']")
	WebElement categoryText;

	@FindBy(xpath = "//div[@class=\"container\"]//a[normalize-space()='Women']")
	WebElement womenText;

	@FindBy(xpath = "//div[@class=\"container\"]//div[@id=\"Women\"]//a[normalize-space()='Saree']")
	WebElement women_Saree;

	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Women - Saree Products']")
	WebElement sareeProducts;

	@FindBy(xpath = "//div[@class=\"container\"]//a[normalize-space()='Men']")
	WebElement menText;

	@FindBy(xpath = "//div[@class=\"container\"]//div[@id=\"Men\"]//a[normalize-space()='Tshirts']")
	WebElement men_Tshirt;

	@FindBy(xpath = "//div[@class=\"container\"]//h2[normalize-space()='Men - Tshirts Products']")
	WebElement TshirtProducts;

	public void scrollToCategorysection() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", categoryText);
	}

	public void clickOnWomenCategory() {

		womenText.click();
		women_Saree.click();

	}

	public String getSareeProductsText() {

		return sareeProducts.getText();
	}

	public void clickOnMenCategory() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", categoryText);

		menText.click();
		men_Tshirt.click();
	}

	public String getMenTshirtProductsText() {

		return TshirtProducts.getText();
	}

}
