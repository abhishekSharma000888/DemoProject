package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DemoForDocsUsingIFrames {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://docs.oracle.com/javase/8/docs/api/");

        //selected Description by going to the frame
        //switch to iframe
        driver.switchTo().frame("classFrame");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        WebElement description = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//a[text()='Description']")));

        description.click();

        WebElement descriptionText = driver.findElement(By.xpath("/html/body/div[7]/div"));

        String expectedText = "This document is the API specification for the Java™ Platform, Standard Edition.";
        String actualText = descriptionText.getText();

        Assert.assertEquals(actualText,expectedText, "the text failed to match!");

        driver.quit();

    }
}
