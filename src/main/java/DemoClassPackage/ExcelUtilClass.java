package DemoClassPackage;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilClass {
    FileInputStream file;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    Object testData[][];

    public ExcelUtilClass(String filePath) throws IOException {
        file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet("Sheet1");
    }

    public int getRowCount(String filePath) throws IOException {

        int rowCount = sheet.getPhysicalNumberOfRows();
        return rowCount;
    }

    public Object[][] getCellStringValue() {
        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
        testData = new Object[rowCount-1][colCount];
        int i=1;
        do{
            int j=0;
            do{
                testData[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
                j++;
            }while (j<colCount);
            i++;
        }while (i<rowCount);
       /* for (int i = 1; i <rowCount; i++) {
            for(int j=0; j<colCount; j++) {
                // String cellString = sheet.getRow(1).getCell(0).getStringCellValue();
                testData[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }*/
        return testData;
    }

}
