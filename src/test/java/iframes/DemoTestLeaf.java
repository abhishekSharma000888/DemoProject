import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class DemoTestLeaf {

    public static void main(String[] args) {

        String url = "https://www.leafground.com/frame.xhtml";

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Switch to the first frame by index
        driver.switchTo().frame(0);

        // Find the button inside the frame
        WebElement clickMeButton = driver.findElement(By.xpath("//button[@id='Click']"));

        // Click the button
        clickMeButton.click();

        String expectedMessage = "Hurray! You Clicked Me.";
        String actualMessage = clickMeButton.getText();

        Assert.assertEquals(actualMessage,expectedMessage,"The messages mismatched!");

        driver.quit();

    }
}
