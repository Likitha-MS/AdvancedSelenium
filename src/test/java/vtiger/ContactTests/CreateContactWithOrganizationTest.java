package vtiger.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.ContactInfoPage;
import vtiger.ObjectRepository.ContactsPage;
import vtiger.ObjectRepository.CreateNewContactPage;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

@Listeners(vtiger.GenericUtilities.ListenersImplementation.class)
public class CreateContactWithOrganizationTest extends BaseClass {

	@Test(groups = "SmokeSuite")
	public void createContactWithOrganizationTest() throws Throwable {
		/* Read from excel file*/
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts", 4, 2);
		String ORGNAME = eUtil.readDataFromExcelFile("Contacts", 4, 3)+jUtil.getRandomNumber();

		//Create organization first
		//Click on Organizations
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();
		//Low level report
		Reporter.log("Clicked on Organizations Link");

		//Click on Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();
		Reporter.log("Clicked on Organizations Lookup Image");

		//Create Org with mandatory fields 
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		Reporter.log("Organizations Created");
		
		//Verify if Organization is created
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		
		//using asserts for validation
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
		
		//Click on Contacts
		hp.clickOnContactsLink(); 
		Reporter.log("Clicked on Contacts Link");

		//Click on Contacts look up image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactsLookupImage();
		Reporter.log("Clicked on Contacts Lookup Image");

		//create contact with org
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(driver, LASTNAME, ORGNAME);
		Reporter.log("Contact created");

		//Verify if Organization is created
		ContactInfoPage cip = new ContactInfoPage(driver);
		String ContactHeader = cip.getCntHeader();
		
		//using asserts for validation
		Assert.assertTrue(ContactHeader.contains(LASTNAME));
		System.out.println(ContactHeader);
	}
	
	@Test
	public void demo()
	{
		System.out.println("Demo");
	}

}
