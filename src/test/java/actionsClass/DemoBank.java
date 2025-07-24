package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DemoBank {

    public static void main(String[] args) {

        //dragging bank and dropping it to Debit side.

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demo.guru99.com/test/drag_drop.html");

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        List<WebElement> draggableElements = driver.findElements(By.xpath("//a[@class=\"button button-orange\"]"));

        WebElement draggableFirstElement = draggableElements.get(4);

        WebElement droppable = driver.findElement(By.xpath("//*[@id=\"bank\"]"));

        actions.dragAndDrop(draggableFirstElement,droppable).build().perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        //dragging Sales and dropping it to Account Section in Credit Side

        driver.switchTo().defaultContent();

        WebElement draggableSecondElement = draggableElements.get(5);

        List<WebElement> droppabbleList = driver.findElements(By.xpath("//li[@class=\"placeholder\"]"));

        WebElement droppbaleSecondElement = droppabbleList.get(2);

        actions.dragAndDrop(droppbaleSecondElement,draggableSecondElement);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        driver.quit();

    }
}
