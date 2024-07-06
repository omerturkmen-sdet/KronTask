package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class SearchResultPage extends BasePage{

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "product-grid")
    private List<WebElement> productsList;

    private WebElement getRandomProductElement() {
        return productsList.get(new Random().nextInt(productsList.size()));
    }

    private WebElement getProductElement(int index) {
        //TODO: null yerine invalid search exception at
        if (productsList.isEmpty()) return null;
        return index >= productsList.size() ? productsList.get(0) : productsList.get(index);
    }

    public String getProductText(int index) {
        return getText(getProductElement(index));
    }

    public String getProductText() {
        return getText(getRandomProductElement());
    }

    public void selectProduct() {
        click(getRandomProductElement());
        //TODO: Product page return et
    }

    public void selectProduct(int index) {
        click(getProductElement(index));
        //TODO: Product page return et
    }

}
