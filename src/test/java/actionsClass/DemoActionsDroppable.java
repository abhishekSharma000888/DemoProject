package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoActionsDroppable {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable,droppable).build().perform();
        driver.quit();
    }
}
