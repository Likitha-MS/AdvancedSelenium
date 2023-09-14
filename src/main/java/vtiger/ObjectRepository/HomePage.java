package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility{
 
	@FindBy(linkText = "Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorLnk;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationLnk() {
		return organizationLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getAdministratorLnk() {
		return administratorLnk;
	}

	public WebElement getSignoutLnk() {
		return signoutLnk;
	}

	/**
	 * This method will logout of the application
	 * @param driver
	 * @throws Throwable 
	 */
	//business library
	public void logoutOfApp(WebDriver driver) throws Throwable
	{
		Thread.sleep(3000);
		mouseHoverAction(driver, administratorLnk);
		Thread.sleep(3000);
		signoutLnk.click();
	}
	
	/**
	 * This method will click on organization link
	 */
	public void clickOnOrganizationLink()
	{
		organizationLnk.click();
	}
	
	/**
	 * This method will click on contacts link
	 */
	public void clickOnContactsLink()
	{
		contactsLnk.click();
	}
	
	/**
	 * This method will click on products link
	 */
	public void clickOnProductsLink()
	{
		productsLnk.click();
	}
	
}
