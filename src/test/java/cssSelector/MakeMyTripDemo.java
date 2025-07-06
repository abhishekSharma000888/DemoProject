package cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MakeMyTripDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/?cc=in&redirectedBy=gl");


        WebElement closePup = driver.findElement(By.cssSelector("span[class=\"commonModal__close\"]"));

        closePup.click();

        WebElement searchButton = driver.findElement(By.cssSelector("a[class=\"primaryBtn font24 latoBold widgetSearchBtn \"]"));

        searchButton.click();

        driver.quit();

    }
}
