package vtiger.practice;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws Throwable {
		
//		PropertyFileUtility pUtil = new PropertyFileUtility();
//		String value = pUtil.readDataFromPropertyFile("browser");
//		System.out.println(value);
//		
//		String value1 = pUtil.readDataFromPropertyFile("username");
//		System.out.println(value1);
//
//		String value2 = pUtil.readDataFromPropertyFile("password");
//		System.out.println(value2);
//		
//		ExcelFileUtility eUtil = new ExcelFileUtility();
//		String val = eUtil.readDataFromExcelFile("Organizations", 4, 3);
//		System.out.println(val);
//		
//		eUtil.writeDataIntoExcelFile("qqq", 1, 3, "tanjiro");
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getRandomNumber());
		
		
		System.out.println(jUtil.getSystemDate());;
	}

}
