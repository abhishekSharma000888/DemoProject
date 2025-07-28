package swagLabs;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Login {

    public static void main(String[] args) {

        //Login functionality
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.xpath("//input[@placeholder=\"Username\"]"));
        userName.sendKeys("standard_user");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder=\"Password\"]")));
        password.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("/Users/abhisheksharma/Downloads/SDETProjects/DemoProject/src/test/java/screenshotsFolder/ScreenshotTwo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Logout functionality

        List<WebElement> buttonOptions = driver.findElements(By.xpath("//button[@type=\"button\"]"));

        buttonOptions.get(0).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[.=\"Logout\"]"))).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        File screenshotTwo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshotTwo, new File("/Users/abhisheksharma/Downloads/SDETProjects/DemoProject/src/test/java/screenshotsFolder/LogoutScreenshot"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
