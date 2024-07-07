package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utis.Driver;

public class Hooks extends BaseTest{

    @BeforeAll
    public static void beforeAll() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("test-output/SparkReport/Spark.html");
    }

    @Before
    public void setUp(Scenario scenario){
        BaseTest.scenario = scenario;
        extentTest = extent.createTest(scenario.getName());
        extent.attachReporter(spark);
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        //TODO: Burası için senaryo statusunu düzgün logla
        extentTest.log(extentTest.getStatus(), scenario.getName());
/*        if (scenario.getStatus() == Status.PASSED) {
            extentTest.pass("Passed baby");
        } else if(scenario.getStatus() == Status.FAILED) {
            extentTest.fail("Failed baby");
        } else {
            extentTest.info("It didn't found");
        }*/

        TakesScreenshot ts = (TakesScreenshot) Driver.get();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "github");

        Thread.sleep(2000);
        Driver.close();
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }
}
