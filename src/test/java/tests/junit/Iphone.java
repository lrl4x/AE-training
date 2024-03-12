package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Iphone {
//1.Go to https://www.temu.com/.
//2.Type "iphone" in the search bar and click ENTER.
//3.Print the result number.
//4.Click on the first product that appears.
//5.Add to cart.
//6.Click on the cart icon.
//7.Print the product price
//8.Complete your shopping
//9.Turn off the driver.
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        // Make sure you set the path to your WebDriver, e.g., System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.temu.com/");
    }

    @Test
    public void linkedinElm(){
        By search1= By.xpath("//input[@id='searchInput']");
        driver.findElement(search1).sendKeys("women shoes");

        By searchButton=By.xpath("//div[contains(@class,'_3GNb16Eh _1jI74_vj')]");
        driver.findElement(searchButton).click();

        By iphone = By.xpath("//div[contains(@class,'_1TKvD9PP')]");
        String result=driver.findElement(iphone).getText();
        System.out.println(result);

        By firstProduct =By.xpath("(//div[contains(@class,'_2hynzFts autoFitList')][1])");
        driver.findElement(firstProduct).click();

        By addToCart =By.xpath("//button[contains(@class,'_3fKiu5wx _3zN5SumS _1cHCnEMB')]");
        driver.findElement(addToCart).click();

        By size =By.xpath("//div[contains(@class,'HOqyrkhs')]");
        driver.findElement(size).click();

        By add =By.xpath("//div[contains(@class,'_3fKiu5wx _3zN5SumS _11S3t1B3')]");
        driver.findElement(addToCart).click();

        By cart =By.xpath("//div[contains(@class,'_65anZGTH _2QFsVEuv _3AL02FVg')]");
        driver.findElement(cart).click();

        By ProductPrice=By.xpath("//span[contains(@style,'color:#000000;font-size:18px;font-weight:500')]");
        String price=driver.findElement(ProductPrice).getText();
        System.out.println(price);

        driver.navigate().to("https://www.temu.com/");

    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
