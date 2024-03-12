package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calculate {
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    @Test
    public void calc(){
        driver.get("https://testpages.eviltester.com/styled/calculator");
//        driver.findElement(By.linkText("Simple Calculator")).click();
        By input1 = By.id("number1");
        driver.findElement(input1).sendKeys("1");

        By input2 = By.id("number2");
        driver.findElement(input2).sendKeys("2");

        By btn = By.id("calculate");
        driver.findElement(btn).click();

        By result = By.id("answer");
        String resultText = driver.findElement(result).getText();
        System.out.println("Result: " + resultText);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
