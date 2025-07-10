package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoTheInternetHerokuapp {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://the-internet.herokuapp.com/iframe");

        WebElement alertButton = driver.findElement(By.cssSelector("div[aria-label=\"Close\"]"));

        alertButton.click();

        driver.switchTo().frame("[id=\"tinymce\"]");

        driver.quit();
    }
}
