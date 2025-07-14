package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class SampleScreenshot {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://omayo.blogspot.com/");

        try {
            // Take screenshot
            File srcScreenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Define destination
            String destinationPath = System.getProperty("user.dir") + "/screenshotsFolder/HomePage.png";
            File destinationFile = new File(destinationPath);

            // Create folder if it doesn't exist
            destinationFile.getParentFile().mkdirs();

            // Copy screenshot to destination
            FileUtils.copyFile(srcScreenshotFile, destinationFile);

            System.out.println("Screenshot saved at: " + destinationPath);
        } catch (IOException e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
