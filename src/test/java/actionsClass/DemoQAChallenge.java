package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoQAChallenge {

    public static void main(String[] args) {

        /*
        Scenario:
          You are automating a website like https://demoqa.com/menu, which contains a multi-level dropdown menu.
          You need to hover over "Main Item 2" → "SUB SUB LIST »" → "Sub Sub Item 2" and then click on "Sub Sub Item 2".
         */

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/menu");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


        // Create wait and actions
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // Locate elements
        WebElement mainItemTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Main Item 2']")));
        WebElement subSubList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='SUB SUB LIST »']")));
        WebElement subSubItem2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Sub Sub Item 2']")));


        actions.moveToElement(mainItemTwo)
                .moveToElement(subSubList)
                .moveToElement(subSubItem2)
                .click()
                .build()
                .perform();


        System.out.println("Successfully clicked on Sub Sub Item 2");

        driver.quit();

    }
}
