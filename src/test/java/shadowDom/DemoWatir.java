package shadowDom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoWatir {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        String url = "http://watir.com/examples/shadow_dom.html";

        driver.get(url);
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;


        WebElement searchBoxText = (WebElement) js.executeScript("return document.querySelector('#shadow_host')\" +\n" +
                "            \".shadowRoot.querySelector('#nested_shadow_host')\" +\n" +
                "            \".shadowRoot.querySelector('#text');\"\n" +
                "        );");

        js.executeScript("arguments[0].textContent = 'Hello from Selenium Shadow DOM';", searchBoxText);

        String updatedText = (String) js.executeScript("return arguments[0].textContent;", searchBoxText);

        System.out.println("Updated Text: " + updatedText);

        driver.quit();
    }
}

