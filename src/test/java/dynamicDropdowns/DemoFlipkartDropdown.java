package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoFlipkartDropdown {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement closeLoginPopup = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button._2KpZ6l._2doB4z")));
            closeLoginPopup.click();
        } catch (Exception e) {
            System.out.println("Login popup not found, continuing...");
        }



        WebElement searchBox = driver.findElement(By.xpath("//input[@class=\"Pke_EE\"]"));
        searchBox.sendKeys("samsung");

        List<WebElement> searchAutoSuggestions = driver.findElements(By.xpath("//*[contains(@class,'_3D0G')]"));

        for(WebElement e: searchAutoSuggestions){

            System.out.println(e.getText());
        }

        driver.quit();

    }
}
