package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class DemoTestLeafTwo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.leafground.com/alert.xhtml");
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


        List<WebElement> alerts = driver.findElements(By.xpath("//*[@class=\"ui-button-text ui-c\"]"));

       //switching to the first alert
       alerts.get(0).click();
       Alert alertOne = driver.switchTo().alert();
       String actualText = alertOne.getText();
        System.out.println("ActualText: "+ actualText);
        Assert.assertTrue(actualText.contains("I am simple alert."), "The message mismatched");
        alertOne.accept();



        driver.switchTo().defaultContent();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //switch to the second alert

        alerts.get(1).click();
        Alert alertTwo = driver.switchTo().alert();
        String actualTextTwo = alertTwo.getText();
        System.out.println("Actual Text: "+ actualTextTwo);
        Assert.assertTrue(actualTextTwo.contains("Did you"), "The message mismatched");
        alertTwo.accept();

        driver.switchTo().defaultContent();
        driver.quit();

    }
}
