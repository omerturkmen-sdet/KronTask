package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.*;
import utis.ConfigReader;
import utis.Driver;

public class StepDefinitions extends BaseTest{
    private HomePage homePage;
    private SearchResultPage searchResultPage;
    private String searchKey;
    private ProductPage productPage;
    private SearchResultPage.Product selectedProduct;

    @Given("User navigates home page")
    public void user_navigates_home_page() {
        extentTest.log(extentTest.getStatus(), "User navigates home page");
        Driver.get().get(ConfigReader.get("website_url"));
        homePage = new HomePage();
    }

    @When("User searches {string} on search bar")
    public void userSearchesOnSearchBar(String searchKey) {
        extentTest.log(extentTest.getStatus(), "asd");
        this.searchKey = searchKey;
        homePage.navigationBar.searchProduct(searchKey);
    }

    @Then("Verify that user landed on result page")
    public void verifyThatUserLandedOnResultPage() {
        searchResultPage = new SearchResultPage();
        Assert.assertTrue(Driver.get().getCurrentUrl().contains(searchKey));
    }

    @And("Verify that products are listed related with search key")
    public void verifyThatProductsAreListedRelatedWithSearchKey() {
        Assert.assertTrue("No product listed after search", searchResultPage.isProductsListed());
    }

    @And("Verify that no products listed and proper page displayed")
    public void verifyThatNoProductsListedAndProperPageDisplayed() {
        Assert.assertFalse("Product listed with meaningless search key", searchResultPage.isProductsListed());
        Assert.assertTrue("Recommended products are not displayed!", searchResultPage.isRecommendedProductsDisplayed());
    }

    @When("User select random product from the list")
    public void userSelectRandomProductFromTheList() {
        selectedProduct = searchResultPage.product;
        searchResultPage.selectProduct();
    }

    @Then("Verify that user landed on product page")
    public void verifyThatUserLandedOnProductPage() {
        productPage = new ProductPage();
    }


    @And("Verify that product info are match with the previous page")
    public void verifyThatProductInfoAreMatchWithThePreviousPage() {
        Assert.assertEquals(selectedProduct.getInfo(), productPage.getProductInfo());
    }
}
