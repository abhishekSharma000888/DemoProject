package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoDoubleClickGuru99 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement alertBox = driver.findElement(By.xpath("//*[contains(text(),'Double-Click Me To See ')]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(alertBox).doubleClick().build().perform();

        driver.quit();
    }
}
