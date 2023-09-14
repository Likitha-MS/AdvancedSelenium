package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of generic/reusable methods related to excel file
 * @author LIKITHA
 * 
 */
public class ExcelFileUtility {

	/**
	 * This method reads data from excel file and returns the value to caller
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return value
	 * @throws Throwable
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
	
	/**
	 * This method will write data into excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws Throwable
	 */
	public void writeDataIntoExcelFile(String sheetName, int rowNum, int cellNum, String data) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.createSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(data);
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	/**
	 * This method will read multiple data from excel file for the sheet provided
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] readMutlipleDataFromExcel(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum(); //since we can't directly goto cell, we need to go to row so we use getRow(0)
		
		Object[][] data = new Object[lastRow][lastCell];
		
		for (int i = 0; i < lastRow; i++) //row navigation
		{
			for (int j = 0; j < lastCell; j++) //cell navigation
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue(); //i+1 to skip the header, so row will start from 1 not 0
			}
		}
		
		return data;
	}
}
