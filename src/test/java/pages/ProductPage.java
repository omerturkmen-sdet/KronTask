package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductPage extends BasePage{

    @FindBy(css = ".info-panel .product-title")
    private WebElement productTitle;

    @FindBy(css = ".seller-name")
    private WebElement sellerName;

    @FindBy(css = "#option-size a:not(.disabledNotSelected)")
    private List<WebElement> sizeOptionListWithStock;

    @FindBy(id = "pd_add_to_cart")
    private WebElement addToCartBtn;

    @FindBy(css = ".advanced-price")
    private WebElement productPrice;

    public String getProductTitle() {
        return getText(productTitle);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }

    public Map<String, String> getProductInfo() {
        return Map.of(getProductTitle(), getProductPrice());
    }

    public String getSellerName() {
        return getText(sellerName);
    }

    public void selectRandomProductSize() {

    }

    //TODO: Var olan sayıdan daha fazla element gözüküyor bunu kontrol et önce
    public void getProductSizes() {
        for (WebElement element : sizeOptionListWithStock) {
            System.out.println(element.getText());
        }
    }

    //TODO: Beden seçmeden sepete ekleme
    //TODO: Beden seçtikten sonra sepete ekleme

    public void addToCart() {
        click(addToCartBtn);
    }

    public String getAddToCartBtnText() {
        return getText(addToCartBtn);
    }
}
