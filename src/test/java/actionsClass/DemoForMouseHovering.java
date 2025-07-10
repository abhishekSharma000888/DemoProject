package actionsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoForMouseHovering {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://omayo.blogspot.com/");

        Actions actions = new Actions(driver);


        WebElement blogsMenu= driver.findElement(By.xpath("//*[@id=\"blogsmenu\"]"));
        WebElement seleniumByArunOption = driver.findElement(By.xpath("//*[text()='SeleniumOneByArun']"));

        actions.moveToElement(blogsMenu);

        actions.moveToElement(seleniumByArunOption).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL)
                .build().perform();

        driver.quit();

    }
}
