package iframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TestLeafDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.leafground.com/frame.xhtml");

        driver.manage().window().maximize();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");
        WebElement button = driver.findElement(By.xpath("//*[@id=\"Click\"]"));
        button.click();

        String expectedText = "Hurray! you Clicked Me.";
        String actualText = button.getText();

        System.out.println("actualText: " + actualText);

        Assert.assertEquals(actualText,expectedText,"The text mismatched!");

            driver.quit();

    }
}
