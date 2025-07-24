package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DemoSamplePage {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1").getTitle();

        List<WebElement> readTexts = driver.findElements(By.xpath("//h1[@id=\"sampleHeading\"]"));

        String actualText = readTexts.get(0).getText();

        System.out.println("The actual text is: "+ actualText);

        Assert.assertTrue(actualText.contains("This is a sample page"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.quit();


    }
}
