package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class Xpathestra {
    /**
     * Navigate to <a href="https://www.w3schools.com/html/html_tables.asp">w3schools tables</a>
     * check that the Contact for "Alfreds Futterkiste" company is "Maria Anders"
     * check that the Contact for "Island Trading" company is "Helen Bennett"
     */
    WebDriver driver;
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().minimize();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");

    }
    @Test
    public void CheckContactNameTargetcampany1(){
        refCheckContactNameTargetcampany("Alfreds Futterkiste", "Maria Anders");
        refCheckContactNameTargetcampany("Island Trading", "Helen Bennett");
    }
    public void refCheckContactNameTargetcampany(String data ,String expectedContactName){
        By CheckContactNameTargetcampany=By.xpath("//tr[contains(.,'"+data+"')]/td[2]");
//      By CheckContactNameTargetcampany=RelativeLocator.with(By.tagName("tr")).below(By.xpath("//td[text()='Contact']"));
        var actul= driver.findElement(CheckContactNameTargetcampany).getText();
        Assertions.assertEquals(expectedContactName,actul);

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
