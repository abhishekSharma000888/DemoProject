package cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoFlipkart {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='Pke_EE']")));

        searchTab.sendKeys("samsung");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));

        svgElements.get(0).click();

        driver.quit();
    }
}
