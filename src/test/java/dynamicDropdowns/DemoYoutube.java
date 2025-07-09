package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoYoutube {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.youtube.com/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("cars");

        // Explicit wait for the suggestions to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ytd-searchbox-suggestions")));

        // Get the suggestions text elements
        List<WebElement> autoSuggested = driver.findElements(By.xpath("//ytd-searchbox-suggestion//span"));

        // Print suggestions
        for (WebElement e : autoSuggested) {
            System.out.println(e.getText());
        }

        driver.quit();
    }
}
