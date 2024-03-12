package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exercise {
    /**
     * initialize the browser in maximized mode (using options)
     * navigate to <a href="https://www.selenium.dev/selenium/web/web-form.html">web form test page</a>
     * check the box and validate that it is checked
     * select the radio and validate that it is selected
     * choose an item (by value) from the select dropdown menu and validate that it is selected (by text)
     */
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions =new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); //maximized mode
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void CheckboxN(){
        By Checkbox=By.cssSelector("input#my-check-2");
        driver.findElement(Checkbox).click();
        driver.findElement(Checkbox).click();
        Boolean isChecked =driver.findElement(Checkbox).isSelected();
        Assertions.assertFalse(isChecked);
    }
    @Test
    public void CheckboxP(){
        By Checkbox=By.cssSelector("input#my-check-2");
        driver.findElement(Checkbox).click();
        Boolean isChecked =driver.findElement(Checkbox).isSelected();
        Assertions.assertTrue(isChecked);
    }
    @Test
    public void Radio(){
        By Radio=By.cssSelector("input#my-radio-2");
        driver.findElement(Radio).click();
        Boolean isSelected =driver.findElement(Radio).isSelected();
        Assertions.assertFalse(isSelected);
    }
    @Test
    public void Drop(){
        WebElement dropdownElement = driver.findElement(By.name("my-select"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue("1");
        String selectedOptionText = dropdown.getAllSelectedOptions().getFirst().getText();
        Assertions.assertEquals("One", selectedOptionText, "Dropdown selection does not match expected value.");
    }
    @Test
    public void datalist(){
     By op = By.id("my-options");
     Select n=new Select(driver.findElement(op));
     n.selectByValue("San Francisco");
     String Expected="San Francisco";
     String actual=n.getAllSelectedOptions().getFirst().getText();
     Assertions.assertEquals(Expected,actual);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
