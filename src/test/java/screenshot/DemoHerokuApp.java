package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class DemoHerokuApp {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement textExample = driver.findElement(By.xpath("//*[contains(text(), 'This example demonstrates')]"));

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


        try {
            FileUtils.copyFile(screenshot,new File("./target/takesExamplePage.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        File textExampleScreenshot = textExample.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(textExampleScreenshot, new File("./target/takesExampleElement.png"));

        } catch(IOException e){
            e.printStackTrace();
        }

        driver.quit();
    }
}
