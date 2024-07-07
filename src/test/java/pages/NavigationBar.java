package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar extends BasePage{
    public NavigationBar() {
        check();
    }

    private void check() {
        Assert.assertTrue(logo.isDisplayed());
        Assert.assertTrue(searchField.isDisplayed());
    }

    @FindBy(css = ".main-header-logo")
    private WebElement logo;

    @FindBy(id = "search-form__input-field__search-input")
    private WebElement searchField;

    @FindBy(css = ".badge-circle")
    private List<WebElement> productCountAtCart;

    public void searchProduct(String searchKey) {
        searchField.sendKeys(searchKey + Keys.ENTER);
    }

    public String  getProductCountAtCart() {
        wait(2);
        return productCountAtCart.size() == 0 ? "0" : getText(productCountAtCart.get(0));
    }

}
