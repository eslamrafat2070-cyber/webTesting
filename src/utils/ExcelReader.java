package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

public class ExcelReader {

    public static Object[][] getData(
            String filePath,
            String sheetName) {

        try (
                FileInputStream fileInputStream =
                        new FileInputStream(filePath);

                Workbook workbook =
                        WorkbookFactory.create(fileInputStream)
        ) {

            Sheet sheet =
                    workbook.getSheet(sheetName);

            int rowCount =
                    sheet.getPhysicalNumberOfRows() - 1;

            int columnCount =
                    sheet.getRow(0).getLastCellNum();

            Object[][] data =
                    new Object[rowCount][columnCount];

            DataFormatter formatter =
                    new DataFormatter();

            for (int rowIndex = 1;
                 rowIndex <= rowCount;
                 rowIndex++) {

                Row currentRow =
                        sheet.getRow(rowIndex);

                for (int columnIndex = 0;
                     columnIndex < columnCount;
                     columnIndex++) {

                    data[rowIndex - 1][columnIndex] =
                            formatter.formatCellValue(
                                    currentRow.getCell(columnIndex)
                            );
                }
            }

            return data;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Could not read Excel file: " + filePath,
                    e
            );
        }
    }
}