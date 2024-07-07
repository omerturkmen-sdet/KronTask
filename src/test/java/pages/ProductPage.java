package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class ProductPage extends BasePage{

    public ProductPage() {
        navigationBar = new NavigationBar();
        clickWithJS(productTitle);
    }

    public NavigationBar navigationBar;

    @FindBy(css = ".title-info .product-code")
    private WebElement productCode;

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

    public String getProductCode() {
        String[] split = getText(productCode).trim().replace("Ürün Kodu:\n", "").split(" - ");
        return split[0] + " - " + split[1];
    }

    public void selectProductSize() {
        clickWithJS(
                sizeOptionListWithStock.get(
                new Random().nextInt(sizeOptionListWithStock.size()
                )));
    }

    public void addToCart() {
        clickWithJS(addToCartBtn);
        wait.until(driver -> {
            String readyState = getText(addToCartBtn);
            return "SEPETE EKLENDİ".equals(readyState) || "LÜTFEN BEDEN SEÇİNİZ".equals(readyState);
        });
    }

    public String getAddToCartBtnText() {
        return getText(addToCartBtn);
    }
}
