package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utis.Driver;

import java.time.Duration;

public class BasePage {
    WebDriverWait wait;

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
        wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(8));
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public String getText(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void clickWithJS(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("arguments[0].click();", element);
    }
}
