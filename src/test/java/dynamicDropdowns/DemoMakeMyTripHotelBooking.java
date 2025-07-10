package dynamicDropdowns;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoMakeMyTripHotelBooking {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        driver.get("https://www.makemytrip.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Close the login pop-up if visible
        try {
            WebElement closePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));
            closePopup.click();
        } catch (Exception e) {
            System.out.println("Popup not displayed.");
        }

        // Click anywhere to defocus any modal or overlay
        try {
            WebElement body = driver.findElement(By.tagName("body"));
            body.click();
        } catch (Exception ignored) {}

        // Click on the Hotels tab
        WebElement hotelsButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-cy='menu_Hotels']")));
        hotelsButton.click();

        // Click on the city search field
        WebElement citySearchBox = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter city/ Hotel/ Area/ Building']")));
        citySearchBox.click();

        // Type the city name
        String cityToSearch = "Goa";
        citySearchBox.sendKeys(cityToSearch);

        // Wait for suggestions to appear
        List<WebElement> options = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.xpath("//ul[@role='listbox']/li")));

        for (WebElement option : options) {
            String text = option.getText();
            System.out.println("Dropdown option: " + text);

            if (text.contains(cityToSearch)) {
                option.click();
                break;
            }
        }

        // Continue with check-in/check-out selection if needed...

        // Close the browser
        driver.quit();
    }
}
