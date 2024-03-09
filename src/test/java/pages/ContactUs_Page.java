package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUs_Page {
	
	WebDriver driver;
	
	public ContactUs_Page(WebDriver IDriver) {
		
		driver = IDriver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()='Contact us']")
	WebElement contactUs;
	
	@FindBy(xpath = "//h2[normalize-space()='Get In Touch']")
	WebElement getInTouchTxt;
	
	@FindBy(name ="name")
	WebElement nameField;
	
	@FindBy(name ="email")
	WebElement emailField;
	
	@FindBy(xpath ="//input[@data-qa=\"subject\"]")
	WebElement subjectField;
	
	@FindBy(id = "message")
	WebElement messageField;
	
	@FindBy(name = "upload_file")
	WebElement uploadBtn;
	
	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement submitBtn;
	
	@FindBy(xpath = "//div[@class='status alert alert-success']")
	WebElement successMsg;
	
	@FindBy(xpath = "//span[normalize-space()='Home']")
	WebElement homeBtn;
	
	@FindBy(xpath = "//ul[@class=\"nav navbar-nav\"]/li/a[normalize-space()='Home']")
	WebElement homeOption;
	
	public void clickOnContactUsOption() {
		contactUs.click();
	}
	
	public String getGetInTouchTxt() {
		return getInTouchTxt.getText();
	}
	
	public void enterNameAndEmail(String userName, String email) {
		nameField.sendKeys(userName);
		emailField.sendKeys(email);
		
	}
	
	public void enterSubjectAndMessage(String subject, String message) {
		subjectField.sendKeys(subject);
		messageField.sendKeys(message);
	}
	
	public void clickOnUploadBtn() {
		
		String filePath = System.getProperty("user.dir")+ "\\src\\test\\resources\\File\\Programm.pdf";
		File file = new File(filePath);
		
		if(file.exists()) {
			uploadBtn.sendKeys(filePath);
		} else {
			System.out.println("File Not Found: "+ filePath);
		}
	}
	
	public void clickOnSubmitBtn() {
		submitBtn.click();
	}
	
	public void handleSimplePopUp() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
		} 
		catch (Exception e) {
			System.out.println("Hmm....No pop-up is appeared");
		}
	}
	
	public String getSuccessMsg() {
		return successMsg.getText();
	}
	
	public void clickOnHomeButton() {
		homeBtn.click();
	}
	
	public String getHomeOptiontext() {
		return homeOption.getText();
	}
	
}
