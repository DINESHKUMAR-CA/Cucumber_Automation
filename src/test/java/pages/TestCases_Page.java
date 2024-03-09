package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCases_Page {
		
	WebDriver driver;
	WebDriverWait wait;
	
	public TestCases_Page(WebDriver IDriver) {
		driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]/child::li/a[normalize-space()='Test Cases']")
	WebElement testCasesOption;
	
	public void clcikOnTestCasesOption() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		testCasesOption.click();
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
}
