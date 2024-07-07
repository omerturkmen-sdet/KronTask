package utis;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver(){}

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver get(){

        String browser = ConfigReader.get("browser");

        if (driver.get() == null){
            switch (browser) {
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                }
                case "firefox" -> {
                    WebDriverManager.safaridriver().setup();
                    driver.set(new SafariDriver());
                }
            }
        }
        return driver.get();
    }

    public static void close(){
        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}
