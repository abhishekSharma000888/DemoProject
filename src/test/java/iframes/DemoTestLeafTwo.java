package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DemoTestLeafTwo {
    public static void main(String[] args) {


        String url = "https://www.leafground.com/frame.xhtml";

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);

        driver.switchTo().frame(2).switchTo().frame("frame2");

        WebElement clickMeTwo = driver.findElement(By.cssSelector("[id=\"Click\"]"));

        clickMeTwo.click();

        String expectedMessageTwo = "Hurray! you Clicked Me.";
        String actualMessageTwo = clickMeTwo.getText();

        Assert.assertEquals(actualMessageTwo,expectedMessageTwo,"The messages mismatched");

        driver.quit();
    }
}
