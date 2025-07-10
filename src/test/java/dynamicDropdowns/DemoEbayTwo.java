package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoEbayTwo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        WebElement searchBox = driver.findElement(By.xpath("//input[@title='Search']"));
        searchBox.sendKeys("cars");

        List<WebElement> searchBoxOptions = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@id='ebay-autocomplete']/li"))
        );

        String targetProduct = "car seat";
        boolean found = false;

        for (WebElement e : searchBoxOptions) {
            String currentProduct = e.getText();
            if (currentProduct.equalsIgnoreCase(targetProduct)) {
                e.click();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Product not found in suggestions!");
        }

        driver.quit();
    }
}
