package runner;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class runner1 {

    private  static   By CHECKBOXES  = By.name("my-check");
 private static  By daatlist = By.name("my-select");
 private static By dynamiclist =   By.xpath("//input[@name='my-datalist']");
 private static  WebDriverWait wait ;
 private static By dynamicoptions = By.xpath("//datalist[@id='my-options']/option");
 private static List<WebElement> listt;
 


    public static void main(String[] args)
            throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        try {
        	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(
                "https://www.selenium.dev/selenium/web/web-form.html"
            );

   

            // Find one element
            WebElement Box = driver.findElement(CHECKBOXES);
            Box.click();

            Thread.sleep(2000);
   
            // Find multiple elements
            List<WebElement> checkboxes =
                driver.findElements(CHECKBOXES);

            Thread.sleep(2000);
          
            checkboxes.get(1).click();
           
            System.out.println(
                "Checkbox count: " + checkboxes.size()
            );
            
            Select Selector = new Select(driver.findElement(daatlist));
            
            Selector.selectByIndex(2);
            
            
      
            wait.until(ExpectedConditions.visibilityOfElementLocated(dynamiclist)).click();
            
            Thread.sleep(2000);
             
            wait.until(ExpectedConditions.visibilityOfElementLocated(dynamiclist)).click();
            
            
            listt = driver.findElements(dynamicoptions);
            
            int name = listt.size();
            
            String  city= listt.get(2).getDomAttribute("value");
             
            driver.findElement(dynamiclist).sendKeys(city);
            
            
            System.out.println(
                    "Checkbox count: " + city
                );
        } finally {
            driver.quit();
        }
    }
}