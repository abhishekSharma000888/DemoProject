package svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class DemoFlipkart {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.flipkart.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        searchBox.sendKeys("macbook");

        List<WebElement> svgCounts = driver.findElements(By.xpath("//*[name()='svg']"));

        svgCounts.get(0).click();

        List<WebElement> macProducts = driver.findElements(By.xpath("//*[@class=\"KzDlHZ\"]"));

        macProducts.get(2).click();

        driver.quit();
    }
}
