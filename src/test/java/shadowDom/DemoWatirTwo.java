package shadowDom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoWatirTwo {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://watir.com/examples/shadow_dom.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement checkbox = (WebElement) js.executeScript("return document.querySelector(\"div[id='shadow_host']\").shadowRoot.querySelector(\"div[id='nested_shadow_host']\").shadowRoot.querySelector(\"input[type='checkbox']\");");


        js.executeScript("arguments[0].click();", checkbox);

        System.out.println("Checkbox was clicked successfully.");

        driver.quit();
    }
}
