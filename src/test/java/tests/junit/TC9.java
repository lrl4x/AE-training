package tests.junit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class TC9 {
//// TC - 09
//// Go to w3school homepage
    //// https://www.w3schools.com/
//// Do the following tasks by creating 3 different test methods.
//*- Print "STARTED" before all test() methods run
//*- Print "FINISHED" after all test() methods run.
//            *- Before all test() methods run, print "Test has started"
//            *- Print "method name + running" in all test methods
//*- After all test() methods run, print "Test finished"
//// Test if the title contains "w3school" when the page window is minimize
//// Test if the title does not contain "boss" when the page window is fullscreen
    protected static WebDriver driver;
    protected Wait<WebDriver> wait;
    protected static Logger logger;

    @BeforeEach
    public  void beforeEach(){
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(TC9.class.getName());
        driver =new ChromeDriver();
        String Url ="https://www.w3schools.com/";
        driver.navigate().to(Url);
        logger.info("STARTED");

    }

    @Test
    public void Test1(){
        logger.info("Test has started");
        logger.info("Test1 " + " running");
        driver.manage().window().minimize();
        Assertions.assertTrue(driver.getTitle().contains("W3School"));
    }
    @Test
    public void Test2(){
        driver.manage().window().fullscreen();
        Assertions.assertFalse(driver.getTitle().contains("boss"));
        logger.info("Test finished");
    }

    @AfterEach
    public void afterEach(){
        logger.info("FINISHED");
        driver.quit();
    }
}
