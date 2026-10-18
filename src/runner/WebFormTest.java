package runner;

import pages.WebFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.java.data.TestDataProvider;

public class WebFormTest extends BaseTest {

    @Test
    public void verifyPageHeading() {

        WebFormPage page = new WebFormPage(driver);

        String actualHeading = page.getPageHeading();

        Assert.assertEquals(
                actualHeading,
                "Web form",
                "Page heading is incorrect"
        );
    }

    @Test
    public void verifyTextInput() {
        WebFormPage webFormPage =
                new WebFormPage(driver);

        webFormPage.enterText("Eslam");

        String actualText =
                webFormPage.getEnteredText();

        Assert.assertEquals(
                actualText,
                "Eslam",
                "Text was not entered correctly"

        );
    }
    @Test
    public void submitForm() {

        WebFormPage webFormPage =
                new WebFormPage(driver);

        webFormPage.enterText("Eslam");
        webFormPage.clickSubmit();

        Assert.assertTrue(
                driver.getCurrentUrl().contains(
                        "submitted-form.html"
                ),
                "Form was not submitted successfully"
        );
    }

    @Test(
            dataProvider = "webFormData",
            dataProviderClass = TestDataProvider.class
    )
    public void verifyTextInputFromExcel(
            String testCase,
            String inputText,
            String expectedText) {

        System.out.println(
                "Executing test case: " + testCase
        );

        WebFormPage webFormPage =
                new WebFormPage(driver);

        webFormPage.enterText(inputText);

        String actualText =
                webFormPage.getEnteredText();

        Assert.assertEquals(
                actualText,
                expectedText,
                "Text is incorrect for " + testCase
        );
    }
}