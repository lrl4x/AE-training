package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class iFrameExampleRegistrationForm {
    WebDriver driver;
    Wait<WebDriver> wait;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //maximized mode
        driver = new ChromeDriver(chromeOptions);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().to("https://clarusway.getlearnworlds.com/sda-test-registration-form");
    }

//    @Test
//    public void FirstNameAndLastName(){
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//        By FirstName= By.xpath("//input[@elname='First']");
//        driver.findElement(FirstName).sendKeys("SDA2036 Hamza");
//
//        By LastName= By.xpath("//input[@elname='Last']");
//        driver.findElement(LastName).sendKeys("Osailan");
//
//    }
//    @Test
//    public void Radio() {
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//        By radioBtn=By.xpath("//label[contains(@for,'Radio_1')]");
//        driver.findElement(radioBtn).click();
//    }
//
//    @Test
//    public void Dropdown() {
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//
//        WebElement dropdown = driver.findElement(By.cssSelector(".drpDwnPlaceholder")); // Correctly target the dropdown element
//        dropdown.click();
//
//        WebElement firstChoice =driver.findElement(By.cssSelector(".select2FormFont"));
//        firstChoice.click();
//
//    }
//    @Test
//    public void SingleLine(){
//        System.out.println("disabled for test purposes");
//    }
//    @Test
//    public void Checkbox(){
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//        By Checkbox=By.xpath("//label[@for='Checkbox_1']");
//        driver.findElement(Checkbox).click();
//    }
//    @Test
//    public void RatingAndSubmitForm() {
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//
//        WebElement element = driver.findElement(By.xpath("//a[@rating_value='5']"));
//        element.click();
//
//
//    }
//
//
//    @Test
//    public void submit(){
//        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
//        driver.switchTo().frame(iframe);
//        By sum = By.xpath("//button[@value='submit']/em");
//        driver.findElement(sum).click();
//    }

    @Test
    public void main(){
        WebElement iframe=driver.findElement(By.xpath("//*[@id='el_1706889795510_354']/iframe"));
        driver.switchTo().frame(iframe);
        By FirstName= By.xpath("//input[@elname='First']");
        driver.findElement(FirstName).sendKeys("SDA2036 Hamza");

        By LastName= By.xpath("//input[@elname='Last']");
        driver.findElement(LastName).sendKeys("Osailan");

        By radioBtn=By.xpath("//label[contains(@for,'Radio_1')]");
        driver.findElement(radioBtn).click();

        WebElement dropdown = driver.findElement(By.cssSelector(".drpDwnPlaceholder"));
        dropdown.click();

        WebElement s = driver.findElement(By.xpath("//input[@type='search']"));
        s.sendKeys("F", Keys.ENTER);


        System.out.println("disabled for test purposes");

        By Checkbox=By.xpath("//label[@for='Checkbox_1']");
        driver.findElement(Checkbox).click();

        WebElement element = driver.findElement(By.xpath("//a[@rating_value='5']"));
        element.click();

        WebElement submit = driver.findElement(By.xpath("//button[@value='submit']"));
        submit.click();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

}
