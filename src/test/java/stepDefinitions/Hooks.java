package stepDefinitions;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import pages.LoginPage;
import pages.Register_User_Page;

public class Hooks {
	
    public static WebDriver driver;
    Register_User_Page signUpPage;
    LoginPage loginPage;

    @Given("The user launches the browser and verifying the homepage")
   
    @Before
    public void the_user_launches_the_browser() {
    	
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.ads", 2);
        options.setExperimentalOption("prefs", prefs);
        options.addExtensions(new File("src/test/resources/Extensions/AdBlocker.crx"));

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        signUpPage = new Register_User_Page(driver);
        loginPage = new LoginPage(driver);

        driver.navigate().to("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        String actualTitle = driver.getTitle();
        Assert.assertEquals("Automation Exercise", actualTitle, "Sorry, The page title does not match"); 
        System.out.println("We are on the home page, I confirm this by the homepage Title: "+actualTitle);
    }
    
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}