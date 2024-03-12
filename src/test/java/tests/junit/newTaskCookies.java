package tests.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

public class newTaskCookies extends Tests{
    /**
     * Breakout task: 15 minutes
     * Navigate to <a href="https://kitchen.applitools.com/ingredients/cookie">Cookies</a>
     * print the total number of cookies
     * add a new "fruit=apple" cookie
     * edit the "protein" cookie to have the value "meat"
     * delete the "veggie" cookie
     * print all cookies
     * delete all cookies
     */
    @Test
    public void cookies(){
        driver.get("https://kitchen.applitools.com/ingredients/cookie");
        var cookies=driver.manage().getCookies();
        System.out.println("the Intial size:"+cookies.size());
        System.out.println("Intial list of cookies:");
        driver.manage().getCookies().forEach(System.out::println);


        driver.manage().addCookie(new Cookie("fruit","apple"));
        driver.manage().addCookie(new Cookie("protein","meat"));
        driver.manage().deleteCookieNamed("veggie");

        System.out.println("Update list of cookies");
        driver.manage().getCookies().forEach(System.out::println);

        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0,driver.manage().getCookies().size());
    }
}

