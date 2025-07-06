package shadowDom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AppspotDemo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://books-pwakit.appspot.com/");

            JavascriptExecutor js = (JavascriptExecutor) driver;

            // Locate the shadow DOM input element
            WebElement searchBox = (WebElement) js.executeScript(
                    "return document.querySelector('book-app')" +
                            ".shadowRoot.querySelector('app-header app-toolbar book-input-decorator')" +
                            ".shadowRoot.querySelector('input');"
            );

            // Set the input value and fire the input event
            js.executeScript(
                    "arguments[0].value='Phone';" +
                            "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));",
                    searchBox
            );

            // Pause for a few seconds to visually verify the text input
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure the browser always closes
            driver.quit();
        }
    }
}
