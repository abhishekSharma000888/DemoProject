package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoEbay {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.ebay.com/");

        WebElement search = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
        search.sendKeys("cars");

        // Wait until suggestions are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@role,'option')]//span")));

        // Capture all suggestions
        List<WebElement> autosuggested = driver.findElements(By.xpath("//li[contains(@role,'option')]//span"));

        System.out.println("Auto-suggestions shown:");
        for (WebElement e : autosuggested) {
            String text = e.getText().trim();
            if (!text.isEmpty()) {
                System.out.println(text);
            }
        }

         driver.quit();
    }
}
