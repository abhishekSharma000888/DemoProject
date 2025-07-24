package screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DemoFlipkart {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.flipkart.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close login popup if present
        try {
            WebElement closeBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'✕')]")));
            closeBtn.click();
        } catch (Exception e) {
            System.out.println("Login popup not found, continuing...");
        }

        // Enter search term
        WebElement searchTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='Pke_EE']")));
        searchTab.sendKeys("Samsung");

        // Wait for dropdown to appear and click on target item
        List<WebElement> dropdownOptions = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[contains(@class,'_1sFryS')]/li")));

        String targetName = "samsung washing machine";
        boolean clicked = false;

        for (WebElement e : dropdownOptions) {
            String elementName = e.getText().trim().toLowerCase();

            if (elementName.equals(targetName)) {
                e.click();
                clicked = true;
                System.out.println("Clicked on: " + targetName);
                break;
            }
        }

        if (!clicked) {
            System.out.println("❌ The element '" + targetName + "' was not found in dropdown.");
        }

        // Wait for product results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div._1AtVbE")));  // product container

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenshot, new File("/Users/abhisheksharma/Downloads/SDETProjects/DemoProject/src/test/java/screenshotsFolder/screenshotOne.png"));
            System.out.println("✅ Screenshot taken and saved.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}
