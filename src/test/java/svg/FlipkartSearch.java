package svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.model.FrameId;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class FlipkartSearch {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//*[@name=\"q\"]")).sendKeys("macmini");

        List<WebElement> svgElements = driver.findElements(By.xpath("//*[name()='svg']"));


        svgElements.get(0).click();

        driver.quit();

    }
}
