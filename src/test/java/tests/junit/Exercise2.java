package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Exercise2 {
    /**
     * Use Google Chrome
     * Navigate to <a href="https://www.google.com/">Google.com</a>
     * Search for "Selenium"
     * Check that results stats is not empty
     * Change to using Firefox
     */
    WebDriver driver;

    Wait<WebDriver> wait;

    @BeforeEach
    public void setUp(){
        //FirefoxOptions firefoxOptions =new FirefoxOptions();
        //firefoxOptions.addArguments("--start-maximized"); //maximized mode
        driver = new FirefoxDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        wait=new WebDriverWait(driver, Duration.ofSeconds(8));
//        wait= new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(333))
//                .pollingEvery(Duration.ofMillis(300))
//                .ignoring(ElementNotInteractableException.class);

        driver.manage().window().maximize(); // Maximize window
        driver.navigate().to("https://www.google.com/");

    }
    @Test
    public void datalist() throws InterruptedException{
        By search =By.id("APjFqb");
        driver.findElement(search).sendKeys("Selenium"+ Keys.ENTER);
        Thread.sleep(2000);
        By result = By.id("result-stats");

//        wait.until(d -> driver.findElement(result).isDisplayed());
//        wait.until(
//                d -> {
//                    driver.findElement(search).isDisplayed();
//                    return true;
//                });
//
        String actual = driver.findElement(result).getText();
        Assertions.assertNotEquals("", actual);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
