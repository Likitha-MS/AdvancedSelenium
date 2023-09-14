package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {

	public static void main(String[] args) throws IOException {
		//open document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		//create a workbook
		Workbook wb = WorkbookFactory.create(fis);
		//navigate to required sheet
		Sheet sh = wb.getSheet("Contacts");
		//navigate to required row
		Row rw = sh.getRow(1);
		//navigate to required cell
		Cell cl = rw.getCell(2);
		//read data inside the cell
		String val = cl.getStringCellValue();
		System.out.println(val);
		//close the workbook
		wb.close();
	}

}
