package vtiger.practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;

public class CreateOrgWithIndustryUsingGU {

	public static void main(String[] args) throws Throwable {
		
		//Create objects of all utility classes
		JavaUtility jUtil = new JavaUtility();
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		WebDriver driver = null;
		
		/* Read from property file*/
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/* Read from excel file*/
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelFile("Organizations", 4, 3);
		
		//launch the browser  //run time ploymorphism
		if(BROWSER.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("Invalid browser name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);

		//Login to vtiger
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		//Click on Organizations
		driver.findElement(By.linkText("Organizations")).click();

		//Click on Organization look up image
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();

		//Fill in Org name
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);

		//Select from Industry Dropdown
		WebElement industry = driver.findElement(By.name("industry"));
		wUtil.handleDropdown(industry, INDUSTRY);
		
		//Click Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Verify if Organization is created
		String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println("PASS");
			System.out.println(OrgHeader);
		}
		else
		{
			System.out.println("FAIL");
		}

		//Logout of the application
		WebElement AdminLogo = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtil.mouseHoverAction(driver, AdminLogo);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();		
		System.out.println("Logout Successful");

		//CLose browser
		//driver.quit();

	}

}
