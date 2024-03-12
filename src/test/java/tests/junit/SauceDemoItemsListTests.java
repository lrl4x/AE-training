package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class SauceDemoItemsListTests{
    /**
     * Navigate to <a href="https://www.saucedemo.com/v1/index.html">SauceDemo</a>
     * login as standard_user
     * assert that there are 6 items on the products list page
     * add the first and last items to the cart
     * navigate to the cart and check that both items are listed
     */
    WebDriver driver;


    @BeforeEach
    public void Setup(){
        driver=new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
    }
    @Test
    public void CheckThatProductListshas6Items(){
        login("standard_user","secret_sauce");
        By ProductItemComponent= By.xpath("//div[@class='inventory_item']");
        int ActualnumberOfProducts = driver.findElements(ProductItemComponent).size();
        Assertions.assertEquals(6,ActualnumberOfProducts);

    }
    @Test
    public void CheckThatTheCartTotalPriceIsCorrect() {
        login("standard_user", "secret_sauce");
        By firstItemButton = By.xpath("(//button[text()='ADD TO CART'])[1]");
        By lastItemButton = By.xpath("(//button[text()='ADD TO CART'])[last()]");


        driver.findElement(firstItemButton).click();
        driver.findElement(lastItemButton).click();

        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");

    }
@Test
    public void CheckThatTheFirstIteminCart(){
        login("standard_user","secret_sauce");
        var firsItem =By.xpath("//div[contains(@class,'inventory_item_name')][1]");
        String item =driver.findElement(firsItem).getText();
        Assertions.assertEquals("Sauce Labs Backpack",item);

    }
    @Test
    public void CheckThatTheLastIteminCart(){
        login("standard_user","secret_sauce");
        var lastItem =By.xpath("(//div[contains(@class,'inventory_item_name')])[last()]");
        String item =driver.findElement(lastItem).getText();
        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)",item);

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
    public void terup(){
        driver.quit();
    }
}


///after ref
//package testpackage;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class ProductPageTask {
//    WebDriver driver;
//
//    @Test
//    public void Check6Product(){
//        login("standard_user","secret_sauce");
//        By product= By.className("inventory_item");
//        int NumberOfProduct= driver.findElements(product).size();
//        Assertions.assertEquals(6,NumberOfProduct);
//
//    }
//
//
//    @Test
//    public void CheckFirstItem(){
//        login("standard_user","secret_sauce");
//        additem(1);
//        additem(6);
//        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
//        Assertions.assertEquals("Sauce Labs Backpack",ItemName(1));
//
//    }
//
//    @Test
//    public void CheckLastItem(){
//        login("standard_user","secret_sauce");
//        additem(1);
//        additem(6);
//        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
//        Assertions.assertEquals("Test.allTheThings() T-Shirt (Red)",ItemName(2));
//
//
//    }
//
//
//    @BeforeEach
//    public void beforeEach(){
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
//    }
//
//
//    @AfterEach
//    public void afterEach(){
//        driver.quit();
//    }
//    private void login(String username, String password){
//        By user_name= By.id("user-name");
//        By user_password= By.id("password");
//        By login= By.id("login-button");
//
//        driver.findElement(user_name).sendKeys(username);
//        driver.findElement(user_password).sendKeys(password);
//        driver.findElement(login).click();
//
//    }
//
//    private void additem(int itemNumber){
//        By addToCart = By.xpath("(//button[contains(@class,'btn_inventory')])["+itemNumber+"]");
//        driver.findElement(addToCart).click();
//    }
//
//    private String ItemName(int itemNumber){
//        By itemname= By.xpath("(//div[@class='inventory_item_name'])["+itemNumber+"]");
//        return driver.findElement(itemname).getText();
//    }
//
//
//}