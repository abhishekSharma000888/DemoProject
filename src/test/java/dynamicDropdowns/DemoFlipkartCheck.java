package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoFlipkartCheck {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com/");

        WebDriverWait randomWait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement searchBar = randomWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"q\"]")));

        searchBar.sendKeys("Macbook");

        searchBar.sendKeys(Keys.ENTER);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();


    }
}
