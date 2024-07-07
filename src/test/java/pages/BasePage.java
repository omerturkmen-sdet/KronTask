package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utis.Driver;

import java.time.Duration;

public class BasePage {
    WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(8));

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
        waitForPageLoad();
    }

    public String getText(WebElement element){
        scroll(element);
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    public void clickWithJS(WebElement element) {
        scroll(element);
        JavascriptExecutor jse = (JavascriptExecutor)Driver.get();
        jse.executeScript("arguments[0].click();", element);
    }

    public void scroll(WebElement element) {
        ((JavascriptExecutor)Driver.get()).executeScript("arguments[0].scrollIntoView({block: \"center\",inline: \"center\",behavior: \"smooth\"});",element);
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void waitForPageLoad() {
        wait.until(webDriver -> "complete".equals(((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState")));
    }
}
