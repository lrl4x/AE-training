package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkedinPartOne {
    //second
//    Go to URL: https://www.linkedin.com/
//    Locate the "Email or phone", "password", "Sign in" button using absolute xpath and relative xpath
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.linkedin.com/ ");
    }

    @Test
    public void linkedinElm(){


        //absolute xpath
        WebElement emailByAbsoluteXPath = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[1]/div/div/input"));
        WebElement passwordByAbsoluteXPath = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[1]/div[2]/div/div/input"));
        WebElement signInButtonByAbsoluteXPath = driver.findElement(By.xpath("/html/body/main/section[1]/div/div/form/div[2]/button"));


        //relative xpath
        WebElement emailByRelativeXPath = driver.findElement(By.xpath("//input[@id='session_key']"));
        WebElement passwordByRelativeXPath = driver.findElement(By.xpath("//input[@id='session_password']"));
        WebElement signInButtonByRelativeXPath = driver.findElement(By.xpath("//button[contains(@class, 'sign-in-form__submit-btn')]"));


    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
