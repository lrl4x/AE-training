package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedinPartTwo {

    // find the locators of webelements on page https://www.linkedin.com/
    // id, name, className, linkTest, PLinkTest
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.linkedin.com/ ");
    }

    @Test
    public void linkedinElm() {
        //id
        WebElement EmailById = driver.findElement(By.id("session_key"));
        WebElement passwordById = driver.findElement(By.id("session_password"));
        WebElement loginBtnById = driver.findElement(By.cssSelector("button[data-id='sign-in-form__submit-btn']"));

        //name
        WebElement EmailByName = driver.findElement(By.name("session_key"));
        WebElement passwordByName= driver.findElement(By.name("session_password"));

        //className
        WebElement EmailClass=driver.findElement(By.className("grow"));
        WebElement passwordByClass = driver.findElement(By.className("grow"));
        WebElement LoginBtnClass = driver.findElement(By.className("sign-in-form__submit-btn--full-width"));

        //linkTest
        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot password?"));
        WebElement Agr=driver.findElement(By.linkText("User Agreement"));

        //PLinkTest
        WebElement signInLinkPLinkTest=  driver.findElement(By.partialLinkText("User"));
        WebElement forgotPasswordPartialLink = driver.findElement(By.partialLinkText("Forgot"));



    }
    @AfterEach
    public void afterEach(){

        driver.quit();
    }
}
