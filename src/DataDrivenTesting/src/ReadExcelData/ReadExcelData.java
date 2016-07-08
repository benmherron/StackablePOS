package ReadExcelData;

import lib.ExcelDataConfig;

public class ReadExcelData {

	public static void main(String[] args) {

		//(sheet,row,column)
		ExcelDataConfig excel=new ExcelDataConfig("C:\\Users\\bherron\\ExcelData\\TestData.xlsx");
		
		System.out.println(excel.getData(0, 0, 0));

	}

}
