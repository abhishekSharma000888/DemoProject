package dynamicWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoFacebook {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");

        driver.manage().window().maximize();

        WebElement userEmail = driver.findElement(By.xpath("//input[@name=\"email\"]"));
        userEmail.sendKeys("demoUSer");
        WebElement password = driver.findElement(By.xpath("//input[@data-testid=\"royal-pass\"]"));
        password.sendKeys("demo_password");

        WebElement signUpButton = driver.findElement(By.xpath("//a[contains(@id, 'u_0_0_')]"));

        signUpButton.sendKeys(Keys.ENTER);

        driver.quit();
    }
}
