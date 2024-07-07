package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class BaseTest{

    public static ExtentReports extent;
    public static ExtentSparkReporter spark;
    public static ExtentTest extentTest;
    public static Scenario scenario;

}
