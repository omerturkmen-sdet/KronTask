package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class SearchResultPage extends BasePage{

    public SearchResultPage() {
        getRandomProduct();
    }

    public Product product;

    @FindBy(css = ".product-grid .product-card__product-info")
    private List<WebElement> productsList;

    @FindBy(css = ".product-recommendation")
    private WebElement recommendedProductLabel;

    @FindBy(css = ".product-card .product-card__title")
    private List<WebElement> productTitleList;

    @FindBy(css = ".product-card__brand-title")
    private List<WebElement> productBrandTitleList;

    @FindBy(css = ".product-card .product-price")
    private List<WebElement> productPriceList;

    public boolean isRecommendedProductsDisplayed() {
        return recommendedProductLabel.isDisplayed();
    }

    public boolean isProductsListed() {
        return productsList.size() != 0;
    }

    private Map<WebElement, Integer> getRandomProductElement() {
        int index = new Random().nextInt(productsList.size());
        return Collections.singletonMap(productsList.get(index), index);
    }

    private WebElement getProductElement(int index) {
        //TODO: null yerine invalid search exception at
        if (productsList.isEmpty()) return null;
        return index >= productsList.size() ? productsList.get(0) : productsList.get(index);
    }

    public void selectProduct() {
        clickWithJS(product.getElement());
        //TODO: Product page return et
    }

    public void getRandomProduct() {
        int index = new Random().nextInt(productsList.size());
        product = new Product(index);
    }

    @Getter
    public class Product {
        private final WebElement element;
        private final int index;
        private final String brandTitle;
        private final String title;
        private final String price;
        private final Map<String,String> info = new HashMap<>();
        public Product(int index) {
            this.index = index;
            element = productsList.get(index);
            brandTitle = getText(productBrandTitleList.get(index));
            title = getText(productTitleList.get(index));
            price = getText(productPriceList.get(index));
            setInfo();
        }
        public void setInfo() {
            info.put(brandTitle + " " + title, price);
        }
    }


}
