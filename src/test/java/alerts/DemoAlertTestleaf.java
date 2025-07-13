package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.List;

public class DemoAlertTestleaf {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.leafground.com/alert.xhtml");

        WebElement simpleAlertButton = driver.findElement(By.xpath("(//span[text()='Show'])[1]"));

       simpleAlertButton.click();

       Alert alert = driver.switchTo().alert();

       String expectedText = "I am simple alert.";
       String actualText = alert.getText();

        Assert.assertEquals(actualText,expectedText,"The text mismatched!");

       driver.quit();
    }
}
