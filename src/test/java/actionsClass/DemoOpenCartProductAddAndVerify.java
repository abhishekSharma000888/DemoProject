package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DemoOpenCartProductAddAndVerify {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

        WebElement compoenents = driver.findElement(By.xpath("//*[text()='Components']"));

        WebElement monitors = driver.findElement(By.xpath("//*[text()='Monitors (2)']"));


        Actions actions = new Actions(driver);

        actions.moveToElement(compoenents).moveToElement(monitors)
                .click().build().perform();


        //verify the product we want to add exists or not

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        WebElement monitor = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[text()='Samsung SyncMaster 941BW']")));

        String expectedText = "Samsung SyncMaster 941BW";
        String actualText = monitor.getText();

        System.out.println(actualText + "actualText");

        Assert.assertEquals(actualText,expectedText,"The text failed to match!");

        driver.quit();


    }
}
