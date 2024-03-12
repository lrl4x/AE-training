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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IFrameNewTask {
    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live-selenium-project.html) click here.
    //Exit the iframe and return to the main page.
    WebDriver driver;
    Wait<WebDriver> wait;

    @Test
    public void testIFrames() {
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Number of iFrames: " + iframes.size());

        WebElement iframe =driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
        driver.switchTo().frame(iframe);

        WebElement link =driver.findElement(By.tagName("a"));
        link.click();

        driver.switchTo().defaultContent();
    }



    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // Maximizes the browser window
        driver = new ChromeDriver(chromeOptions);

        driver.get("http://demo.guru99.com/test/guru99home/");
    }

    @AfterEach
    public void afterEach() {
        driver.quit();
    }
}
