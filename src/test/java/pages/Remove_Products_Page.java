package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Remove_Products_Page {

    WebDriver driver;
    Product_Cart_Page productCartPage;

    public Remove_Products_Page(WebDriver IDriver) {
        driver = IDriver;
        PageFactory.initElements(driver, this);
        productCartPage = new Product_Cart_Page(driver);
    }

    @FindBy(xpath = "//tbody//tr")
    List<WebElement> cartItems;

    private void scrollToCartItem() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productCartPage.cartItem);
    }

    public void verifyAndRemoveCartItems() {
        scrollToCartItem();
        int initialProductCount = cartItems.size();
        List<String> productNames = new ArrayList<>();

        System.out.println("Before removing any product, we had " + initialProductCount + " products in the cart.");
        System.out.println("============= Product Details before removal: =============");

        for (WebElement cartItem : cartItems) {
            String productNameText = cartItem.findElement(By.xpath(".//td[@class='cart_description']//a")).getText();
            productNames.add(productNameText);
            String totalPriceText = cartItem.findElement(By.xpath(".//td[@class='cart_total']")).getText();
            String quantityText = cartItem.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();

            System.out.println("Product Name: " + productNameText);
            System.out.println("Quantity: " + quantityText);
            System.out.println("Total Price: " + totalPriceText);
            System.out.println("----------------------------------");
        }

        String removedProductName = "";
        for (WebElement cartItem : cartItems) {
            String productNameText = cartItem.findElement(By.xpath(".//td[@class='cart_description']//a")).getText();
            if (productNameText.equals("Blue Top")) {
                removeProduct(cartItem);
                removedProductName = productNameText;
                break;
            }
        }

        // Waiting for the cart to be updated after removal
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cartItems = driver.findElements(By.xpath("//tbody//tr")); // Update the cartItems list
        int updatedProductCount = cartItems.size();

        System.out.println("After removing \"" + removedProductName + "\" product, we have " + updatedProductCount + " products in the cart.");
        System.out.println("============= Product Details after removal: =============");

        for (String productName : productNames) {
            if (!productName.equals("Blue Top")) {
                WebElement cartItem = driver.findElement(By.xpath(".//td[@class='cart_description']//a[text()='" + productName + "']//ancestor::tr"));
                
                String totalPriceText = cartItem.findElement(By.xpath(".//td[@class='cart_total']")).getText();
                String quantityText = cartItem.findElement(By.xpath(".//td[@class='cart_quantity']/button")).getText();

                System.out.println("Product Name: " + productName);
                System.out.println("Quantity: " + quantityText);
                System.out.println("Total Price: " + totalPriceText);
                System.out.println("-----------------------------------------------");
            }
        }
    }



    private void removeProduct(WebElement cartItem) {
        cartItem.findElement(By.xpath("//td[@class='cart_delete']//i")).click();
    }
}