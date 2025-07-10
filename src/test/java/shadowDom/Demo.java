package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) {

        /*
        Shadow DOM is a web standard that allows web components to encapsulate functionality and styling
        within a boundary. Selenium cannot directly access Shadow DOM elements using regular locators.
        */

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Shadow DOM path to the pizza input box
        WebElement inputboxPizza = (WebElement) js.executeScript(
                "return document.querySelector(\"div#userName\").shadowRoot" +
                        ".querySelector(\"div#app2\").shadowRoot" +
                        ".querySelector(\"input#pizza\");"
        );

        inputboxPizza.sendKeys("The farmhouse pizza");

        // Optional: Wait to visually confirm (not best practice, but okay for demo)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement userName = (WebElement) js.executeScript("return document.querySelector(\"div#userName\")" +
                ".shadowRoot.querySelector(\"input#kils\"):");

        userName.sendKeys("demo user");

        driver.quit();
    }
}
