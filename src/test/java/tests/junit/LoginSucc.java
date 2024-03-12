package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

///**
// * breakout task:
// * <br/> - navigate to this url <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
// * <br/> - do a successful login
// * <br/> - assert that the login is successful
// */
public class LoginSucc {
    private WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver=new ChromeDriver();
    }
    @Test
    public void main(){
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        By username= By.xpath("//input[contains(@id,'user-name')]");
        WebElement usern=driver.findElement(username);
        usern.sendKeys("standard_user");


        By password= By.xpath("//input[contains(@id,'password')]");
        WebElement passw=driver.findElement(password);
        passw.sendKeys("secret_sauce");

        By loginbtn =By.xpath("//input[contains(@id,'login-button')]");
        driver.findElement(loginbtn).click();

        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));


        Assertions.assertTrue(inventoryContainer.isDisplayed(),"login is successful");
    }
    @AfterEach
    public void tearDown() {

        driver.quit();

    }
}
