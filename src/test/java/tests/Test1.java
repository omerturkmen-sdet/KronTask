package tests;

import hooks.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.HomePage;

public class Test1 extends BaseTest {

    String url = "https://www.lcw.com/";

    @Test
    public void testtt() {
        driver.get(url);
        homePage = new HomePage(driver);
    }

}
