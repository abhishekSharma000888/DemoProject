package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoMakeMyTrip {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click somewhere on the page to remove initial login/modal overlay
        try {
            WebElement body = driver.findElement(By.tagName("body"));
            body.click();
        } catch (Exception ignored) {}

        // Close the login pop-up if visible
        try {
            WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not displayed.");
        }

        // Click on the 'From' input box
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fromCity']")));
        searchBox.click();

        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']")));
        inputField.sendKeys("kenya");

        // Wait for the dynamic dropdown to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        List<WebElement> searchOptionsList = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        String fromCity = "Nairobi";

        for (WebElement option : searchOptionsList) {
            String text = option.getText();
            System.out.println(text);

            if (text.contains(fromCity)) {
                option.click();
                break;
            }
        }

        driver.quit();
    }
}
