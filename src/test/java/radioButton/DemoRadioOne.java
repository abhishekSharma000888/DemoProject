package radioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class DemoRadioOne {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        driver.get("https://letcode.in/radio");

        List<WebElement> selectAButton = driver.findElements(By.xpath("//input[@type=\"radio\"]"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        selectAButton.get(0).click();

        if(selectAButton.get(0).isSelected()){

            System.out.println("The radio button has been selected!");
        }

        driver.quit();
    }
}
