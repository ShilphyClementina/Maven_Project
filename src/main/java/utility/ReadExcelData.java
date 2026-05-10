package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadExcelData {

    public static String readParticularData(int rowval, int colval){
        String data = null;
        try {
            File file = new File("D:\\Shilphy\\Testing\\Automation testing - Greens technologies\\IPT\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");
            Row row = sheet.getRow(rowval);
            Cell cell = row.getCell(colval);
            //String data = cell.getStringCellValue();
            //System.out.println(data);

            //sendKeys will not allow integer so convert to string

            DataFormatter dataFormat = new DataFormatter();
            data = dataFormat.formatCellValue(cell);

        }catch (Exception e){
            e.printStackTrace();
        }
        return data;
    }

    public static void getAllData(){
        try {
            File file = new File("D:\\Shilphy\\Testing\\Automation testing - Greens technologies\\IPT\\DataDriven_IPT.xlsx");
            Workbook book = new XSSFWorkbook(file);
            Sheet sheet = book.getSheet("Sheet1");
            //To get the total number of rows
            int lastRowNum = sheet.getLastRowNum();
            System.out.println("No.of Rows" + lastRowNum);

            // To get the total num of column, first go to the row
            short lastColNum = sheet.getRow(0).getLastCellNum();
            System.out.println("No.of Columns" + lastColNum);

            for (int row = 0; row <lastRowNum; row++){
                Row rows = sheet.getRow(row);

                for (int column=0; column<lastColNum; column++){
                    Cell cell = rows.getCell(column);
                    // DataFormatter --> it will convert the cell datatype in to string
                    DataFormatter dataFormat = new DataFormatter();
                    String data = dataFormat.formatCellValue(cell);
                    System.out.println(data);
            }
            }

           //To get particular row/column
            Row row = sheet.getRow(0);
            Cell cell = row.getCell(1);
            // DataFormatter --> it will convert the cell datatype in to string
            DataFormatter dataFormat = new DataFormatter();
            String data = dataFormat.formatCellValue(cell);
            System.out.println(data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main (String[] args){
        getAllData();

    }
}
