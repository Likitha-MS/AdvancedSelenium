package vtiger.OrganizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.JavaUtility;
import vtiger.GenericUtilities.PropertyFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.ObjectRepository.CreateNewOrganizationPage;
import vtiger.ObjectRepository.HomePage;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.OrganizationsInfoPage;
import vtiger.ObjectRepository.OrganizationsPage;

public class CreateOrgWithIndustryTest extends BaseClass{

	@Test(groups = "RegressionSuite")
	public void createOrgWithIndustryTest() throws Throwable {
		/* Read from excel file*/
		String ORGNAME = eUtil.readDataFromExcelFile("Organizations", 4, 2)+jUtil.getRandomNumber();
		String INDUSTRY = eUtil.readDataFromExcelFile("Organizations", 4, 3);

		//Click on Organizations
		HomePage hp = new HomePage(driver);
		hp.clickOnOrganizationLink();

		//Click on Organization look up image
		OrganizationsPage op = new OrganizationsPage(driver);
		op.clickOnCreateOrgLookUpImage();

		//Fill in Org name
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);

		//Verify if Organization is created
		OrganizationsInfoPage oip = new OrganizationsInfoPage(driver);
		String OrgHeader = oip.getOrgHeader();
		//using asserts for validation
		Assert.assertTrue(OrgHeader.contains(ORGNAME));
		System.out.println(OrgHeader);
	}
	
	@Test
	public void demo()
	{
		System.out.println("Demo");
	}

}
