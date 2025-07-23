package windowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class DemoTabSwitchingAndVerifyingText {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/browser-windows");

        String parentWindow = driver.getWindowHandle();

        WebElement windowMessageButton = driver.findElement(By.id("messageWindowButton"));
        windowMessageButton.click();

        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> iterator = allWindows.iterator();

        while(iterator.hasNext()){
            String childWindow = iterator.next();

            if (!childWindow.equals(parentWindow)) {
                driver.switchTo().window(childWindow);

                // For demo purpose, just print title or URL
                System.out.println("Switched to child window.");
                System.out.println("Title: " + driver.getTitle());
                System.out.println("URL: " + driver.getCurrentUrl());

                driver.close(); // close child window
            }
        }

        driver.switchTo().window(parentWindow);
        driver.quit();

    }
}
