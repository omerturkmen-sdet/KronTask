package utis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver get(){

        if (driver == null){

        String browser = ConfigReader.get("browser");

            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
                case "firefox" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    public static void close(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
