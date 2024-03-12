package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeXpath {
     /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * use Selenium Relative Locators to identify the login button
     */
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }
    @Test
    public void main(){
        login("standard_user","secret_sauce");
        By loginButton = RelativeLocator.with(By.tagName("input")).below(By.id("password"));



    }

    public  void login(String username, String password){
        By usernameTextArea = By.id("user-name");
        By passwordTextArea = By.id("password");
        By loginButton = By.id("login-button");

        driver.findElement(usernameTextArea).sendKeys(username);
        driver.findElement(passwordTextArea).sendKeys(password);
        driver.findElement(loginButton).click();
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }

    public static class Exercise {
    }
}
