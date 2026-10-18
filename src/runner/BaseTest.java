package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;

import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;


    @BeforeMethod
    public void setUp() {

        ConfigReader config = new ConfigReader();

        String url = config.getProperty("baseUrl");

        if (url == null || url.isBlank()) {
            throw new IllegalStateException(
                    "baseUrl is missing or empty in config.properties"
            );
        }

        driver = new ChromeDriver();
        driver.manage().window().maximize();

                driver.get(url);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            System.out.println(
                    "Test failed. Browser will stay open for 5 seconds."
            );

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        if (driver != null) {
            driver.quit();
        }
    }
}