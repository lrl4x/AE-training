package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Slider extends Tests{
//    Breakout task: 20 minutes
//    navigate to: https://rangeslider.js.org/
//    scroll to the right until you reach 700
//            assert that the number says 700
@BeforeEach
public void beforeEach(){
    ChromeOptions chromeOptions = new ChromeOptions();
    chromeOptions.addArguments("start-maximized");
    driver = new ChromeDriver(chromeOptions);
    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    driver.navigate().to("https://rangeslider.js.org/");

}
    @Test
    public void dragHorizontally(){

        WebElement item = driver.findElement(By.className("rangeslider__handle"));
        new Actions(driver)
                .clickAndHold(item)
                .moveByOffset(210,0)
                .release()
                .perform();

        WebElement Output=driver.findElement(By.xpath("//output[@id='js-output']"));
        String result=Output.getText();
        Assertions.assertEquals("700",result,"the number is not 700");
    }

}
