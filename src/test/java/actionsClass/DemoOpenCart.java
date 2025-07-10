package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DemoOpenCart {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://awesomeqa.com/ui/");

        WebElement desktops = driver.findElement(By.xpath("//*[text()='Desktops']"));
        WebElement mac = driver.findElement(By.xpath("//*[text()='Mac (1)']"));

        Actions actions = new Actions(driver);

        actions.moveToElement(desktops).moveToElement(mac)
                .click().build().perform();



        //Verifying we are landing on iMac page

        WebElement iMac = driver.findElement(By.xpath("//*[text()='iMac']"));

        String actualText = iMac.getText();
        String expectedText = "iMac";

        Assert.assertEquals(actualText,expectedText,"The text doesn't match");

        driver.quit();

    }
}
