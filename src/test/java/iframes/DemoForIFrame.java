package iframes;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoForIFrame {

    public static void main(String[] args) throws InterruptedException {

        // Setup Firefox Driver
        WebDriver driver = new FirefoxDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Open the URL
        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to the iframe
        driver.switchTo().frame("mce_0_ifr");

        // Locate the TinyMCE editor body
        WebElement editorBody = driver.findElement(By.id("tinymce"));

        // Click inside the editor to activate it
        editorBody.click();

        // Clear the existing text using CTRL + A and BACKSPACE
        editorBody.sendKeys(Keys.CONTROL + "a");
        editorBody.sendKeys(Keys.BACK_SPACE);

        // Type new text
        editorBody.sendKeys("This is the updated text.");

        // Wait to visually confirm the change (not recommended for real tests, use explicit waits instead)
        Thread.sleep(2000);

        // Switch back to the main page
        driver.switchTo().defaultContent();

        // Close the browser
        driver.quit();
    }
}
