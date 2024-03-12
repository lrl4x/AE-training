package tests.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonchk {
    //Task 1:
//Go to URL: https://demoqa.com/radio-button
//Verify whether all 3 options given to the question can be selected.
//When each option is selected, print the following texts on the console.
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.navigate().to("https://demoqa.com/radio-button");
    }

    @Test
    public void verifyAllRadioButtonSelections() {

        By yesRadio=By.xpath("//label[contains(@for,'yesRadio')]");
        driver.findElement(yesRadio).click();
        Boolean b1=driver.findElement(By.id("yesRadio")).isSelected();
        Assertions.assertTrue(b1,"Yes Radio button is not selected");
        String s1=driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        System.out.println(s1);

        By impressiveRadio=By.xpath("//label[contains(@for,'impressiveRadio')]");
        driver.findElement(impressiveRadio).click();
        Boolean b2=driver.findElement(By.id("impressiveRadio")).isSelected();
        Assertions.assertTrue(b2,"Yes Radio button is not selected");
        String s2=driver.findElement(By.xpath("//span[@class='text-success']")).getText();
        System.out.println(s2);

        System.out.println("can't select because it's disabled");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
