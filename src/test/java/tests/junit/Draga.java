package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Draga {
//    Breakout task: 20 minutes
//    navigate to https://www.selenium.dev/selenium/web/droppableItems.html
//    drag the draggable, onto the droppable
//    check that the text now shows "Dropped!"


    WebDriver driver;


    @Test
    public void Draga(){
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();
        By text=By.xpath("//*[@id='droppable']/p");
        Assertions.assertEquals("Dropped!",driver.findElement(text).getText());
    }
    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //maximized mode
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/droppableItems.html");
    }
    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}


