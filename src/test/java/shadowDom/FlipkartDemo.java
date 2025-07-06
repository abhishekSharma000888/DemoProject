package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FlipkartDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();

        Actions action = new Actions(driver);

        WebElement search = driver.findElement(By.xpath("//input[@name=\"q\"]"));

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));

                svgElements.get(0).click();
                driver.quit();
    }
}