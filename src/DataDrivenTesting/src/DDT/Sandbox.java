package DDT;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import lib.ExcelDataConfig;

 
public class Sandbox {
 
	public static void main(String[] args) throws IOException {
	
	FileInputStream fis=new FileInputStream("C:\\Users\\bherron\\ExcelData\\stackableImport.xlsx");
	
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	
	XSSFSheet s=wb.getSheet("data");
	
	Iterator<Row> rowIt=s.iterator();
	
	rowIt.next();
	
	while(rowIt.hasNext()) {
		
	System.out.println(rowIt.next().getCell(3).getStringCellValue());
	}
	}
	
	
	

}

	