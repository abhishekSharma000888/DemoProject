package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class DemoSeleniumBase {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://seleniumbase.io/demo_page");
        driver.manage().window().maximize();

        WebElement inputOne = driver.findElement(By.xpath("//*[@id=\"myTextInput\"]"));
        inputOne.sendKeys("This is the input text.");

        //Full window screenshot

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("./target/page.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //screenshot of an element

        File elementScreenshot = inputOne.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(elementScreenshot, new File("./target/element.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();

    }
}
