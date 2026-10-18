package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebFormPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final FluentWait<WebDriver> fluentWait;

    // Locators
    private final By pageHeading = By.tagName("h1");
    private final By textInput = By.name("my-text");
    private final By submitButton = By.cssSelector("button");
    // Constructor
    public WebFormPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)  // explicit wait
        );
        this.fluentWait
                 = new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(10))
                        .pollingEvery(Duration.ofMillis(500))
                        .ignoring(NoSuchElementException.class);
    }

    // Page methods
    public String getPageHeading() {

        return  wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeading)).getText();
    }
    public void enterText(String text) {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(textInput)
        );

        WebElement input = driver.findElement(textInput);

        input.clear();
        input.sendKeys(text);
    }

    public String getEnteredText() {

        WebElement input = driver.findElement(textInput);

        return input.getDomProperty("value");
    }

    public void clickSubmit() {


       WebElement button = fluentWait.until(ExpectedConditions.elementToBeClickable(submitButton));
        button.click();
    }
}