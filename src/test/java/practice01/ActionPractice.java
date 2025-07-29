package practice01;

import com.beust.ah.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ActionPractice {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://demoqa.com/alerts");

        driver.manage().window().maximize();

        List<WebElement> alertButton = driver.findElements(By.xpath("//*[text()='Click me']"));

        //click first alert

        alertButton.get(0).click();

        Alert alert = driver.switchTo().alert();

        String actualMessage =  alert.getText();

        System.out.println("actual message:" + actualMessage);
        alert.accept();

        driver.switchTo().defaultContent();
        //second alert

        alertButton.get(1).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        Alert alert1 = driver.switchTo().alert();

        System.out.println("actual message:" + alert1.getText());

        alert1.accept();

        driver.switchTo().defaultContent();

        driver.quit();

    }
}
