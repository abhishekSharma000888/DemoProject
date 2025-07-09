package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DemoFlipkart {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");

        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));

        searchBox.sendKeys("Macbook");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> suggestions = driver.findElements(By.xpath("//*[contains(@class,'_3D0G9a')]"));

        for(WebElement e: suggestions) {

            System.out.println(e.getText());
        }
        driver.quit();
    }
}
