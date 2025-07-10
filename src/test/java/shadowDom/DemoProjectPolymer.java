package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoProjectPolymer {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://selectorshub.com/xpath-practice-page/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        // Correct WebDriverWait usage
        WebElement div_to_scroll = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='userName']")));

        // Scroll into view using JavaScript
        js.executeScript("arguments[0].scrollIntoView(true);", div_to_scroll);

        // document.querySelector("div#userName").shadowRoot.querySelector("div#app2").shadowRoot.querySelector("input#pizza")

        WebElement inputboxPizza = (WebElement) js.executeScript("return document.querySelector(\"div#userName\").shadowRoot.querySelector(\"div#app2\").shadowRoot.querySelector(\"input#pizza\");");

        inputboxPizza.sendKeys("farmhouse");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.quit();
    }
}
