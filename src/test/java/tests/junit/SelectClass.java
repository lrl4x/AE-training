package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectClass {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }
    @Test
    public void addItemTocart(){
//        By addToCartButtonFirstItem = By.xpath("(//button[text()='ADD TO CART'])[1]");
        By addToCartButtonFirstItem = By.xpath("(//button[@class='btn_primary btn_inventory'][1])");
        driver.findElement(addToCartButtonFirstItem).click();

        By cstlink=By.xpath("//a[@href='./cart.html']");
        driver.findElement(cstlink).click();

//        By getname =By.xpath("//div[@class='inventory_item_name']");
        By inventory_name =By.xpath("//div[contains(@class,'inventory_item_name')]");
        String actualname=driver.findElement(inventory_name).getText();

        String expectedItemName = "Sauce Labs Backpack";
        Assertions.assertEquals(expectedItemName,actualname,"The item name in the cart does not match the expected item name.");

    }

    @AfterEach
    public void tearDown() {
   
            driver.quit();

    }
}
