package dynamicWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DemoQa {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/dynamic-properties");

        driver.manage().window().maximize();

        WebDriverWait waitForTheElement = new WebDriverWait(driver, Duration.ofSeconds(7));

        WebElement randomIdText = waitForTheElement.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(text(),'random Id')]")));

        String expectedText = "This text has random Id";
        String actualText = randomIdText.getText();

        Assert.assertEquals(actualText,expectedText,"The message failed to match!");

        driver.quit();
    }
}
