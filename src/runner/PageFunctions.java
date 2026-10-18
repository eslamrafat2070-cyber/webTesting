
package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public  class  PageFunctions {

    static WebDriver driver;
    public PageFunctions() {
        driver = new ChromeDriver();
    }

    public   void openWebsite() {
        driver.get(
                "https://www.selenium.dev/selenium/web/web-form.html"
        );
    }

    public void Standard_Dropdown_Select(
    ){
   By dropdown  = By.name("my-select");

        Select options = new Select(driver.findElement(dropdown));

        options.selectByIndex(3);

    }
    public void Standard_Dropdown_list_of_elements(
    ){
        By dropdown  = By.xpath("//select[@name='my-select']/option");

       // WebElement dropdownElement = driver.findElement(By.name("my-select"));

        // dropdownElement.click();

        List<WebElement> options = driver.findElements(dropdown);

        options.get(1).click();
    }

    ;
    public void datalist_Dropdown() throws InterruptedException {


        By datalist  = By.name("my-datalist");

        List<WebElement> options = driver.findElements(By.xpath("//datalist[@id='my-options']/option"));

        String optionToSelect = options.get(1).getDomAttribute("value");

        assert optionToSelect != null;
        driver.findElement(datalist).sendKeys(optionToSelect);
        Thread.sleep(2000);
        driver.findElement(datalist).clear();
        driver.findElement(datalist).sendKeys("ali");


    };

    public void getthevalueaftersendkeys() {
        By Testinput = By.id("my-text-id");
        WebElement inputElement = driver.findElement(Testinput);

        inputElement.clear();
        inputElement.sendKeys("Eso is the best one");

        String inputValue = inputElement.getDomProperty("value");
        System.out.println("Input value: " + inputValue);
    }

    public void checkDisplayed() {
         By TEXT_INPUT = By.name("my-disabled");
        WebElement input = driver.findElement(TEXT_INPUT);

        if (input.isDisplayed()) {
            System.out.println("Input is displayed");
        } else {
            System.out.println("Input is hidden");
        }
    }

    public void checkEnabled() {
   By DISABLED_INPUT = By.name("my-readonly");
        WebElement input = driver.findElement(DISABLED_INPUT);

        if (input.isEnabled()) {
            System.out.println("Input is enabled");
        } else {
            System.out.println("Input is disabled");
        }
    }
    public void checkSelected() {
        By CHECKBOX = By.id("my-check-1");
        WebElement checkbox = driver.findElement(CHECKBOX);

        if (checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is not selected");
        }
    }

public  static void main(String[] args) throws InterruptedException {

    PageFunctions example = new PageFunctions();
    example.openWebsite();
    Thread.sleep(2000);
    example.checkSelected();
   // example.checkEnabled();
   // example.checkDisplayed();
  //  example.getthevalueaftersendkeys();
//    example.Standard_Dropdown_Select();
//    Thread.sleep(2000);
//    example.Standard_Dropdown_list_of_elements();
//
//    Thread.sleep(2000);
//
//    example.datalist_Dropdown();
//    Thread.sleep(2000);  / //


    driver.quit();

}


    }




