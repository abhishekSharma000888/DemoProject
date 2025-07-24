package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DemoQA {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1");

        List<WebElement> sampleHeading = driver.findElements(By.xpath("//h1[@id=\"sampleHeading\"]"));

        String actualText = sampleHeading.get(0).getText().toString();

        String expectedText = "This is a sample page";

        System.out.println("actualText"+ actualText);

        Assert.assertTrue(actualText.contains("sample"),"Expected message was not present!");
        Assert.assertEquals(actualText,expectedText,"The error message failed to match!");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.switchTo().frame("frame2");

        String actualTextTwo = sampleHeading.get(1).getText().toString();
        String expectedTextTwo = "This is a sample page";

        Assert.assertTrue(actualTextTwo.contains("This is a"), "The text message failed to match!");
        Assert.assertEquals(actualTextTwo,expectedTextTwo,"The error messages failed to match.");

        driver.quit();

    }
}
