package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DemoHeroku {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement frameLeft = driver.findElement(By.xpath("//*[contains(text(), 'LEFT')]"));

        String actualText = frameLeft.getText();

        Assert.assertTrue(actualText.contains("LEFT"), "The text mismatched!");

        driver.switchTo().defaultContent();
        driver.quit();
    }
}
