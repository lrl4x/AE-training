package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WindowType;

import java.util.Set;

public class WindoeTest extends Tests{
    @Test
    public void WindowTest(){
        driver.navigate().to("https://www.selenium.dev/");
        var orginalWindowHandle =driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> Handels=driver.getWindowHandles();
        Handels.remove(orginalWindowHandle);
        String newWindowHandle =(String) Handels.toArray()[0];

        driver.switchTo().window(orginalWindowHandle);
        driver.switchTo().window(newWindowHandle);

        driver.navigate().to("https://www.saucedemo.com/v1/index.html");
        driver.navigate().back();
        driver.navigate().forward();

        driver.switchTo().window(orginalWindowHandle);
        Assertions.assertEquals("https://www.selenium.dev/",driver.getCurrentUrl());
    }
}
