package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelFile {

	public static void main(String[] args) throws IOException {
		//open document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//create a sheet
		Sheet sh = wb.createSheet("DemonSlayer");
		//create a row
		Row rw = sh.createRow(0);
		//create a cell
		Cell cl = rw.createCell(2);
		//provide data to be written
		cl.setCellValue("Muzan");
		//open document in java write format
		FileOutputStream fos = new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData.xlsx");
		//write the data
		wb.write(fos);
		System.out.println("Data added");
		//close the workbook
		wb.close();
		System.out.println("Workbook Closed");
		
		
		
	}

}
