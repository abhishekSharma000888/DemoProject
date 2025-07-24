package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class DemoAmazon {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Laptops");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        List<WebElement> optionsList = driver.findElements(By.xpath("//div[contains(@class, 's-suggestion')]"));

        for(WebElement e : optionsList) {
            String optionText = e.getText();
            System.out.println("Found: " + optionText);

            if(optionText.equalsIgnoreCase("laptops for students")) {
                Actions actions = new Actions(driver);
                actions.moveToElement(e).click().build().perform(); // ✅ Fixed here
                break;
            }
        }

        // Optionally wait to verify or add assertion

        driver.quit();
    }
}
