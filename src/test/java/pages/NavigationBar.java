package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends BasePage{
    public NavigationBar(WebDriver driver) {
        super(driver);
        check();
    }

    private void check() {
        Assertions.assertTrue(logo.isDisplayed());
        Assertions.assertTrue(searchField.isDisplayed());
    }

    @FindBy(css = ".main-header-logo")
    private WebElement logo;

    @FindBy(id = "search-form__input-field__search-input")
    private WebElement searchField;

    public void searchProduct(String searchKey) {
        searchField.sendKeys(searchKey + Keys.ENTER);
    }
}
