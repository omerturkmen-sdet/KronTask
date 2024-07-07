package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage{

    @FindBy(css = ".rd-cart-item-code")
    private WebElement productCode;

    @FindBy(css = ".rd-cart-item-price")
    private WebElement productPrice;

    @FindBy(css = ".main-button")
    private WebElement proceedToCheckoutBtn;

    @FindBy(css = ".desktop-price-info .info-row div span")
    private List<WebElement> orderSummaryList;

    public Map<String,String> getOrderSummary() {
        Map<String,String> orderSummary = new HashMap<>();

        for (int i=0; i< orderSummaryList.size()-1; i+=2) {
            orderSummary.put(
                    getText(orderSummaryList.get(i)),
                    getText(orderSummaryList.get(i+1)
                    ));
        }
        return orderSummary;
    }

    public String getProductCode() {
        return getText(productCode);
    }

    public String getProductPrice() {
        return getText(productPrice);
    }
}
