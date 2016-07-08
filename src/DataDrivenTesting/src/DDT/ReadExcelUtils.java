package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelUtils {

    public static void main(String[] args) throws IOException{
	

        String fileName = "C:\\Users\\bherron\\ExcelData\\stackableImport.xlsx";
        String cellContent = "D1Y";
        int rownr=0, colnr = 0;

        InputStream input = new FileInputStream(fileName);

        XSSFWorkbook wb = new XSSFWorkbook(input);
        XSSFSheet sheet = wb.getSheetAt(0);

        rownr = findRow(sheet, cellContent);

        output(sheet, rownr, colnr);

        finish();
    }

    private static void output(XSSFSheet sheet, int rownr, int colnr) {
        /*
         * This method displays the associated Model Number
         */

        XSSFRow row = sheet.getRow(rownr);
        XSSFCell cell = row.getCell(colnr);

                System.out.println("Model Number: " + cell);           
    }

    private static int findRow(XSSFSheet sheet, String cellContent) {
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                    if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
                        return row.getRowNum();  
                    }
                }
            }
        }               
        return 0;
    }

    private static void finish() {

        System.exit(0);
    }
}   
	
	
 