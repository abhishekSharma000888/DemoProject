package cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoSauce {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.cssSelector("input[id='user-name']"));
                WebElement password = driver.findElement(By.cssSelector("input[id='password']"));

                username.sendKeys("standard_user");
                password.sendKeys("secret_sauce");

                WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));

                loginButton.click();

                driver.quit();
    }
}
