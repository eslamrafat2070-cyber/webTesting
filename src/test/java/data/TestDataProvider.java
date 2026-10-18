package test.java.data;

import org.testng.annotations.DataProvider;
import utils.ExcelReader;
import utils.ConfigReader;

public class TestDataProvider {

    private static final ConfigReader config =
            new ConfigReader();

    private static final String FILE_PATH =
            config.getProperty("excelPath");

    @DataProvider(name = "webFormData")
    public static Object[][] webFormData() {

        return ExcelReader.getData(
                FILE_PATH,
                "WebForm"
        );
    }
}