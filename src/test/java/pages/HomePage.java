package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
        navigationBar = new NavigationBar(driver);
    }

    NavigationBar navigationBar;

}
