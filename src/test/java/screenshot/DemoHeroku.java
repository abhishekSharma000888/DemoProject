package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DemoHeroku {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");
        driver.manage().window().maximize();

        List<WebElement> clickButtons = driver.findElements(By.xpath("//button[.=\"Click me\"]"));

        clickButtons.get(0).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        try{
            Alert alert= driver.switchTo().alert();
            alert.accept();
        } catch(NoAlertPresentException e){
            e.printStackTrace();
        }

        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenshot, new File("/Users/abhisheksharma/Downloads/SDETProjects/DemoProject/src/test/java/screenshotsFolder/firstAlert.png"));
            System.out.println("Screenshot saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        driver.quit();
    }
}
