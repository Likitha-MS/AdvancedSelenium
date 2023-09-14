package vtiger.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//Read data from property file
		//open document in java readable format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties"); 
		//create object of properties class
		Properties pro = new Properties();
		//load document into properties class
		pro.load(fis);
		//provide key and read the value
		String BROWSER = pro.getProperty("url");
		System.out.println(BROWSER);
		
		//write data into properties file
		Properties prop = new Properties();
		prop.setProperty("url2", "https://www.amazon.in/");
		//create new file or given file will be rewritten
		prop.store(new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\WriteDataToPropertiesFile.properties"), null);
	}

}
