package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class DynamicDropdownMakeMyTrip {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();

        WebElement popup = driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
        popup.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement hotelButton = driver.findElement(By.xpath("//a[@href=\"https://www.makemytrip.com/hotels/\"]/span/span"));


        Actions actions = new Actions(driver);
        actions.moveToElement(hotelButton).click().build().perform();

        WebElement search = driver.findElement(By.xpath("//input[@title=\"Where do you want to stay?\"]"));

        search.sendKeys("Delhi");

        WebElement aerocitySearch = driver.findElement(By.xpath("//div[@class=\"makeFlex top left\"]/p"));

        aerocitySearch.click();

        driver.quit();
    }
}
