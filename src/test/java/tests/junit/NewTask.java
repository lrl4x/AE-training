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

import java.util.List;

public class NewTask {
    //https://demoqa.com/select-menu
    //Get all the options of the dropdown
    //print the Options size
    //Print all options
    //Verify the dropdown has option "Black"
    //Print FirstSelectedOptionTest
    //Select option "Yellow"
    WebDriver driver;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions=new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/select-menu");
    }

    @Test
    public void testDropdownOptions(){
        WebElement dropdownElement = driver.findElement(By.id("oldSelectMenu"));
        Select d = new Select(dropdownElement);

        List<WebElement> O=d.getOptions();

        System.out.println(" Sizes -> " + O.size());

//        solution number one print all options
//        Boolean hasBlack=false;
        for (WebElement option : O) {
            System.out.println(option.getText());
            //in this case the loop if find black will stop
//            if (option.getText().equals("Black")){
//                hasBlack=true;
//                break;
//            }
        }

//        boolean hasBlack = O.stream().anyMatch(option -> option.getText().equals("Black"));
        //solution number Two
        boolean hasBlack=O.stream().anyMatch(Op ->Op.getText().equals("Black"));
        Assertions.assertTrue(hasBlack, "Dropdown does not contain option 'Black'.");
//        System.out.println("Dropdown does contain option 'Black'");

        d.selectByVisibleText("Yellow");

        String firstSelectedOption = d.getFirstSelectedOption().getText();
        System.out.println("First Selected Option: " + firstSelectedOption);
//        d.selectByVisibleText("Yellow");
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
//best way to solve the code above ->