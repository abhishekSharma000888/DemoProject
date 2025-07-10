package svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickOnTheMapOfIndia {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.mapchart.net/india.html");
        driver.manage().window().maximize();

        //we need to verify that Tripura is on the map of India and we will click and verify.

        //*[@id="Tripura"]
        WebElement state = driver.findElement(By.xpath("//*[@id=\"Tripura\"]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(state).click().build().perform();

        driver.quit();
    }

}
