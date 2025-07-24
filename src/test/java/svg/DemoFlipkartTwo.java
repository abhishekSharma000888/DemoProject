package svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DemoFlipkartTwo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        WebElement searchBar = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        searchBar.sendKeys("Samsung");

        //use this to handle all kinds of SVG elements
        List<WebElement> svgElements = driver.findElements(By.xpath("//*[local-name()='svg']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        svgElements.get(0).click();
        driver.quit();

    }
}
