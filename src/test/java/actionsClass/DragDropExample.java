import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DragDropExample {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Switch to the iframe FIRST
        WebElement iframehandler = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframehandler);

        // THEN locate elements inside the iframe
        WebElement dragFrom = driver.findElement(By.id("draggable"));
        WebElement dragTo = driver.findElement(By.id("droppable"));

        // Perform drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragFrom, dragTo).build().perform();

        driver.quit();
    }
}
