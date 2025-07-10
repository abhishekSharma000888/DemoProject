import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchForSpecificMap {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amcharts.com/svg-maps/");

        // Wait for page load
        Thread.sleep(2000); // You can later replace this with explicit wait

        // Click on Asia map
        WebElement countryIndia = driver.findElement(By.xpath("//a[@title=\"India\"]"));

        countryIndia.click();

        driver.quit();
    }
}
