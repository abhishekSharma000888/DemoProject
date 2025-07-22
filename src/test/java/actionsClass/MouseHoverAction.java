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

public class MouseHoverAction {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        driver.manage().window().maximize();
        Actions actions = new Actions(driver);

        List<WebElement> draggableElements = driver.findElements(By.xpath("//a[@class=\"button button-orange\"]"));

        WebElement hoverFrom = draggableElements.get(4);
        WebElement hoverTo = driver.findElement(By.xpath("//*[@id=\"bank\"]"));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        wait.until(ExpectedConditions.elementToBeClickable(hoverFrom));

        actions.moveToElement(hoverFrom)
                .clickAndHold()
                .moveToElement(hoverTo)
                .release()
                .build()
                .perform();


        driver.quit();


    }
}
