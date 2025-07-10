package dynamicWebElements;

import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoSwagLabs {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

        driver.manage().window().maximize();


        WebElement username = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"login-button\"]"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        loginButton.sendKeys(Keys.ENTER);


        //Select the product and open it!!!

        WebDriverWait waitForProduct = new WebDriverWait(driver,Duration.ofSeconds(5));

        WebElement product = waitForProduct.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@data-test=\"add-to-cart-sauce-labs-backpack\"]")));

        product.sendKeys(Keys.ENTER);

        WebElement shoppingCart = driver.findElement(By.xpath("//a[@data-test=\"shopping-cart-link\"]"));

        shoppingCart.click();



        driver.quit();

    }
}
