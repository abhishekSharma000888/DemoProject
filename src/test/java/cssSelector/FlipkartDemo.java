package cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FlipkartDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com/");

        // Close the login popup
        WebDriverWait popupWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement closeButton = popupWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2doB4z")));
        closeButton.click();

        // Wait for search input to be visible
        WebDriverWait searchProductWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchProduct = searchProductWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='q']")));

        searchProduct.sendKeys("Macmini");

        WebElement clickButton = driver.findElement(By.cssSelector("button.L0Z3Pu"));
        clickButton.click();

        // Wait for search results to load
        WebDriverWait resultsWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        resultsWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1YokD2._3Mn1Gg")));

        // Find all Apple products based on a class or attribute that matches the search results
        List<WebElement> appleProducts = driver.findElements(By.cssSelector("div._4rR01T")); // This class usually contains product titles

        boolean allProductsAreApple = true;

        for (WebElement product : appleProducts) {
            String productName = product.getText();
            System.out.println("Found Product: " + productName);

            if (!productName.toLowerCase().contains("apple")) {
                allProductsAreApple = false;
                System.out.println("Non-Apple Product Found: " + productName);
                break;
            }
        }

        Assert.assertTrue(allProductsAreApple, "Test Failed: Some products are not Apple!");

        driver.quit();
    }
}
