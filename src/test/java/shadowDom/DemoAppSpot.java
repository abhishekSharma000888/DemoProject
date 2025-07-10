package shadowDom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoAppSpot {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement searchBox = (WebElement) js.executeScript(
                "return document.querySelector('book-app')" +
                        ".shadowRoot.querySelector('app-header')" +
                        ".querySelector('book-input-decorator')" +
                        ".shadowRoot.querySelector('input#input')"
        );

        // Correct way to enter text
        js.executeScript("arguments[0].value='iphone';", searchBox);

        // Optional: trigger input event if needed
        js.executeScript("arguments[0].dispatchEvent(new Event('input', { bubbles: true }));", searchBox);

        // Delay to see the result (optional)
        try { Thread.sleep(3000); } catch (InterruptedException e) {}

        driver.quit();
    }
}
