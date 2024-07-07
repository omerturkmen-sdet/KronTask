package steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import utis.Driver;

import java.time.Duration;

public class Hooks extends BaseTest{

    @BeforeAll
    public static void beforeAll() {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target/Spark/Spark.html");
    }

    @Before
    public void setUp(Scenario scenario){
        BaseTest.scenario = scenario;
        extentTest = extent.createTest(scenario.getName());
        extent.attachReporter(spark);
        //Driver.get().manage().window().maximize();
        //Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

//TODO:Buraya bak. Faydalı olabilir
/*
        try {
            testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured : Click on the link to see message"
                    + "</font>" + "</b >" + "</summary>" + "<br>" + "<h6>" + "<b>" + BasePage.returnLocator(message) +  "</b>"+ "</h6>" + "</br>" + message.replaceAll(",", "<br>")+"</details>"+" \n");
            addScreenShotsOnFailure();
        }
        catch(Exception e) {
        }
 */
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

        //TODO: Remove this wait
        //extent.flush();
        Thread.sleep(2000);
        Driver.close();
    }

    @AfterAll
    public static void afterAll() {
        extent.flush();
    }
}
