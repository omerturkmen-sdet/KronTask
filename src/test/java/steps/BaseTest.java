package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchResultPage;

public class BaseTest{

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest extentTest;
    public static Scenario scenario;
    protected HomePage homePage;
    protected SearchResultPage searchResultPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

}
