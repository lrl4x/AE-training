package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertNewTask {
    //Go to URL: http://demo.automationtesting.in/Alerts.html
    //Click "Alert with OK" and click 'click the button to display an alert box:’
    //Accept Alert(I am an alert box!) and print alert on console.
    //Click "Alert with OK & Cancel" and click 'click the button to display a confirm box’
    //Cancel Alert (Press a Button !)
    //Click "Alert with Textbox" and click 'click the button to demonstrate the prompt box’
    //And then sendKeys «Bootcamp» (Please enter your name)
    //Finally print on console this message "Hello Bootcamp How are you today" assertion these message

    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void Alert1(){
        By alertButton= By.xpath("//button[@onclick='alertbox()']");
        driver.findElement(alertButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        System.out.println("Alert("+text+")");
        alert.accept();
    }
    @Test
    public void Alert2(){
        By Alerthref1=By.linkText("Alert with OK & Cancel");
        driver.findElement(Alerthref1).click();

        By AlertButton=By.xpath("//button[@onclick='confirmbox()']");
        driver.findElement(AlertButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.dismiss();
    }
    @Test
    public void Alert3(){
        By Alerthref2 = By.linkText("Alert with Textbox");
        driver.findElement(Alerthref2).click();

        By AlertButton = By.xpath("//button[@onclick='promptbox()']");
        driver.findElement(AlertButton).click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.sendKeys("SDA2036 hamzao sailan");
        alert.accept();

        // Example of how you might find an element that displays the result/message
        // Replace 'resultElementLocator' with the actual locator of the result message element
        By resultElementLocator = By.id("demo1"); // This is a placeholder. Replace it with the actual ID or locator.
        String actualMessage = driver.findElement(resultElementLocator).getText();
        Assertions.assertEquals("Hello SDA2036 hamzao sailan How are you today", actualMessage);
    }


    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //maximized mode
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");
    }
    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
