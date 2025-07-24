package dataReading;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ReadDataFromExcel {

    public static void main(String[] args) throws Exception {


            // Creating a File object pointing to the Excel file (update path as needed)
            File file = new File("File\\Path");

            // Creating a FileInputStream to read from the file
            FileInputStream fis = new FileInputStream(file);

            // Creating a Workbook instance that reads from the input stream (XSSFWorkbook handles .xlsx format)
            XSSFWorkbook workbook = new XSSFWorkbook(fis);

            // Accessing the first sheet (index 0) in the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Reading the value from the first row (row 0) and first column (cell 0)
            String cellValue = sheet.getRow(0).getCell(0).getStringCellValue();

            // Printing the retrieved cell value to the console
            System.out.println(cellValue);

            // Closing the workbook to release resources
            workbook.close();

            // Closing the file input stream
            fis.close();
    }
}
