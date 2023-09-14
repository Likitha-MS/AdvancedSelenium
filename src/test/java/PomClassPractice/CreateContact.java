package PomClassPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;

public class CreateContact {

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
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3)+jUtil.getRandomNumber();

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
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		//Click on Contacts
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();
		
		//Click on Contacts look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLookupImage();

		//Create Contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(LASTNAME);

		//Verify if Organization is created
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getCntHeader();
		if(ContactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
			System.out.println(ContactHeader);
		}
		else
		{
			System.out.println("FAIL");
		}

		//Logout of the application
		hp.logoutOfApp(driver);
		System.out.println("Logout Successful");

	}

}
