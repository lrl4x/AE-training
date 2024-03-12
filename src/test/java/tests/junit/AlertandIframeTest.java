package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertandIframeTest extends Tests {
    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://the-internet.herokuapp.com/javascript_alerts">Alerts</a>
     * click on "Click for JS Confirm"
     * Press OK
     * Check that "You clicked: Ok" is displayed
     */

    @Test
    public void alertTest(){
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        By button = By.cssSelector("button[onclick='jsAlert()']");
        driver.findElement(button).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();

        alert.accept();
        Assertions.assertEquals("I am a JS Alert", text);
    }

//    @Test
//    public void basicAuthTest(){
//        driver.navigate().to("https://admin:admin@the-internet.herokuapp.com/basic_auth");
//        By message = By.tagName("p");
//        var actualMessage = driver.findElement(message).getText();
//        Assertions.assertEquals("Congratulations! You must have the proper credentials.", actualMessage);
//    }
   @Test
    public void iframe(){
        //https://www.selenium.dev/selenium/web/click_frames.html
        //assert the value of the h1 element
        driver.navigate().to("https://www.selenium.dev/selenium/web/click_frames.html");
        WebElement iframe =driver.findElement(By.xpath("//frame[@name='source']"));
        driver.switchTo().frame(iframe);
        var headerTest =driver.findElement(By.tagName("h1")).getText();
        Assertions.assertEquals("Testing Clicks",headerTest);

    }
    
}
