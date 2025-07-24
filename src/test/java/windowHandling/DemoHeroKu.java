package windowHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class DemoHeroKu {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/windows");

        String parentWindow = driver.getWindowHandle();

        WebElement clickHere = driver.findElement(By.xpath("//a[.=\"Click Here\"]"));
        clickHere.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

        while(iterator.hasNext()){

            String childWindow = iterator.next();

            if(!childWindow.equals(parentWindow)){

                driver.switchTo().window(childWindow);
                System.out.println("Title: " + driver.getTitle());

                driver.close();
            }
        }
    }
    }
