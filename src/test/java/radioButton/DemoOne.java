package radioButton;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoOne {

    public static void main(String[] args) {

        String url = "https://demo.guru99.com/test/radio.html";

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);

        WebElement option1 = driver.findElement(By.xpath("//input[@id=\"vfb-7-1\"]"));

        option1.click();

        if(option1.isSelected()){

            System.out.println("The webelement is selected: ");
        } else{

            System.out.println("The webelement is  not selected! ");

        }

        driver.quit();
    }
}
